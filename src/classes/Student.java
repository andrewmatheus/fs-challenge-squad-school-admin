package classes;

import java.util.ArrayList;
import java.util.List;

public class Student {
    // <editor-fold desc="Attributes">
    private String name;
    private byte age;
    private List<Course> courses;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    // </editor-fold>

    // <editor-fold desc="Overload">
    public Student(String name, byte age) {
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
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

    /*
     * Method getAge and SetAge
     * */
    public int getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
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
