package data;

import classes.Class;
import classes.Student;

import java.util.ArrayList;
import java.util.List;

public class ClassesData {
    private static List<Class> classesList = new ArrayList<>();

    public static void addClass(Class aClass) {
        classesList.add(aClass);
    }

    public static void removeClass(int id) {
        try {
            Class removedClass = classesList.remove(id);
            System.out.println("Class " + removedClass.getName() + " successfully removed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Invalid ID. Class could not be found.");
        }
    }

    public static Class findClassById(int id) {
        if (id >= 0 && id < classesList.size()) {
            return classesList.get(id);
        } else {
            System.out.println("Invalid ID. Class could not be found.");
            return null;
        }
    }

    public static ArrayList<Class> getStudentClasses(Student student) {
        ArrayList<Class> classes = new ArrayList<>();

        for (Class currentClass : classesList) {
            if (currentClass.hasStudent(student)) {
                classes.add(currentClass);
            }
        }

        return classes;
    }

    public static ArrayList<Class> getClassesWithoutStudent(Student student) {
        ArrayList<Class> classes = new ArrayList<>();

        for (Class currentClass : classesList) {
            if (!currentClass.hasStudent(student)) {
                classes.add(currentClass);
            }
        }

        return classes;
    }

    public static ArrayList<Class> getAllClasses() {
        return new ArrayList<>(classesList);
    }

    public static List<Class> getClassesList() {
        return classesList;
    }
}
