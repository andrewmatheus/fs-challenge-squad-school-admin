package menu;

import classes.Class;
import classes.Student;
import classes.Teacher;
import data.ClassesData;
import data.StudentsData;
import utils.Scan;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TeacherActions {
    public static void menu(Teacher currentTeacher) {
        try {
            int optionSelected;

            do {

                System.out.println("\nFUNCIONÁRIO: " + currentTeacher.getName() );
                System.out.println("CARGO: PROFESSOR");
                System.out.println("+---------------------------------+");
                System.out.println("|                                 |");
                System.out.println("| (1) - Listar Todos os Alunos    |");
                System.out.println("| (2) - Listar Alunos na turma    |");
                System.out.println("| (3) - Adicionar Aluno na turma  |");
                System.out.println("| (4) - Remover Aluno da turma    |");
                System.out.println("|                                 |");
                System.out.println("+---------------------------------+");
                System.out.println("| (0) - Sair                      |");
                System.out.println("+---------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        listStudents(StudentsData.getAllStudents());
                        break;
                    case 2:
                        listStudentsInClassMenu();
                        break;
                    case 3:
                        addStudentToClassMenu();
                        break;
                    case 4:
                        removeStudentFromClassMenu();
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

    public static void listStudentsInClassMenu() {
        ArrayList<Class> classes = ClassesData.getAllClasses();
        listClasses(classes);

        if (classes.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("Selecione o ID da Turma para listar os alunos:");
        System.out.println("(em branco para cancelar)");

        String choiceString = Scan.nextLine();
        if (choiceString.isEmpty()) {
            return;
        }

        int classIndex = Integer.parseInt(choiceString) - 1;
        if (classIndex < 0 || classIndex >= classes.size()) {
            System.out.println("ID da Turma inválido.");
            return;
        }
        Class selectedClass = classes.get(classIndex);

        ArrayList<Student> students = selectedClass.getStudents();
        System.out.println();
        listStudents(students);
    }

    public static void addStudentToClassMenu() {
        ArrayList<Class> classes = ClassesData.getAllClasses();
        listClasses(classes);

        if (classes.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("Selecione o ID da Turma para adicionar aluno:");
        System.out.println("(em branco para cancelar)");

        String choiceString = Scan.nextLine();
        if (choiceString.isEmpty()) {
            return;
        }

        int classIndex = Integer.parseInt(choiceString) - 1;
        if (classIndex < 0 || classIndex >= classes.size()) {
            System.out.println("ID da Turma inválido.");
            return;
        }
        Class selectedClass = classes.get(classIndex);

        ArrayList<Student> students = StudentsData.getStudentsNotInClass(selectedClass);
        System.out.println();
        listStudents(students);

        if (students.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("Selecione o ID do Aluno para adicionar à turma " + selectedClass.getName() + ":");
        System.out.println("(em branco para cancelar)");

        choiceString = Scan.nextLine();
        if (choiceString.isEmpty()) {
            return;
        }

        int studentIndex = Integer.parseInt(choiceString) - 1;
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("ID do Aluno inválido.");
            return;
        }
        Student selectedStudent = students.get(studentIndex);

        selectedClass.addStudent(selectedStudent);
    }

    public static void removeStudentFromClassMenu() {
        ArrayList<Class> classes = ClassesData.getAllClasses();
        listClasses(classes);

        if (classes.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("Selecione o ID da Turma para remover aluno:");
        System.out.println("(em branco para cancelar)");

        String choiceString = Scan.nextLine();
        if (choiceString.isEmpty()) {
            return;
        }

        int classIndex = Integer.parseInt(choiceString) - 1;
        if (classIndex < 0 || classIndex >= classes.size()) {
            System.out.println("ID da Turma inválido.");
            return;
        }
        Class selectedClass = classes.get(classIndex);

        ArrayList<Student> students = selectedClass.getStudents();
        System.out.println();
        listStudents(students);

        if (students.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("Selecione o ID do Aluno para remover da turma " + selectedClass.getName() + ":");
        System.out.println("(em branco para cancelar)");

        choiceString = Scan.nextLine();
        if (choiceString.isEmpty()) {
            return;
        }

        int studentIndex = Integer.parseInt(choiceString) - 1;
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("ID do Aluno inválido.");
            return;
        }
        Student selectedStudent = students.get(studentIndex);

        selectedClass.removeStudent(selectedStudent);
    }

    private static void listClasses(ArrayList<Class> classes) {
        System.out.println("Lista das Turmas: ");

        if (classes.isEmpty()) {
            System.out.println("Não há turmas abertas.");
            return;
        }

        for (int i = 0; i < classes.size(); i++) {
            Class aClass = classes.get(i);
            int index = i + 1;
            System.out.println(index + ". " + aClass);
        }
    }

    private static void listStudents(ArrayList<Student> students) {
        System.out.println("Lista de alunos: ");

        if (students.isEmpty()) {
            System.out.println("Não há alunos disponíveis.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            int index = i + 1;
            System.out.println(index + ". "+ student.getName());
        }
    }
}
