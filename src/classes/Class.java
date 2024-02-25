package classes;

import enums.EnrollmentStatus;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Class {
    // <editor-fold desc="Attributes">
    private String name;
    private final List<Student> students;
    private final List<EnrollmentStatus> studentEnrollmentList;
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
                ", Ano: " + year +
                ", Curso: " + course.getName() +
                ", Alunos: " + students.size();
    }
    // </editor-fold>

    // <editor-fold desc="methods">
    /**
     * Method addStudent - is responsible for adding a new student to the list with status custom
     * */
    public void addStudent(Student student, EnrollmentStatus enrollmentStatus) {
        students.add(student);
        studentEnrollmentList.add(enrollmentStatus);
    }

    /**
     * Method addStudent - is responsible for adding a new student to the list with status active
     * */
    public void addStudent(Student student) {
        addStudent(student, EnrollmentStatus.ACTIVE);
    }

    /**
     * Method removeStudent - has the responsibility to remove a student from the list
     * */
    public void removeStudent(Student student) {
        int index = students.indexOf(student);
        if (index >= 0) {
            students.remove(index);
            studentEnrollmentList.remove(index);
        } else {
            throw new InvalidParameterException("Não foi possível remover o(a) aluno(a) da turma! Aluno(a) não foi encontrado(a).");
        }
    }

    /**
     * Method hasStudent - responsible for checking whether there is a student on the list
     * */
    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    /**
     * Method listStudents - has the responsibility of listing course students
     * no usage created start project - (case study)
     * */
    public void listStudents() {
        System.out.println("Alunos da turma " + this.year + " do curso " + course.getName() + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }

    /**
     * Method getEnrollmentStatus - method searches for student status
     * */
    public EnrollmentStatus getEnrollmentStatus(Student student) {
        int index = students.indexOf(student);
        if (index >= 0) {
            return studentEnrollmentList.get(index);
        } else {
            throw new InvalidParameterException("Não foi possível recuperar o status de matrícula do(a) aluno(a)! Aluno(a) não foi encontrado(a).");
        }
    }

    /**
     * Method setEnrollmentStatus - responsible for adding a status for the student informed by parameter
     * */
    public void setEnrollmentStatus(Student student, EnrollmentStatus enrollmentStatus) {
        int index = students.indexOf(student);
        if (index >= 0) {
            studentEnrollmentList.set(index, enrollmentStatus);
        } else {
            throw new InvalidParameterException("Não foi possível definir o status de matrícula do(a) aluno(a)! Aluno(a) não foi encontrado(a).");
        }
    }

    /**
     * Method getStudents - returns list of students
     * */
    public ArrayList<Student> getStudents(){
        return new ArrayList<>(this.students);
    }

    /**
     * Method getName - return name of student
     * */
    public String getName() {
        return name;
    }

    /**
     * Method setName - set name of student
     * no usage created start project - (case study)
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getYear - return year of student
     * */
    public int getYear() {
        return year;
    }

    /**
     * Method setYear - set year of student
     * no usage created start project - (case study)
     * */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Method getCourse - return course of student
     * */
    public Course getCourse() {
        return course;
    }

    /**
     * Method setCourse - set course of student
     * no usage created start project - (case study)
     * */
    public void setCourse(Course course) {
        this.course = course;
    }
    // </editor-fold>
}
