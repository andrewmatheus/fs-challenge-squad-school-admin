package classes;

public class Director extends Employee {
    private int employmentYears;

    //overload
    public Director(String name, double salary) {
        super(name, salary);
    }

    // Constructor

  public Director(String name, double salary, int employmentYears) {
        super(name, salary, employmentYears);
    }

    public Director(String name, double salary) {
        super(name, salary);
    }

    // <editor-fold desc="ToString">
    @Override
        public String toString() {
        return "Diretor: " +
                "Nome: " + getName() +
                ", Salário: " + getSalary() +
                ", Anos de Emprego: " + getEmploymentYears();
    }
    // </editor-fold>
}




