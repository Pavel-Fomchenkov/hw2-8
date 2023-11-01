package pro.sky.javacoursepart2.hw26.employeeService;

import pro.sky.javacoursepart2.hw26.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> getEmployees();
}
