package enums;

public enum EnrollmentStatus {
    ACTIVE(1),
    LOCKED(2),
    GRADUATED(3);

    private final int registrationValue;

    EnrollmentStatus(int registrationValue) {
        this.registrationValue = registrationValue;
    }

    public static EnrollmentStatus getStatusNameFromIndex(int num) {
        for (EnrollmentStatus value : values()) {
            if (value.registrationValue == num) {
                return value;
            }
        }
        return null;
    }

    public static String getTranslatedStatusNameFromIndex(EnrollmentStatus status) {
        switch (status) {
            case ACTIVE -> {return "Ativo";}
            case LOCKED -> {return "Trancado";}
            case GRADUATED -> {return "Graduado";}
            default -> {return null;}
        }
    }
}
