package pro.sky.javacoursepart2.hw26.employeesController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pro.sky.javacoursepart2.hw26.employeeService.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    private final EmployeeServiceImpl employees;
    private EmployeesController(EmployeeServiceImpl employees) {
        this.employees = employees;
    }
    @GetMapping
    public String greetings() {
        return "<b>База данных сотрудников: \n</b>" + employees.printEmployees();
    }
    @GetMapping("/add")
    public String addEmployee(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        employees.addEmployee(firstName, lastName);
        return "Новый сотрудник: " + firstName + " " + lastName + " успешно добавлен в БД.";
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        return "Сотрудник: " + employees.findEmployee(firstName, lastName).toString() + " содержится в БД.";
    }
    @GetMapping("/remove")
    public String removeEmployee(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        employees.removeEmployee(firstName, lastName);
        return "Сотрудник: " + firstName + " " + lastName + " удален из БД.";
    }

}
