package data;

import classes.Class;

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
}
