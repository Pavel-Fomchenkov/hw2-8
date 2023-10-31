package pro.sky.javacoursepart2.hw26.employeeService;

import pro.sky.javacoursepart2.hw26.Employee;

public interface EmployeeService {
    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    String printEmployees();
}
