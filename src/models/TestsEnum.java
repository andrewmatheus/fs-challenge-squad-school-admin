package models;

import enums.StatusLevel;
import enums.StatusRegistration;
import java.util.Scanner;

public class TestsEnum {
    public static void enumTestLevel() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Experience levels available: ");
        for (StatusLevel value : StatusLevel.values()) {
            System.out.println("---> " + value);
        }

        System.out.print("Inform the employee's experience level: ");
        String level = scanner.nextLine();

        try {
            StatusLevel employeeLevel = StatusLevel.valueOf(level);
            System.out.println("Experience level: " + employeeLevel);
        } catch (IllegalArgumentException e) {
            System.out.println("-->  INVALID LEVEL !!!  <--");
        }
    }

    public static void enumTestRegistration() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Available registration status: ");
        for (StatusRegistration value : StatusRegistration.values()) {
            System.out.println("---> " + value);
        }

        System.out.print("Inform the student's status: ");
        String status = scanner.nextLine();
        try {
            StatusRegistration studentStatus = StatusRegistration.valueOf(status);
            System.out.println("Registraton status: " + studentStatus);
        } catch (IllegalArgumentException e) {
            System.out.println("-->  INVALID STATUS !!!  <--");
        }
    }
}
