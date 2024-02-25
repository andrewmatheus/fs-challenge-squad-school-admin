package classes;

import java.util.List;

public class Course {
    // <editor-fold desc="Attributes">
    private String name;
    private Teacher teacher;
    private String courseDescription;
    private List<Class> classes;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    /**
     * Method Course - "overload"
     * */
    public Course(String name, Teacher teacher, String courseDescription) {
        this.name = name;
        this.teacher = teacher;
        this.courseDescription = courseDescription;
    }
    // </editor-fold>

    // <editor-fold desc="ToString">    
    @Override
    public String toString() {
        return "Curso: " +
                "Nome: " + name +
                ", Professor: " + teacher.getName();
    }
    // </editor-fold>

    // <editor-fold desc="methods">

    /**
     * Method setClasses - set in classes
     * */
    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    /**
     * Method getClasses - return list of classes
     * */
    public List<Class> getClasses() {
        return classes;
    }

    /**
     * Method getName - return course name
     * */
    public String getName() {
        return name;
    }

    /**
     * Method setName - set course name
     * no usage created start project - (case study)
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getTeacher - return course teacher
     * */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Method setTeacher - set teacher in course
     * */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Method getCourseDescription - return course description
     * no usage created start project - (case study)
     * */
    public String getCourseDescription() {
        return courseDescription;
    }

    /**
     * Method setCourseDescription - add course description
     * no usage created start project - (case study)
     * */
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }


    // </editor-fold>
}
