package data;

import classes.Teacher;

import java.util.ArrayList;

public class TeachersData {
    // <editor-fold desc="Attributes">
    private static final ArrayList<Teacher> teachersList = new ArrayList<>();
    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Method getAllTeachers - return list of teachers
     * */
    public static ArrayList<Teacher> getAllTeachers() {
        return new ArrayList<>(teachersList);
    }

    /**
     * Method addTeacher - responsible for adding a teacher to the list.
     * */
    public static void addTeacher(Teacher professor) {
        teachersList.add(professor);
    }

    /**
     * Method removeTeacherById - remove teacher to list by id
     * */
    public static void removeTeacherById(int id) {
        teachersList.remove(id);
    }

    /**
     * Method findTeacherByName - responsible for finding a teacher on the list by name.
     * */
    public static Teacher findTeacherByName(String name) {
        for (Teacher teacher : TeachersData.getAllTeachers()) {
            if (teacher.getName().equalsIgnoreCase(name)) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * Method findTeacherById - responsible for finding a teacher on the list.
     * no usage created start project - (case study)
     * */
    public Teacher findTeacherById(int id) {
        if (id >= 0 && id < teachersList.size()) {
            return teachersList.get(id);
        } else {
            System.out.println("Professor(a) não pode ser encontrado(a), verifique se o índice foi informado corretamente.");
            return null;
        }
    }
    // </editor-fold>
}


