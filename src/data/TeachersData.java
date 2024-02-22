package data;

import classes.Student;
import classes.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeachersData {
    private static List<Teacher> teachersList = new ArrayList<>();

    public static List<Teacher> getTeachersList() {
        return teachersList;
    }


    public static void addTeacher(Teacher professor) {
        teachersList.add(professor);
    }

    public static void removeTeacherById(int id) {
        teachersList.remove(id);
    }

    public static Teacher findTeacherByName(String name) {
        for (Teacher teacher : TeachersData.getTeachersList()) {
            if (teacher.getName().equalsIgnoreCase(name)) {
                return teacher;
            }
        }
        return null;
    }

    public Teacher findTeacherById(int id) {
        if (id >= 0 && id < teachersList.size()) {
            return teachersList.get(id);
        } else {
            System.out.println("Invalid ID. Teacher could not be found.");
            return null;
        }
    }
}


