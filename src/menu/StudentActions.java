package menu;

import classes.Student;

import java.util.Scanner;

public class StudentActions {
    public static void menu(Scanner scanner, Student currentStudent) {
        boolean finish = false;
        while (!finish) {
            System.out.println("Usuário atual - Estudante: " + currentStudent.getName());
            System.out.println();
            System.out.println("Opções:");
            System.out.println("1. Listar cursos");
            System.out.println("2. Adicionar curso");
            System.out.println("3. Remover curso");
            System.out.println("4. Alterar matrícula");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção:");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    addCourseMenu();
                    break;
                case 3:
                    removeCourseMenu();
                    break;
                case 4:
                    changeEnrollmentMenu();
                    break;
                case 5:
                    finish = true;
                    break;
            }
        }
    }

    private static void listCourses() {

    }

    private static void addCourseMenu() {

    }

    private static void removeCourseMenu() {

    }

    private static void changeEnrollmentMenu() {

    }
}
