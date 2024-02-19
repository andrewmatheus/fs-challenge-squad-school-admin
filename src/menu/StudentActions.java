package menu;

import classes.Class;
import classes.Student;
import data.ClassesData;

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
            System.out.print("Escolha uma opção:");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    listClasses(scanner, currentStudent);
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
        }
    }

    private static ArrayList<Class> listClasses(Scanner scanner, Student currentStudent) {
        ArrayList<Class> classes = ClassesData.getStudentClasses(currentStudent);
        System.out.println("Suas classes:");
        for (int i = 0; i < classes.size(); i++) {
            Class currentClass = classes.get(i);
            int index = i + 1;
            System.out.println(index + ". " + currentClass.getName());
        }
        return classes;
    }

    private static ArrayList<Class> listClasses(Scanner scanner, Student currentStudent, boolean showEnrollment) {
        ArrayList<Class> classes = ClassesData.getStudentClasses(currentStudent);

        System.out.println("Suas classes:");
        for (int i = 0; i < classes.size(); i++) {
            Class currentClass = classes.get(i);
            int index = i + 1;
            System.out.println(index + ". " + currentClass.getName());
        }
        return classes;
    }

    private static void addClassMenu(Scanner scanner, Student currentStudent) {
        //pass
    }

    private static void removeClassMenu(Scanner scanner, Student currentStudent) {
        ArrayList<Class> classes = listClasses(scanner, currentStudent);

        System.out.println();
        System.out.println("Escolha uma classe para remover:");
        System.out.println("(em branco para cancelar)");

        String choiceString = scanner.nextLine();
        if (choiceString.isEmpty()) {
            return;
        }

        int choice = Integer.parseInt(choiceString);
        if (choice >= 0 && choice < classes.size()) {
            // TODO remove class
        } else {
            System.out.println("Índice inválido.");
            return;
        }
    }

    private static void changeEnrollmentMenu(Scanner scanner, Student currentStudent) {
        listClasses(scanner, currentStudent);
    }
}
