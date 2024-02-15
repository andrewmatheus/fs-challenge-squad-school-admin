package classes;

import java.util.ArrayList;
import java.util.List;

public class Student {
    // <editor-fold desc="Attributes">
    private String name;
    private List<Course> courses;
    private String email;
    private String phoneNumber;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    // </editor-fold>

    // <editor-fold desc="try/catch">
    // Another overload / With try/catch
    public Student(String name, String email, String phoneNumber){
        this.name = name;
        try{
            validateEmail(email);
            validatePhoneNumber(phoneNumber);

            //Caso esteja validado corretamente o email e telefone:
            this.email = email;
            this.phoneNumber = phoneNumber;
        }catch (IllegalArgumentException e){
            System.out.println("Erro: "+e.getMessage());
        }
    }

    //Method to validate if the email is correct
    public void validateEmail(String email){
        if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@.+\\..+$")) {
            throw new IllegalArgumentException("O email é INVALIDO!");
        }
    }
    //Method to validate if the Phone is correct

    public void validatePhoneNumber(String phoneNumber){
        if (!phoneNumber.matches("\\d{11}")){
            throw new IllegalArgumentException("Numero de telefone INVALIDO!");
        }
    }

    // </editor-fold>

    // <editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Estudante: "+
                "Nome: "+ name +
                ", Cursos: "+ courses +
                ", Email: "+ email +
                ", Telefone: "+ phoneNumber;
    }
    // </editor-fold>

    // <editor-fold desc="methods">

    /*
     * Method getName - return name student
     * */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*
    * Method addCourse - is responsible for adding a new course to the list
    * */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /*
     * Method removeCourse - has the responsibility to remove a course from the list
     * */
    public void removeCourse(Course course) {
        courses.remove(course);
    }
    /*
     * Method listCourses - has the responsibility of listing the student's courses
     * */
    public void listCourses() {
        System.out.println("Cursos do aluno " + name + ":");
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
    }


    // </editor-fold>
}
