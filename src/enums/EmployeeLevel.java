// TODO: 13/02/2024
//  Create an enum to represent Enrollment Status and add it as an attribute to Student
//  Values: ACTIVE, LOCKED, FORMED.
//  Create an enum to represent the Employee Job Title.
//  Values: Beginner, Experienced, Advanced
//  Demonstrate the use of values() and valueOf().

package enums;

public enum EmployeeLevel {
    BEGINNER(1),
    EXPERIENCED(2),
    ADVANCED(3);

    private final int levelValue;

    EmployeeLevel(int levelValue) {
        this.levelValue = levelValue;
    }

    public static EmployeeLevel getStatusNameFromIndex(int num) {
        for (EmployeeLevel value : values()) {
            if (value.levelValue == num) {
                return value;
            }
        }
        return null;
    }

    public static String getTranslatedStatusNameFromIndex(int num) {
        for (EmployeeLevel value : values()) {
            if (value.levelValue == 1) {
                return "INICIANTE";
            }
            if (value.levelValue == 2) {
                return "EXPERIENTE";
            }
            if (value.levelValue == 3) {
                return "AVANÇADO";
            }
        }
        return null;
    }

}