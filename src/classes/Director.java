package classes;

public class Director extends Employee {
    private int employmentYears;

    // Constructor
    public Director(String name, double salary, int employmentYears) {
        super(name, salary);
        this.employmentYears = employmentYears;
    }

    // <editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Diretor: " +
                "Nome: " + getName() +
                ", Salário: " + getSalary() +
                ", Anos de Emprego: " + employmentYears;
    }
    // </editor-fold>

    public int getEmploymentYears() {
        return employmentYears;
    }

    public void setEmploymentYears(int employmentYears) {
        this.employmentYears = employmentYears;
    }
}

