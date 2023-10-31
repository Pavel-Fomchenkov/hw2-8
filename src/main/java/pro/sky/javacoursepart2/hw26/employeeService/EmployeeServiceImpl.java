package pro.sky.javacoursepart2.hw26.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.javacoursepart2.hw26.Employee;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int maxEmployees = 10;
    private final List<Employee> employees = new ArrayList<>(maxEmployees);

    @Override
    public void addEmployee(String firstName, String lastName) {
        employees.add(new Employee(firstName, lastName));
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) == null) {
                System.out.println("Требуемый работник не найден");
                return null;
            }
            if (employees.get(i).getLastName().equals(lastName)
                    && employees.get(i).getFirstName().equals(firstName)) {
                return employees.get(i);
            }
        }
        return null;
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName,lastName);
        employees.remove(employee);
        System.out.printf("Работник: %s %s %s успешно удален из БД", firstName, lastName);
    }

    @Override
    public String printEmployees() {
        StringBuilder sb = new StringBuilder();
        sb.append("<pre>");
        for (int i = 0; i < employees.size(); i++) {
            sb.append(employees.get(i)).append("\n");
        }
        sb.append("</pre>");
        return sb.toString();
    }

}
