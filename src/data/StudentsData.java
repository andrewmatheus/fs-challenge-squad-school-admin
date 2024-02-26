package data;

import classes.Class;
import classes.Student;

import java.util.ArrayList;

public class StudentsData {
    // <editor-fold desc="Attributes">
    private static final ArrayList<Student> studentsList = new ArrayList<>();
    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Method getAllStudents - return list of students
     * */
    public static ArrayList<Student> getAllStudents() {
        return new ArrayList<>(studentsList);
    }

    /**
     * Method addStudent - get Student by mail.
     * */
    public static Student findStudentByMail(String mail) {
        for (Student student : studentsList) {
            if (student.getMail().equalsIgnoreCase(mail)) {
                return student;
            }
        }
        return null;
    }

    public static boolean isEmailAdressAvailable(String mail) {
        return findStudentByMail(mail) == null;
    }

    /**
     * Method addStudent - responsible for adding a student to the list.
     * */
    public static void addStudent(Student student) {
        studentsList.add(student);
    }

    /**
     * Method removeStudent - responsible for removing a student from the list.
     * no usage created start project - (case study)
     * */
    public static void removeStudent(int id) {
        if (id >= 0 && id < studentsList.size()) {
            Student student = studentsList.get(id);

            ArrayList<Class> classes = ClassesData.getStudentClasses(student);
            for (Class currentClass : classes) {
                currentClass.removeStudent(student);
            }

            studentsList.remove(id);

            System.out.println("Aluno(a): " + student.getName() + " removido(a) com sucesso.");
        } else {
            System.out.println("Aluno(a) não pode ser encontrado(a), verifique se o índice foi informado corretamente.");
        }
    }

    /**
     * Method findStudentById - responsible for finding a student on the list.
     * no usage created start project - (case study)
     * */
    public static Student findStudentById(int id){
        if (id >= 0 && id < studentsList.size()) {
            return studentsList.get(id);
        } else {
            System.out.println("Aluno(a) não pode ser encontrado(a), verifique se o índice foi informado corretamente.");
            return null;
        }
    }

    /**
     * Method getStudentsNotInClass - responsible for finding a student who don't have a class.
     * */
    public static ArrayList<Student> getStudentsNotInClass(Class aClass) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : studentsList) {
            if (!aClass.hasStudent(student)) {
                result.add(student);
            }
        }
        return result;
    }

    // </editor-fold>
}