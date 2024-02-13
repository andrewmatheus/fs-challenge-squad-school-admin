package classes;

import java.util.ArrayList;
import java.util.List;

public class Class {
    // <editor-fold desc="Attributes">
    private List<Student> students;
    private int age;
    private Course course;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Class(int age, Course course) {
        this.students = new ArrayList<>();
        this.age = age;
        this.course = course;
    }
    // </editor-fold>

    // <editor-fold desc="methods">
    /*
     * Method addStudent - is responsible for adding a new student to the list
     * */
    public void addStudent(Student student) {
        students.add(student);
    }
    /*
     * Method removeStudent - has the responsibility to remove a student from the list
     * */
    public void removeStudent(Student student) {
        students.remove(student);
    }
    /*
     * Method listStudents - has the responsibility of listing course students
     * */
    public void listStudents() {
        System.out.println("Alunos da turma " + this.age + " do curso " + course.getName() + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
    // </editor-fold>
}
