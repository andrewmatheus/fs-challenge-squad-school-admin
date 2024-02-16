package data;

import classes.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeachersData {
    private static List<Teacher> teachersList = new ArrayList<>();

    public void addTeacher(Teacher professor) {
        teachersList.add(professor);
    }

    public void removeTeacher(int id) {
        try {
            Teacher removedTeacher = teachersList.remove(id);
            System.out.println("Teacher " + removedTeacher.getName() + " successfully removed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Invalid ID. Teacher could not be removed.");
        }
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


