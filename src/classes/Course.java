package classes;

public class Course {
    // <editor-fold desc="Attributes">
    private String name;
    private Teacher teacher;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }
    // </editor-fold>

    // <editor-fold desc="methods">
    /*
     * Method getName - return name course
     * */
    public String getName() {
        return name;
    }
    // </editor-fold>
}
