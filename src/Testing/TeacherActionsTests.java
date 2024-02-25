package Testing;

import classes.Class;
import classes.Course;
import classes.Student;
import classes.Teacher;
import data.ClassesData;
import data.CoursesData;
import data.StudentsData;
import data.TeachersData;
import menu.TeacherActions;
import utils.Scan;

public class TeacherActionsTests {

    /**
     * Class TeacherActionsTests
     * test features and assist development.
     * Decided as a team for internal development only, left for study purposes
     * */

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

        Student student1 = new Student("Student1");
        Student student2 = new Student("Student2");
        Student student3 = new Student("Student3");
        Student student4 = new Student("Student4");
        StudentsData.addStudent(student1);
        StudentsData.addStudent(student2);
        StudentsData.addStudent(student3);
        StudentsData.addStudent(student4);

        TeacherActions.menu(teacher1);
        Scan.close();
    }
}
