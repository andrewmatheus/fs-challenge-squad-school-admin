package classes;

import java.util.ArrayList;
import java.util.List;

public class Class {
    // <editor-fold desc="Attributes">
    private List<Student> students;
    private int year;
    private Course course;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Class(int year, Course course) {
        this.students = new ArrayList<>();
        this.year = year;
        this.course = course;
    }
    // </editor-fold>

    // <editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Turma: " +
                "Ano: " + year +
                ", Curso: " + course.getName() +
                ", Alunos: " + students.size();
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
        System.out.println("Alunos da turma " + this.year + " do curso " + course.getName() + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    // </editor-fold>
}
