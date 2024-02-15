package classes;

public class Employee implements IEmployee {

    private String name;
    private double salary;

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // <editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Funcionário: " +
                "Nome: " + name +
                ", Salário: " + salary;
    }
    // </editor-fold>

    // Getter and setter methods for name and salary

    // Implementing the promote method from the IEmployee interface
    @Override
    public void promote() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

      public void setSalary(double salary) {
        this.salary = salary;
    }

}
