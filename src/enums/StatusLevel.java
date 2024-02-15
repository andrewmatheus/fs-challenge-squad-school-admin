// TODO: 13/02/2024
//  Create an enum to represent Enrollment Status and add it as an attribute to Student
//  Values: ACTIVE, LOCKED, FORMED.
//  Create an enum to represent the Employee Job Title.
//  Values: Beginner, Experienced, Advanced
//  Demonstrate the use of values() and valueOf().

package enums;

public enum StatusLevel {
    BEGINNER(1),
    EXPERIENCED(2),
    ADVANCED(3);

    private final int levelValue;

    StatusLevel(int levelValue) {
        this.levelValue = levelValue;
    }

    public static StatusLevel getStatusNameFromIndex(int num) {
        for (StatusLevel value : values()) {
            if (value.levelValue == num) {
                return value;
            }
        }
        return null;
    }

}