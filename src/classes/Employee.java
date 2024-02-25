package classes;

import enums.EmployeeLevel;
import interfaces.IEmployee;

import java.security.InvalidParameterException;

public class Employee implements IEmployee {

    // <editor-fold desc="Attributes">
    private String name;
    private double salary;
    private int employmentYears;
    private EmployeeLevel jobLevel;
    // </editor-fold>

    // <editor-fold desc="Constructor">

    /**
     * Method Employee - "overload"
     * no usage created start project - (case study)
     * */
    public Employee(String name) {
        this.name = name;
        this.jobLevel = EmployeeLevel.BEGINNER;
    }

    /**
     * Method Employee - with employmentYears in params
     * */
    public Employee(String name, double salary, int employmentYears) {
        this.name = name;
        this.salary = salary;
        this.employmentYears = employmentYears;
        this.jobLevel = EmployeeLevel.BEGINNER;
    }

    /**
     * Method Employee - no employmentYears in params
     * */
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.employmentYears = 0;
        this.jobLevel = EmployeeLevel.BEGINNER;
    }
    // </editor-fold>

    // <editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Funcionário: " +
                "Nome: " + name +
                ", Salário: " + salary +
                ", Anos de experiência: " + employmentYears +
                ", Cargo: "+ jobLevel;
    }
    // </editor-fold>

    // <editor-fold desc="methods">

    /**
     * Method promotion - implements interface.
     * increaseSalary - increase employee salary
     * setJobLevel - new job level
     * */
    @Override
    public void promotion() {
        if (canBePromoted()) {
            increaseSalary();
            setJobLevel(nextJobLevel(jobLevel));
        }
    }

    /**
     * Method canBePromoted - validation to level up job.
     * */
    public boolean canBePromoted() {
        return nextJobLevel(jobLevel) != null;
    }

    /**
     * Method increaseSalary - increase employee salary with percentIncrease in params.
     * */
    public void increaseSalary(double percentIncrease) {
        if (percentIncrease > 1) {
            double newSalary = getSalary() * percentIncrease;
            setSalary(newSalary);
        } else {
            throw new InvalidParameterException("O aumento percentual deve ser maior que 1!");
        }
    }

    /**
     * Method increaseSalary - overload.
     * increase employee salary.
     * */
    public void increaseSalary() {
        increaseSalary(1.25);
    }

    /**
     * Method setJobLevel - add new jobLevel.
     * */
    @Override
    public void setJobLevel(EmployeeLevel jobLevel) {
        if (jobLevel != null) {
            this.jobLevel = jobLevel;
        } else {
            throw new InvalidParameterException("O nível do trabalho não pode ser nulo, informe um nível válido.");
        }
    }

    /**
     * Method getJobLevel - returns the employee's jobLevel
     * */
    public EmployeeLevel getJobLevel() {
        return jobLevel;
    }
    // next job level

    /**
     * Method nextJobLevel - increases jobLevel when allowed
     * */
    private EmployeeLevel nextJobLevel(EmployeeLevel currentJob){
        return switch (currentJob) {
            case BEGINNER -> EmployeeLevel.EXPERIENCED;
            case EXPERIENCED -> EmployeeLevel.ADVANCED;
            default -> null;
        };
    }

    /**
     * Method getName - return name to employee
     * */
    public String getName() {
        return name;
    }

    /**
     * Method setName - add name to employee
     * no usage created start project - (case study)
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getEmploymentYears - return employmentYears to employee
     * */
    public int getEmploymentYears() {
        return employmentYears;
    }

    /**
     * Method setEmploymentYears - add employmentYears to employee
     * no usage created start project - (case study)
     * */
    public void setEmploymentYears(int employmentYears) {
        this.employmentYears = employmentYears;
    }

    /**
     * Method getSalary - return salary to employee
     * */
    public double getSalary() {
        return salary;
    }

    /**
     * Method setSalary - add salary to employee
     * */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // </editor-fold>
}
