package Testing;

import classes.Class;
import classes.Course;
import classes.Student;
import classes.Teacher;
import data.ClassesData;
import data.CoursesData;
import data.StudentsData;
import data.TeachersData;
import menu.StudentActions;

public class StudentActionsTests {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Teacher 1", 30, 6000, 5);
        Teacher teacher2 = new Teacher("Teacher 2", 30, 6000, 5);
        TeachersData.addTeacher(teacher1);
        TeachersData.addTeacher(teacher2);

        Course course1 = new Course("Course 1", teacher1);
        Course course2 = new Course("Course 2", teacher2);
        CoursesData.addCourse(course1);
        CoursesData.addCourse(course2);

        Class class1 = new Class("Classe 1", 2024, course1);
        Class class2 = new Class("Classe 2", 2024, course2);
        ClassesData.addClass(class1);
        ClassesData.addClass(class2);

        Student student1 = new Student("Student");
        StudentsData.addStudent(student1);

        StudentActions.menu(student1);
    }
}
