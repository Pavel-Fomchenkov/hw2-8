package pro.sky.javacoursepart2.hw28.employeesController;

import org.springframework.web.bind.annotation.*;

import pro.sky.javacoursepart2.hw28.model.Employee;
import pro.sky.javacoursepart2.hw28.employeeService.EmployeeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    private final EmployeeServiceImpl employees;

    private EmployeesController(EmployeeServiceImpl employees) {
        this.employees = employees;
    }

    @GetMapping
    public Collection<Employee> getEmployees() {
        return employees.getEmployees();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam(value = "firstName") String firstName,
                                @RequestParam(value = "lastName") String lastName) {
            return employees.addEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "lastName") String lastName) {
        return employees.findEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "lastName") String lastName) {
        return employees.removeEmployee(firstName, lastName);
    }

}
