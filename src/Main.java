import classes.*;
import classes.Class;
import classes.Course;
import classes.Student;
import classes.Teacher;
import enums.EmployeeLevel;
import enums.EnrollmentStatus;

import static models.TestsEnum.enumTestLevel;
import static models.TestsEnum.enumTestEnrollment;

import data.TeachersData;

public class Main {
    public static void main(String[] args) {
        // Usage example

        // Creating a teacher
        Teacher teacher = new Teacher("André", 30, 25000.00, 10);

        // Creating a course
        Course course = new Course("BackEnd-Java", teacher);
        Course courseTwo = new Course("FrontEnd-Angular", teacher);

        // Creating a class with course
        Class class2024 = new Class("BackEnd-Java 2024", 2024, course);

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

        // Testing Employee and Director classes
        System.out.println("\nTesting Employee and Director classes:");

        // Creating an Employee
        Employee employee = new Employee("John Doe", 50000.00);

        // Promoting the employee
        IEmployee teacher99 = new Teacher("Beltrano", 30, 4000.0, 3);
        System.out.println("Antes da promoção: " + teacher);
        teacher99.promotion();
        System.out.println("promoção: " + teacher); //1 promotions

        // Displaying employee information
        System.out.println("\nEmployee Information:");
        System.out.println(employee);

        // Creating a Director
        Director director = new Director("Jane Smith", 60000.00, 5);
        
        // Displaying director information
        System.out.println("\nDirector Information:");
        System.out.println(director);

        // Displaying teacher information
        System.out.println("\nTeacher Information:");
        System.out.println(teacher);
      
        System.out.println("\nStudent Information:");
        System.out.println(studentOne);

        // Creating an instance of TeachersData
        TeachersData teachersData = new TeachersData();

        // Adding some teachers
        Teacher teacher1 = new Teacher("João", 35, 2500.00, 5);
        Teacher teacher2 = new Teacher("Maria", 40, 3000.00, 8);

        teachersData.addTeacher(teacher1);
        teachersData.addTeacher(teacher2);

        // Testing the removal of a teacher
        System.out.println("\nRemoving a teacher...");
        teachersData.removeTeacher(0); // Removes the first added teacher

        // Testing the removal of a teacher
        System.out.println("\nRemoving a teacher...");
        teachersData.removeTeacher(2); // Removes the first added teacher

        // Testing the search for a teacher by ID
        System.out.println("\nSearching for a teacher by ID...");
        Teacher foundTeacher = teachersData.findTeacherById(0); // Searches for the added teacher by ID
        if (foundTeacher != null) {
            System.out.println("Teacher found: " + foundTeacher.getName());
        }

        // Adding one more teacher
        Teacher teacher3 = new Teacher("Carlos", 45, 2800.00, 10);
        teachersData.addTeacher(teacher3);

        // Testing the search for a teacher by ID
        System.out.println("\nSearching for a teacher by ID...");
        foundTeacher = teachersData.findTeacherById(2); // Searches for the third added teacher by ID
        if (foundTeacher != null) {
            System.out.println("Teacher found: " + foundTeacher.getName());
        }

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
