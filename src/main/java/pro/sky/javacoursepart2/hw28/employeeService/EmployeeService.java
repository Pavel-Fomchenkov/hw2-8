package pro.sky.javacoursepart2.hw28.employeeService;

import pro.sky.javacoursepart2.hw28.model.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map<String, Employee> getEmployees();
}
