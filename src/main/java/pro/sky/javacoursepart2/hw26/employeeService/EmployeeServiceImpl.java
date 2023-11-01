package pro.sky.javacoursepart2.hw26.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.javacoursepart2.hw26.Employee;
import pro.sky.javacoursepart2.hw26.exceptions.EmployeeAlreadyAddedException;
import pro.sky.javacoursepart2.hw26.exceptions.EmployeeNotFoundException;
import pro.sky.javacoursepart2.hw26.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int maxEmployees = 3;
    private final List<Employee> employees = new ArrayList<>(maxEmployees);

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if (employees.contains(e)) {
            throw new EmployeeAlreadyAddedException("В базе данных уже содержится данный сотрудник.");
        }
        if (employees.size() == maxEmployees) {
            throw new EmployeeStorageIsFullException("База данных переполнена.");
        }
        employees.add(e);
        return e;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (e.equals(employees.get(i))) {
                return employees.get(i);
            }
        }
        throw new EmployeeNotFoundException("Указанный сотрудник отсутвует в базе данных.");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee e = findEmployee(firstName, lastName);
        if (employees.contains(e)) {
            employees.remove(e);
            return e;
        }
        throw new EmployeeNotFoundException("Указанный сотрудник отсутвует в базе данных.");
    }

    @Override
    public List<Employee> getEmployees() {
        return this.employees;
    }
}
