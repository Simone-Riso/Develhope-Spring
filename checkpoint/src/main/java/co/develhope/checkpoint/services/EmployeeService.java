package co.develhope.checkpoint.services;

import co.develhope.checkpoint.entities.Employee;
import co.develhope.checkpoint.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee create(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

}
