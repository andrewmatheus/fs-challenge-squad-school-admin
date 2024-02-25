package classes;

public class Director extends Employee {
    // <editor-fold desc="Attributes">
    private int employmentYears;

    // </editor-fold>

    // <editor-fold desc="Constructor">

    /**
     * Method Director - "overload"
     * */
    public Director(String name, double salary) {
        super(name, salary);
    }

    /**
     * Method Director - "heritage"
     * */
    public Director(String name, double salary, int employmentYears) {
       super(name, salary, employmentYears);
    }
    // </editor-fold>

    // <editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Diretor: " +
                "Nome: " + getName() +
                ", Salário: " + getSalary() +
                ", Anos de experiência: " + getEmploymentYears()+
                ", Cargo: " + getJobLevel();
    }
    // </editor-fold>

}




