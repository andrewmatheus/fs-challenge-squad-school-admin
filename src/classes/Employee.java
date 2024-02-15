package classes;

public class Employee implements IEmployee {

    private String name;
    private double salary;


    //overload
    public Employee(String name) {
        this.name = name;
    }
    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter and setter methods for name and salary

    // Implementing the promote method from the IEmployee interface
    @Override
    public void promote() {
        // Implementation for promoting an employee
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
