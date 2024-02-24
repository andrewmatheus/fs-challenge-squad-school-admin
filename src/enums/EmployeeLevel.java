package enums;

public enum EmployeeLevel {
    BEGINNER(1),
    EXPERIENCED(2),
    ADVANCED(3);

    private final int levelValue;

    EmployeeLevel(int levelValue) {
        this.levelValue = levelValue;
    }

    public static EmployeeLevel getStatusNameFromIndex(int num) {
        for (EmployeeLevel value : values()) {
            if (value.levelValue == num) {
                return value;
            }
        }
        return null;
    }

    public static String getTranslated(EmployeeLevel status) {
        switch (status) {
            case BEGINNER -> {return "Iniciante";}
            case EXPERIENCED -> {return "Experiente";}
            case ADVANCED -> {return "Avançado";}
            default -> {return null;}
        }
    }
}