package data;

import classes.Class;
import classes.Course;
import classes.Teacher;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CoursesData {
    // <editor-fold desc="Attributes">
    private static final ArrayList<Course> coursesList = new ArrayList<>();
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
        if (id >= 0 && id < coursesList.size()) {
            Course course = coursesList.get(id);
            ArrayList<Class> classes = ClassesData.getClassessAssociatedWithCourse(course);
            for (Class currentClass : classes) {
                ClassesData.removeClass(currentClass);
            }
            coursesList.remove(course);
            System.out.println("Curso: " + course.getName() + " removido com sucesso.");
        } else {
            throw new IndexOutOfBoundsException("ID do curso inválido.");
        }
    }

    public static void removeCourse(Course course) {
        removeCourse(coursesList.indexOf(course));
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
    public static ArrayList<Course> getAllCourses() {
        return new ArrayList<>(coursesList);
    }

    public static ArrayList<Course> getCoursesWithTeacher(Teacher teacher) {
        ArrayList<Course> courses = new ArrayList<>();

        for (Course course : coursesList) {
            if (course.getTeacher().equals(teacher)) {
                courses.add(course);
            }
        }

        return courses;
    }
    // </editor-fold>
}
