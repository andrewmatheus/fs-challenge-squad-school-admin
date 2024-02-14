package classes;

public class Director extends Employee {
    private int timeWork;

    // Constructor
    public Director(String name, double salary, int employmentYears) {
        super(name, salary);
        this.timeWork = employmentYears;
    }

    public int getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(int timeWork) {
        this.timeWork = timeWork;
    }
}

