package com.rapidapi.controller;

import com.rapidapi.entity.Employee;
import com.rapidapi.service.EmployeeRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRestClient employeeRestClient;

    @GetMapping("/employees")
    public List<Employee> employeeList(){
        return employeeRestClient.retriveAllEmployees();
    }

    @GetMapping("/{empid}")
    public Employee getEmployeeById(@PathVariable int empid){
        return employeeRestClient.retriveEmployeeByID(empid);
    }

    @GetMapping("/{empName}")
    public List<Employee> getEmployeeByName(@PathVariable String empName){
        return employeeRestClient.retriveEmployeeByName(empName);
    }
}
