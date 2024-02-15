package classes;

public class Director extends Employee {
    private int employmentYears;

    //overload
    public Director(String name, double salary) {
        super(name, salary);
    }

    // Constructor
    public Director(String name, double salary, int employmentYears) {
        super(name, salary);
        this.employmentYears = employmentYears;
    }

    public int getEmploymentYears() {
        return employmentYears;
    }

    public void setEmploymentYears(int employmentYears) {
        this.employmentYears = employmentYears;
    }
}

