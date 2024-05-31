package co.develhope.checkpoint.controllers;

import co.develhope.checkpoint.entities.Employee;
import co.develhope.checkpoint.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

}
