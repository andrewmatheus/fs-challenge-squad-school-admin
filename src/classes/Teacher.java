package classes;

public class Teacher {
    // <editor-fold desc="Attributes">
    private String name;
    private int age;
    private int employmentYears;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Teacher(String name, int age, int employmentYears) {
        this.name = name;
        this.age = age;
        this.employmentYears = employmentYears;
    }
    // </editor-fold>

    // <editor-fold desc="methods">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    // </editor-fold>
}
