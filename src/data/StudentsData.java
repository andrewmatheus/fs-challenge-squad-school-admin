package data;

import classes.Student;
import enums.EnrollmentStatus;

import java.sql.Array;
import java.util.ArrayList;

public class StudentsData {
    private static ArrayList<Student> studentsList = new ArrayList<>();

    public static ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    /*
     * Method addStudent - get Student by mail.
     * */
    public static Student findStudentByMail(String mail) {
        for (Student student : StudentsData.getStudentsList()) {
            if (student.getEmail().equalsIgnoreCase(mail)) {
                return student;
            }
        }
        return null;
    }

    /*
     * Method addStudent - responsible for adding a student to the list.
     * */
    public static void addStudent(Student student) {
        studentsList.add(student);
    }

    /*
     * Method removeStudent - responsible for removing a student from the list.
     * */
    public static void removeStudent(int id) {
        if (id >= 0 && id < studentsList.size()) {
            Student removedStudent = studentsList.remove(id);
            System.out.println("Student " + removedStudent.getName() + " successfully removed.");
        } else {
            System.out.println("Invalid ID. Student could not be removed.");
        }
    }

    /*
     * Method findStudent - responsible for finding a student on the list.
     * */
    public static Student findStudentById(int id){
        if (id >= 0 && id < studentsList.size()) {
            return studentsList.get(id);
        } else {
            System.out.println("ID inválido. Estudante não encontrado");
            return null;
        }
    }
}