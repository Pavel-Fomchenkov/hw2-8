package pro.sky.javacoursepart2.hw28.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.javacoursepart2.hw28.model.Employee;
import pro.sky.javacoursepart2.hw28.exceptions.EmployeeAlreadyAddedException;
import pro.sky.javacoursepart2.hw28.exceptions.EmployeeNotFoundException;
import pro.sky.javacoursepart2.hw28.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int maxEmployees = 3;
    private final Map<String, Employee> employees = new HashMap(maxEmployees);

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        String key = generateEmployeesMapKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("В базе данных уже содержится данный сотрудник.");
        }
        if (employees.size() == maxEmployees) {
            throw new EmployeeStorageIsFullException("База данных переполнена.");
        }
        employees.put(key, e);
        return e;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = generateEmployeesMapKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException("Указанный сотрудник отсутвует в базе данных.");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee e = findEmployee(firstName, lastName);
        String key = generateEmployeesMapKey(firstName, lastName);
        if (employees.containsKey(key)) {
            employees.remove(key);
            return e;
        }
        throw new EmployeeNotFoundException("Указанный сотрудник отсутвует в базе данных.");
    }

    @Override
    public Collection<Employee> getEmployees() {
        return Map.copyOf(employees).values();
    }

    private String generateEmployeesMapKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}
