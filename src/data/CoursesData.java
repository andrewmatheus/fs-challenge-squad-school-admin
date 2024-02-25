package data;

import classes.Course;

import java.util.ArrayList;
import java.util.List;

public class CoursesData {
    // <editor-fold desc="Attributes">
    private static final List<Course> coursesList = new ArrayList<>();
    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Method addCourse - create the new course
     * */
    public static void addCourse(Course course) {
        coursesList.add(course);
    }

    /**
     * Method removeCourse - remove course by id
     * no usage created start project - (case study)
     * */
    public static void removeCourse(int id) {
        try {
            Course removedCourse = coursesList.remove(id);
            System.out.println("Curso: " + removedCourse.getName() + " removido com sucesso.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Curso não pode ser encontrado, verifique se o índice foi informado corretamente.");
        }
    }

    /**
     * Method findCourseById - return course by id
     * no usage created start project - (case study)
     * */
    public static Course findCourseById(int id) {
        if (id >= 0 && id < coursesList.size()) {
            return coursesList.get(id);
        } else {
            System.out.println("Curso não pode ser encontrado, verifique se o índice foi informado corretamente.");
            return null;
        }
    }
    /**
     * Method getCoursesList - return list of all courses
     * */
    public static List<Course> getCoursesList() {
        return coursesList;
    }
    // </editor-fold>
}
