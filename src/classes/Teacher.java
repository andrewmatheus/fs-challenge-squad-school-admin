package classes;

public class Teacher extends Employee{

    private int age;
    private int employmentYears;

    public Teacher(String name, int employmentYears) {
        super(name, 0);
        this.employmentYears = employmentYears;
    }

    public Teacher(String name, int age, int employmentYears) {
            super(name, 0);
            this.age = age;
            this.employmentYears = employmentYears;
        }

    public Teacher(String name, int age, int timeWork, double salary) {
        super(name, salary);
        this.age = age;
        this.employmentYears = employmentYears;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEmploymentYears() {
        return employmentYears;
    }

    public void setEmploymentYears(int employmentYears) {
        this.employmentYears = employmentYears;
    }

}
