package data;

import classes.Class;
import classes.Course;
import classes.Student;

import java.util.ArrayList;
import java.util.List;

public class ClassesData {
    // <editor-fold desc="Attributes">
    private static final List<Class> classesList = new ArrayList<>();
    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Method addClass - create the new class
     * */
    public static void addClass(Class aClass) {
        classesList.add(aClass);
    }

    /**
     * Method removeClass - remove class by id
     * no usage created start project - (case study)
     * */
    public static void removeClass(int id) {
        try {
            Class removedClass = classesList.remove(id);
            System.out.println("Turma: " + removedClass.getName() + " removida com sucesso.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Turma não pode ser encontrada, verifique se o índice foi informado corretamente.");
        }
    }

    public static void removeClass(Class aClass) {
        removeClass(classesList.indexOf(aClass));
    }

    /**
     * Method findClassById - return class by id
     * no usage created start project - (case study)
     * */
    public static Class findClassById(int id) {
        if (id >= 0 && id < classesList.size()) {
            return classesList.get(id);
        } else {
            System.out.println("Turma não pode ser encontrada, verifique se o índice foi informado corretamente.");
            return null;
        }
    }

    /**
     * Method getStudentClasses - returns the classes that contain the student
     * */
    public static ArrayList<Class> getStudentClasses(Student student) {
        ArrayList<Class> classes = new ArrayList<>();

        for (Class currentClass : classesList) {
            if (currentClass.hasStudent(student)) {
                classes.add(currentClass);
            }
        }

        return classes;
    }

    /**
     * Method getClassesWithoutStudent - returns classes that do not contain the student
     * */
    public static ArrayList<Class> getClassesWithoutStudent(Student student) {
        ArrayList<Class> classes = new ArrayList<>();

        for (Class currentClass : classesList) {
            if (!currentClass.hasStudent(student)) {
                classes.add(currentClass);
            }
        }

        return classes;
    }

    /**
     * Method getAllClasses - return list of all classes
     * */
    public static ArrayList<Class> getAllClasses() {
        return new ArrayList<>(classesList);
    }

    public static ArrayList<Class> getClassessAssociatedWithCourse(Course course) {
        ArrayList<Class> classes = new ArrayList<>();

        for (Class currentClass : classesList) {
            if (currentClass.getCourse().equals(course)) {
                classes.add(currentClass);
            }
        }

        return classes;
    }
    // </editor-fold>
}
