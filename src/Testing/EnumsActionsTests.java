package Testing;

import enums.EmployeeLevel;
import enums.EnrollmentStatus;

import java.util.Scanner;

public class EnumsActionsTests {

    /**
     * Class EnumsActionsTests
     * test features and assist development.
     * Decided as a team for internal development only, left for study purposes
     * */

    public static void main(String[] args) {
        enumTestLevel();
        enumTestEnrollment();
    }

    public static void enumTestLevel() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Employee levels available: ");
        for (EmployeeLevel value : EmployeeLevel.values()) {
            System.out.println("---> " + value);
        }

        System.out.print("Inform the employee's experience level: ");
        String level = scanner.nextLine();

        try {
            EmployeeLevel employeeLevel = EmployeeLevel.valueOf(level);
            System.out.println("Employee level: " + employeeLevel);
            // apenas fixando o EmployeeLevel.EXPERIENCED na linha abaixo, para testar a execução
            System.out.println(EmployeeLevel.getTranslated(EmployeeLevel.valueOf(level)));

        } catch (IllegalArgumentException e) {
            System.out.println("-->  INVALID LEVEL !!!  <--");
        }
    }

    public static void enumTestEnrollment() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Available enrollment status: ");
        for (EnrollmentStatus value : EnrollmentStatus.values()) {
            System.out.println("---> " + value);
        }

        System.out.print("Inform the student's enrollment: ");
        String status = scanner.nextLine();
        try {
            EnrollmentStatus studentStatus = EnrollmentStatus.valueOf(status);
            System.out.println("Enrollment status: " + studentStatus);
            // apenas fixando o EnrollmentStatus.LOCKED na linha abaixo, para testar a execução
            System.out.println(EnrollmentStatus.getTranslatedStatusNameFromIndex(EnrollmentStatus.valueOf(status)));
        } catch (IllegalArgumentException e) {
            System.out.println("-->  INVALID STATUS !!!  <--");
        }
    }
}
