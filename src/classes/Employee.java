package classes;

import enums.EmployeeLevel;
import interfaces.IEmployee;

import java.security.InvalidParameterException;

public class Employee implements IEmployee {
    private String name;
    private double salary;
    private int employmentYears;
    private EmployeeLevel jobLevel;

    //overload
    public Employee(String name) {
        this.name = name;
        this.jobLevel = EmployeeLevel.BEGINNER;
    }

    // Constructor
    public Employee(String name, double salary, int employmentYears) {
        this.name = name;
        this.salary = salary;
        this.employmentYears = employmentYears;
        this.jobLevel = EmployeeLevel.BEGINNER;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.employmentYears = 0;
        this.jobLevel = EmployeeLevel.BEGINNER;
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
        increaseSalary();
        setJobLevel(nextJobLevel(jobLevel));
    }

    public void increaseSalary(double percentIncrease) {
        if (percentIncrease > 1) {
            double newSalary = getSalary() * percentIncrease;
            setSalary(newSalary);
        } else {
            throw new InvalidParameterException("Percent increase has to be greater than 1.");
        }
    }

    // overload with default percentIncrease of 1.25
    public void increaseSalary() {
        increaseSalary(1.25);
    }

    @Override
    public void setJobLevel(EmployeeLevel jobLevel) {
        if (jobLevel != null) {
            this.jobLevel = jobLevel;
        } else {
            throw new InvalidParameterException("Job level cannot be null.");
        }
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
