package classes;

public class Employee implements IEmployee {
    private String name;
    private double salary;
    private int employmentYears;

    // Constructor
    public Employee(String name, double salary, int employmentYears) {
        this.name = name;
        this.salary = salary;
        this.employmentYears = employmentYears;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.employmentYears = 0;
    }

    // <editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Funcionário: " +
                "Nome: " + name +
                ", Salário: " + salary +
                ", Anos de Emprego: " + employmentYears;
    }
    // </editor-fold>

    // Implementing the promote method from the IEmployee interface
    @Override
    public void promote() {
        // TODO Implementation for promoting an employee
    }

    // Getter and setter methods for name, employmentYears and salary

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmploymentYears() {
        return employmentYears;
    }

    public void setEmploymentYears(int employmentYears) {
        this.employmentYears = employmentYears;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
