package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.service.EmployeeService;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @SuppressWarnings({"FieldCanBeLocal"})
    private final EmployeeService employeeService;

    // inject employee dao
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }


}
