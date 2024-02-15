package classes;

public class Teacher extends Employee {
    private int age;

    public Teacher(String name, int age, double salary, int employmentYears) {
        super(name, salary, employmentYears);
        this.age = age;
    }

    public Teacher(String name, int age, double salary) {
        super(name, salary);
        this.age = age;
    }

    // <editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Professor: " +
                "Nome: " + getName() +
                ", Idade: " + age +
                ", Anos de trabalho: " + getEmploymentYears();
    }
    // </editor-fold>

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
