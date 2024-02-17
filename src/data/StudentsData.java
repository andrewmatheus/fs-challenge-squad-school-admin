package data;

import classes.Student;

import java.util.ArrayList;

public class StudentsData {

    private static ArrayList<Student> studentsList = new ArrayList<>();

        public static void addStudent(Student student) {
        studentsList.add(student);
    }
    public static void removeStudent(int id) {
        try {
            Student removedStudent = studentsList.remove(id);
            System.out.println("Student " + removedStudent.getName() + " successfully removed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Invalid ID. Student could not be removed.");
        }
    }
    public static Student findStudent(int id){
        if (id >= 0 && id < studentsList.size()) {
            return studentsList.get(id);
        } else {
            System.out.println("Invalid ID. Student could not be found.");
            return null;
        }
    }
}