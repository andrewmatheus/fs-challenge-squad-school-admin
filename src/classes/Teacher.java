package classes;

public class Teacher extends Employee {
    private int age;

    public Teacher(String name, int employmentYears) {
        super(name, 0, employmentYears);
    }

    public Teacher(String name, int age, int employmentYears) {
            super(name, 0, employmentYears);
            this.age = age;
        }

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
                ", Salário: " + getSalary() +
                ", Anos de Emprego: " + getEmploymentYears() +
                ", Idade: " + age;
    }
    // </editor-fold>

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
