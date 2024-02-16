import classes.*;
import classes.Class;
import classes.Course;
import classes.Student;
import classes.Teacher;
import enums.EmployeeLevel;
import enums.EnrollmentStatus;

import static models.TestsEnum.enumTestLevel;
import static models.TestsEnum.enumTestEnrollment;

public class Main {
    public static void main(String[] args) {
        // Usage example

        // Creating a teacher
        Teacher teacher = new Teacher("André", 30, 25000.00, 10);

        // Creating a course
        Course course = new Course("BackEnd-Java", teacher);
        Course courseTwo = new Course("FrontEnd-Angular", teacher);

        // Creating a class with course
        Class class2024 = new Class(2024, course);

        // Creating a students
        Student studentOne = new Student("Gabriel");
        Student studentTwo = new Student("Samuel");

        // add students a class2024
        class2024.addStudent(studentOne);
        class2024.addStudent(studentTwo);

        // list students the class2024
        System.out.println("\n+---------------------------+");
        class2024.listStudents();

        // add courses for student
        studentOne.addCourse(course);
        System.out.println("\n+---------------------------+");
        studentOne.listCourses();

        studentTwo.addCourse(courseTwo);
        System.out.println("\n+---------------------------+");
        studentTwo.listCourses();

        // using values() and valueOf()
        System.out.println("\n+---------------------------+");
        enumTestLevel();

        System.out.println("\n+---------------------------+");
        enumTestEnrollment();

        // Getting values from the index
        System.out.println("\n+---------------------------+");
        System.out.println("Getting value from Index");
        System.out.println("Index " + 1 + " - " + EmployeeLevel.getStatusNameFromIndex(1));

        System.out.println("\n+---------------------------+");
        System.out.println("Getting value from Index");
        System.out.println("Index " + 1 + " - " + EnrollmentStatus.getStatusNameFromIndex(1));

    }
}