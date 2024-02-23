package classes;

import enums.EnrollmentStatus;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Class {
    // <editor-fold desc="Attributes">
    private String name;
    private List<Student> students;
    private List<EnrollmentStatus> studentEnrollmentList;
    private int year;
    private Course course;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Class(String name, int year, Course course) {
        this.name = name;
        this.students = new ArrayList<>();
        this.studentEnrollmentList = new ArrayList<>();
        this.year = year;
        this.course = course;
    }
    // </editor-fold>

    // <editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Turma: " +
                "Nome: " + name +
                "Ano: " + year +
                ", Curso: " + course.getName() +
                ", Alunos: " + students.size();
    }
    // </editor-fold>

    // <editor-fold desc="methods">
    /*
     * Method addStudent - is responsible for adding a new student to the list
     * */
    public void addStudent(Student student, EnrollmentStatus enrollmentStatus) {
        students.add(student);
        studentEnrollmentList.add(enrollmentStatus);
    }

    public void addStudent(Student student) {
        addStudent(student, EnrollmentStatus.ACTIVE);
    }
    /*
     * Method removeStudent - has the responsibility to remove a student from the list
     * */
    public void removeStudent(Student student) {
        int index = students.indexOf(student);
        if (index >= 0) {
            students.remove(index);
            studentEnrollmentList.remove(index);
        } else {
            throw new InvalidParameterException("Could not remove student from class. Student not found.");
        }
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
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

    public EnrollmentStatus getEnrollmentStatus(Student student) {
        int index = students.indexOf(student);
        if (index >= 0) {
            return studentEnrollmentList.get(index);
        } else {
            throw new InvalidParameterException("Could not retrieve student enrollment status. Student not found.");
        }
    }

    public void setEnrollmentStatus(Student student, EnrollmentStatus enrollmentStatus) {
        int index = students.indexOf(student);
        if (index >= 0) {
            studentEnrollmentList.set(index, enrollmentStatus);
        } else {
            throw new InvalidParameterException("Could not set student enrollment status. Student not found.");
        }
    }

    public ArrayList<Student> getStudents(){
        return new ArrayList<>(this.students);
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
