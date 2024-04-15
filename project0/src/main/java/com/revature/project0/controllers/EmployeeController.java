package com.revature.project0.controllers;

import com.revature.project0.models.Employee;
import com.revature.project0.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService empService;

    @Autowired
    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    /*
    Gets all employees in the database
    Returns a list of all employees
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return null;
    }

    /*
    Gets the employee with the given ID
    Returns the employee
     */
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        return null;
    }

    /*
    Creates a new employee with data in the request body
    returns the new employee
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return null;
    }

    /*
    Updates the password of the Employee with the given id
    returns the updated Employee
     */
    @PatchMapping("{id}")
    public ResponseEntity<Employee> updatePassword(@PathVariable int id, @RequestBody String password) {
        return null;
    }
}
