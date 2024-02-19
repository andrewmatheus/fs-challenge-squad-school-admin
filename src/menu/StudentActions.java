package menu;

import classes.Class;
import classes.Student;
import data.ClassesData;
import enums.EnrollmentStatus;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentActions {
    public static void menu(Scanner scanner, Student currentStudent) {
        boolean finish = false;
        while (!finish) {
            System.out.println("Usuário atual - Estudante: " + currentStudent.getName());
            System.out.println();
            System.out.println("Opções:");
            System.out.println("1. Listar classes");
            System.out.println("2. Adicionar classe");
            System.out.println("3. Remover classe");
            System.out.println("4. Alterar matrícula");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                String choiceString = scanner.nextLine().strip();
                int choice = Integer.parseInt(choiceString);

                System.out.println();
                switch (choice) {
                    case 1:
                        listClasses(scanner, currentStudent, true);
                        break;
                    case 2:
                        addClassMenu(scanner, currentStudent);
                        break;
                    case 3:
                        removeClassMenu(scanner, currentStudent);
                        break;
                    case 4:
                        changeEnrollmentMenu(scanner, currentStudent);
                        break;
                    case 5:
                        finish = true;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Opção inválida.");
            } finally {
                System.out.println();
            }
        }
    }

    private static ArrayList<Class> listClasses(Scanner scanner, Student currentStudent) {
        return listClasses(scanner, currentStudent, false);
    }

    private static ArrayList<Class> listClasses(Scanner scanner, Student currentStudent, boolean showEnrollment) {
        ArrayList<Class> classes = ClassesData.getStudentClasses(currentStudent);

        System.out.println("Suas classes:");

        if (!classes.isEmpty()) {
            for (int i = 0; i < classes.size(); i++) {
                Class currentClass = classes.get(i);
                int index = i + 1;

                String enrollmentString = "";
                if (showEnrollment) {
                    enrollmentString = " - " + currentClass.getEnrollmentStatus(currentStudent).toString();
                }
                System.out.println(index + ". " + currentClass.getName() + enrollmentString);
            }
        } else {
            System.out.println("Você ainda não está matriculado em nenhuma classe.");
        }
        return classes;
    }

    private static void addClassMenu(Scanner scanner, Student currentStudent) {
        ArrayList<Class> availableClasses = ClassesData.getClassesWithoutStudent(currentStudent);

        if (availableClasses.isEmpty()) {
            return;
        }

        System.out.println("Classes disponíveis:");
        for (int i = 0; i < availableClasses.size(); i++) {
            Class currentClass = availableClasses.get(i);
            int index = i + 1;
            System.out.println(index + ". " + currentClass.getName());
        }

        System.out.println();
        System.out.println("Selecione a classe que deseja ingressar:");
        System.out.println("(em branco para cancelar)");

        String choiceString = scanner.nextLine();
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

    private static void removeClassMenu(Scanner scanner, Student currentStudent) {
        ArrayList<Class> classes = listClasses(scanner, currentStudent);

        if (classes.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("Escolha uma classe para remover:");
        System.out.println("(em branco para cancelar)");

        String choiceString = scanner.nextLine();
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

    private static void changeEnrollmentMenu(Scanner scanner, Student currentStudent) {
        ArrayList<Class> classes = listClasses(scanner, currentStudent, true);

        if (classes.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("Escolha uma classe para alterar a matrícula:");
        System.out.println("(em branco para cancelar)");

        String choiceString = scanner.nextLine();
        if (choiceString.isEmpty()) {
            return;
        }

        int choice = Integer.parseInt(choiceString) - 1;
        if (choice >= 0 && choice < classes.size()) {
            changeEnrollmentSubmenu(scanner, currentStudent, classes.get(choice));
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void changeEnrollmentSubmenu(Scanner scanner, Student currentStudent, Class currentClass) {
        EnrollmentStatus currentEnrollmentStatus = currentClass.getEnrollmentStatus(currentStudent);
        System.out.println();
        System.out.println(
            "Sua matrícula na classe " + currentClass.getName() + " está: " + currentEnrollmentStatus.toString() + "."
        );
        String input;
        switch (currentEnrollmentStatus) {
            case ACTIVE:
                System.out.println("Você deseja trancar a sua matrícula? (s/n)");
                input = scanner.nextLine().strip().toLowerCase();
                if (input.equals("s") || input.equals("sim")) {
                    changeEnrollmentStatus(currentStudent, currentClass, EnrollmentStatus.LOCKED);
                    return;
                } else {
                    System.out.println("Alteração de matrícula cancelada.");
                    return;
                }
            case LOCKED:
                System.out.println("Você deseja ativar a sua matrícula? (s/n");
                input = scanner.nextLine().strip().toLowerCase();
                if (input.equals("s") || input.equals("sim")) {
                    changeEnrollmentStatus(currentStudent, currentClass, EnrollmentStatus.ACTIVE);
                    return;
                } else {
                    System.out.println("Alteração de matrícula cancelada.");
                    return;
                }
            case GRADUATED:
                System.out.println("Você já graduou desta classe.");
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
            "Matrícula da classe " + currentClass.getName() + " alterada para: " + enrollmentStatus + "."
        );
    }
}
