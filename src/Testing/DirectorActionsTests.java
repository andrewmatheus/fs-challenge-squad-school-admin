package Testing;

import classes.Class;
import classes.Course;
import classes.Director;
import classes.Student;
import classes.Teacher;
import data.ClassesData;
import data.CoursesData;
import data.DirectorsData;
import data.StudentsData;
import data.TeachersData;
import enums.EmployeeLevel;
import menu.DirectorActions;

import java.util.Scanner;

public class DirectorActionsTests {
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

        Scanner scanner = new Scanner(System.in);

        // Passando o diretor para o menu de ações do diretor
        DirectorActions.menu(scanner, director);

        scanner.close();
    }
}

