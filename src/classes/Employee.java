package classes;

import enums.EmployeeLevel;

public class Employee implements IEmployee {
    private String name;
    private double salary;
    private int employmentYears;
    private EmployeeLevel jobLevel = EmployeeLevel.BEGINNER;


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
                ", Anos de Emprego: " + employmentYears +
                ", Cargo: "+ jobLevel;
    }
    // </editor-fold>
    @Override
    public void promotion() {
        double p_increase = 0.25;
        p_increase *= getSalary();
        setSalary(getSalary() + p_increase);
        if (jobLevel != null) {
            setJobLevel(nextJobLevel(jobLevel));
        }
    }
    @Override
    public void setJobLevel(EmployeeLevel jobLevel) {
        this.jobLevel = jobLevel;
    }

    public EmployeeLevel getJobLevel() {
        return jobLevel;
    }
    // next job level

    private EmployeeLevel nextJobLevel(EmployeeLevel currentJob){
        switch (currentJob) {
            case BEGINNER:
                return EmployeeLevel.EXPERIENCED;
            case EXPERIENCED:
                return EmployeeLevel.ADVANCED;
            case ADVANCED:
                System.out.println(getName()+", atingiu cargo mais alto "+EmployeeLevel.ADVANCED);
        }
        return currentJob;
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
