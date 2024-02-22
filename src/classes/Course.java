package classes;

import java.util.List;

public class Course {
    // <editor-fold desc="Attributes">
    private String name;
    private Teacher teacher;
    private String courseDescription; //
    private List<Class> classes; // Lista de objetos Class associados a este curso
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    //overload
    public Course(String name, Teacher teacher, String courseDescription) {
        this.name = name;
        this.teacher = teacher;
        this.courseDescription = courseDescription;
    }
    // </editor-fold>

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Class> getClasses() {
        return classes;
    }

    // <editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Curso: " +
                "Nome: " + name +
                ", Professor: " + teacher.getName();
    }
    // </editor-fold>

    // <editor-fold desc="methods">
    /*
     * Method getName - return name course
     * */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }


    // </editor-fold>
}
