package classes;

public class Teacher extends Employee {
    // <editor-fold desc="Attributes">
    private int age;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    /**
     * Methods Teacher - overload, heritage employee, params name and employmentYears.
     * */
    public Teacher(String name, int employmentYears) {
        super(name, 0, employmentYears);
    }
    /**
     * Methods Teacher - overload, heritage employee, params name, age and employmentYears.
     * */
    public Teacher(String name, int age, int employmentYears) {
        super(name, 0, employmentYears);
        this.age = age;
    }

    /**
     * Methods Teacher - overload, heritage employee, params name, age, salary and employmentYears.
     * */
    public Teacher(String name, int age, double salary, int employmentYears) {
        super(name, salary, employmentYears);
        this.age = age;
    }

    /**
     * Methods Teacher - overload, heritage employee, params name, age and salary
     * */
    public Teacher(String name, int age, double salary) {
        super(name, salary);
        this.age = age;
    }
    // </editor-fold>

    // <editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Professor: " +
                "Nome: " + getName() +
                ", Salário: " + getSalary() +
                ", Anos de experiência: " + getEmploymentYears() +
                ", Idade: " + age +
                ", Cargo: "+ getJobLevel();
    }
    // </editor-fold>

    // <editor-fold desc="methods">
    /**
     * Method getAge - return age teacher
     * no usage created start project - (case study)
     * */
    public int getAge() {
        return age;
    }

    /**
     * Method setAge - add age teacher
     * no usage created start project - (case study)
     * */
    public void setAge(int age) {
        this.age = age;
    }
    // </editor-fold>
}
