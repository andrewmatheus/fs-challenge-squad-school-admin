package enums;

public enum EnrollmentStatus {
    // <editor-fold desc="Enums">
    ACTIVE(1),
    LOCKED(2),
    GRADUATED(3);
    // </editor-fold>

    // <editor-fold desc="Attributes">
    private final int registrationValue;
    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Method EnrollmentStatus - receives and inserts into the registrationValue attribute
     * */
    EnrollmentStatus(int registrationValue) {
        this.registrationValue = registrationValue;
    }

    /**
     * Method EnrollmentStatus - returns the enum if found
     * no usage created start project - (case study)
     * */
    public static EnrollmentStatus getStatusNameFromIndex(int num) {
        for (EnrollmentStatus value : values()) {
            if (value.registrationValue == num) {
                return value;
            }
        }
        return null;
    }

    /**
     * Method getTranslatedStatusNameFromIndex - returns the already translated enum
     * */
    public static String getTranslatedStatusNameFromIndex(EnrollmentStatus status) {
        switch (status) {
            case ACTIVE -> {return "Ativo";}
            case LOCKED -> {return "Trancado";}
            case GRADUATED -> {return "Graduado";}
            default -> {return null;}
        }
    }
    // </editor-fold>
}
