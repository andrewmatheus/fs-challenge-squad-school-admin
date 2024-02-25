package enums;

public enum EmployeeLevel {
    // <editor-fold desc="Enums">
    BEGINNER(1),
    EXPERIENCED(2),
    ADVANCED(3);
    // </editor-fold>

    // <editor-fold desc="Attributes">
    private final int levelValue;
    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Method EmployeeLevel - receives and inserts into the levelValue attribute
     * */
    EmployeeLevel(int levelValue) {
        this.levelValue = levelValue;
    }

    /**
     * Method EmployeeLevel - returns the enum if found
     * no usage created start project - (case study)
     * */
    public static EmployeeLevel getStatusNameFromIndex(int num) {
        for (EmployeeLevel value : values()) {
            if (value.levelValue == num) {
                return value;
            }
        }
        return null;
    }

    /**
     * Method getTranslated - returns the already translated enum
     * */
    public static String getTranslated(EmployeeLevel status) {
        switch (status) {
            case BEGINNER -> {return "Iniciante";}
            case EXPERIENCED -> {return "Experiente";}
            case ADVANCED -> {return "Avançado";}
            default -> {return null;}
        }
    }
    // </editor-fold>
}