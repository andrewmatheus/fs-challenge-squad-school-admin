// TODO: 13/02/2024
//  Create an enum to represent Enrollment Status and add it as an attribute to Student
//  Values: ACTIVE, LOCKED, GRADUATED.
//  Create an enum to represent the Employee Job Title.
//  Values: Beginner, Experienced, Advanced
//  Demonstrate the use of values() and valueOf().

package enums;

public enum StatusRegistration {
    ACTIVE(1),
    LOCKED(2),
    GRADUATED(3);

    private final int registrationValue;

    StatusRegistration(int registrationValue) {
        this.registrationValue = registrationValue;
    }

    public static StatusRegistration getStatusNameFromIndex(int num) {
        for (StatusRegistration value : values()) {
            if (value.registrationValue == num) {
                return value;
            }
        }
        return null;
    }
}
