package interfaces;

import enums.EmployeeLevel;

public interface IEmployee {
    void promotion();
    void setJobLevel(EmployeeLevel jobLevel);
    EmployeeLevel getJobLevel();
}
