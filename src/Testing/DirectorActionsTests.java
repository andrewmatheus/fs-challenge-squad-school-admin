package Testing;

import classes.Class;
import classes.Course;
import classes.Director;
import classes.Student;
import classes.Teacher;
import data.*;
import enums.EmployeeLevel;
import menu.DirectorActions;
import utils.Scan;

public class DirectorActionsTests {

    /**
     * Class DirectorActionsTests
     * test features and assist development.
     * Decided as a team for internal development only, left for study purposes
     * */

    public static void main(String[] args) {
// Cadastrando professores
        Teacher andre = new Teacher("André", 28, 10500.0, 11);
        andre.setJobLevel(EmployeeLevel.BEGINNER);
        Teacher cesar = new Teacher("Cesar", 35, 11900.0, 13);
        cesar.setJobLevel(EmployeeLevel.BEGINNER);
        TeachersData.addTeacher(andre);
        TeachersData.addTeacher(cesar);

// Cadastrando alunos
        Student gabriel = new Student("Gabriel", "uno@uni.com.br", "48984927714");
        Student lucas = new Student("Lucas", "dois@uni.com.br", "48984927715");
        Student regina = new Student("Regina", "tres@uni.com.br", "48984927716");
        StudentsData.addStudent(gabriel);
        StudentsData.addStudent(lucas);
        StudentsData.addStudent(regina);

// Cadastrando diretor
        Director director = new Director("Bruno", 15400, 20);
        DirectorsData.addDirector(director);


        Course course1 = new Course("Course 1", andre);
        Course course2 = new Course("Course 2", cesar);
        CoursesData.addCourse(course1);
        CoursesData.addCourse(course2);

        Class class1 = new classes.Class("Classe 1", 2024, course1);
        Class class2 = new Class("Classe 2", 2024, course2);
        ClassesData.addClass(class1);
        ClassesData.addClass(class2);

        class1.addStudent(gabriel);
        class2.addStudent(regina);


        // Passando o diretor para o menu de ações do diretor
        DirectorActions.menu(director);
        Scan.close();
    }
}

