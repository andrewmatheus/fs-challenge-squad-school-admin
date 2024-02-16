import classes.*;
import classes.Class;

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

        // Testing Employee and Director classes
        System.out.println("\nTesting Employee and Director classes:");

        // Creating an Employee
        Employee employee = new Employee("John Doe", 50000.00);

        // Promoting the employee
        employee.promote();

        // Displaying employee information
        System.out.println("\nEmployee Information:");
        System.out.println(employee);

        // Creating a Director
        Director director = new Director("Jane Smith", 60000.00, 5);

        // Promoting the director
        director.promote();

        // Displaying director information
        System.out.println("\nDirector Information:");
        System.out.println(director);

        // Displaying teacher information
        System.out.println("\nTeacher Information:");
        System.out.println(teacher);

        System.out.println("\nStudent Information:");
        System.out.println(studentOne);

        //Student with try/catch
        // try {
        //     Student student = new Student("Fulano", "fulano_dehtal@gmail.com", "48984274452");
        //     System.out.println(student.toString());
        // }catch (IllegalArgumentException e){
        //     System.out.println("Erro ao criar um estudante: "+e.getMessage());
        // }
    }


}
