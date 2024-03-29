package menu;

import classes.Class;
import classes.Student;
import data.ClassesData;
import enums.EnrollmentStatus;
import utils.Scan;

import java.util.ArrayList;

public class StudentActions {
    public static void menu(Student currentStudent) {
        try {
            int optionSelected;
            do {
                System.out.println("\nALUNO: " + currentStudent.getName() );
                System.out.println("+--------------------------------+");
                System.out.println("|                                |");
                System.out.println("| (1) - Meu(s) Cursos            |");
                System.out.println("| (2) - Matricular em novo Curso |");
                System.out.println("| (3) - Abandonar curso          |");
                System.out.println("| (4) - Alterar Matrícula        |");
                System.out.println("|                                |");
                System.out.println("+--------------------------------+");
                System.out.println("| (0) - Voltar para o Login      |");
                System.out.println("+--------------------------------+");
                System.out.print("Selecione uma opção: ");

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        listClasses(currentStudent, true);
                        break;
                    case 2:
                        addClassMenu(currentStudent);
                        break;
                    case 3:
                        removeClassMenu(currentStudent);
                        break;
                    case 4:
                        changeEnrollmentMenu(currentStudent);
                        break;
                    case 0:
                        System.out.println("Deslogado com sucesso!");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);

        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    private static ArrayList<Class> listClasses(Student currentStudent) {
        return listClasses(currentStudent, false);
    }

    private static ArrayList<Class> listClasses(Student currentStudent, boolean showEnrollment) {
        ArrayList<Class> classes = ClassesData.getStudentClasses(currentStudent);

        System.out.println("Suas turmas:");

        if (!classes.isEmpty()) {
            for (int i = 0; i < classes.size(); i++) {
                Class currentClass = classes.get(i);
                int index = i + 1;

                String enrollmentString = "";
                if (showEnrollment) {

                    enrollmentString = " - " + EnrollmentStatus.getTranslatedStatusNameFromIndex(EnrollmentStatus.valueOf(String.valueOf(currentClass.getEnrollmentStatus(currentStudent).toString())));
                }
                System.out.println(index + ". " + currentClass.getName() + enrollmentString);
            }
        } else {
            System.out.println("Você ainda não está matriculado em nenhuma turma.");
        }
        return classes;
    }

    private static void addClassMenu(Student currentStudent) {
        ArrayList<Class> availableClasses = ClassesData.getClassesWithoutStudent(currentStudent);

        if (availableClasses.isEmpty()) {
            System.out.println("Que pena não existe nenhuma turma disponível para matrícula no momento!");
            System.out.println("Fique de olho em nossas redes sociais ou contate nosso suporte no email: universidadealtf4@sesi.com.br");
            return;
        }

        System.out.println("Turmas disponíveis:");
        for (int i = 0; i < availableClasses.size(); i++) {
            Class currentClass = availableClasses.get(i);
            int index = i + 1;
            System.out.println(index + ". " + currentClass.getName());
        }

        System.out.println();
        System.out.println("Selecione a turma que deseja ingressar:");
        System.out.println("(em branco para cancelar)");

        String choiceString = Scan.nextLine();
        if (choiceString.isEmpty()) {
            return;
        }

        int choice = Integer.parseInt(choiceString) - 1;
        if (choice >= 0 && choice < availableClasses.size()) {
            addClass(currentStudent, availableClasses.get(choice));
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void removeClassMenu(Student currentStudent) {
        ArrayList<Class> classes = listClasses(currentStudent);

        if (classes.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("Escolha uma turma para remover:");
        System.out.println("(em branco para cancelar)");

        String choiceString = Scan.nextLine();
        if (choiceString.isEmpty()) {
            return;
        }

        int choice = Integer.parseInt(choiceString) - 1;
        if (choice >= 0 && choice < classes.size()) {
            removeClass(currentStudent, classes.get(choice));
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void changeEnrollmentMenu(Student currentStudent) {
        ArrayList<Class> classes = listClasses(currentStudent, true);

        if (classes.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("Escolha uma turma para alterar a matrícula:");
        System.out.println("(em branco para cancelar)");

        String choiceString = Scan.nextLine();
        if (choiceString.isEmpty()) {
            return;
        }

        int choice = Integer.parseInt(choiceString) - 1;
        if (choice >= 0 && choice < classes.size()) {
            changeEnrollmentSubmenu(currentStudent, classes.get(choice));
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void changeEnrollmentSubmenu(Student currentStudent, Class currentClass) {
        EnrollmentStatus currentEnrollmentStatus = currentClass.getEnrollmentStatus(currentStudent);
        System.out.println();
        System.out.println(
            "Sua matrícula na turma " + currentClass.getName() + " está: " + EnrollmentStatus.getTranslatedStatusNameFromIndex(EnrollmentStatus.valueOf(String.valueOf(currentEnrollmentStatus))) + "."
        );
        String input;
        switch (currentEnrollmentStatus) {
            case ACTIVE:
                System.out.println("Você deseja trancar a sua matrícula? (s/n)");
                input = Scan.nextLine().strip().toLowerCase();
                if (input.equals("s") || input.equals("sim")) {
                    changeEnrollmentStatus(currentStudent, currentClass, EnrollmentStatus.LOCKED);
                    return;
                } else {
                    System.out.println("Alteração de matrícula cancelada.");
                    return;
                }
            case LOCKED:
                System.out.println("Você deseja ativar a sua matrícula? (s/n");
                input = Scan.nextLine().strip().toLowerCase();
                if (input.equals("s") || input.equals("sim")) {
                    changeEnrollmentStatus(currentStudent, currentClass, EnrollmentStatus.ACTIVE);
                    return;
                } else {
                    System.out.println("Alteração de matrícula cancelada.");
                    return;
                }
            case GRADUATED:
                System.out.println("Você já tem formação concluída nesta turma.");
        }
    }

    private static void addClass(Student currentStudent, Class currentClass) {
        currentClass.addStudent(currentStudent);
    }

    private static void removeClass(Student currentStudent, Class currentClass) {
        currentClass.removeStudent(currentStudent);
    }

    private static void changeEnrollmentStatus(
        Student currentStudent,
        Class currentClass,
        EnrollmentStatus enrollmentStatus
    ) {
        currentClass.setEnrollmentStatus(currentStudent, enrollmentStatus);
        System.out.println(
            "Matrícula da turma " + currentClass.getName() + " alterada para: " + EnrollmentStatus.getTranslatedStatusNameFromIndex(EnrollmentStatus.valueOf(String.valueOf(enrollmentStatus))) + "."
        );
    }
}
