package data;

import classes.Course;

import java.util.ArrayList;
import java.util.List;

public class CoursesData {
    private static List<Course> coursesList = new ArrayList<>();

    public static void addCourse(Course course) {
        coursesList.add(course);
    }

    public static void removeCourse(int id) {
        try {
            Course removedCourse = coursesList.remove(id);
            System.out.println("Course " + removedCourse.getName() + " successfully removed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Invalid ID. Course could not be found.");
        }
    }

    public static Course findCourseById(int id) {
        if (id >= 0 && id < coursesList.size()) {
            return coursesList.get(id);
        } else {
            System.out.println("Invalid ID. Course could not be found.");
            return null;
        }
    }
    // Método adicionado para implementar a funcionalidade do relatório geral
    public static List<Course> getCoursesList() {
        return coursesList;
    }
}
