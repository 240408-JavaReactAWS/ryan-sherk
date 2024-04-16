package com.revature.project0.controllers;

import com.revature.project0.models.Employee;
import com.revature.project0.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

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
        try {
            // Select all persons and store the retrieved values in the object personList
            ArrayList<Employee> employeeList = new ArrayList<>(empService.getAllEmployees());
            // If no person found, return HttpStatus NO_CONTENT
            if (employeeList.isEmpty()) {
                return new ResponseEntity<>(NO_CONTENT);
            }
            // If person/s are found, return object personList with the list of the persons selected from table Person
            return new ResponseEntity<>(employeeList, OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(NO_CONTENT);
        }
    }

    /*
    Gets the employee with the given ID
    Returns the employee
     */
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee;
        try {
            employee = empService.getEmployeeById(id);
        } catch (Exception e) {
            // In case person is not found, return HttpStatus NOT_FOUND
            return new ResponseEntity<>(NOT_FOUND);
        }

        // If person with the id is found, return all values from this person
        return new ResponseEntity<>(employee, OK);

    }

    /*
    Creates a new employee with data in the request body
    returns the new employee
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee created;
        try {
            created = empService.createNewEmployee(employee);
        } catch (Exception e) {
            return new ResponseEntity<>(BAD_REQUEST);
        }
        return new ResponseEntity<>(created, OK);
    }

    /*
    Updates the password of the Employee with the given id
    returns the updated Employee
     */
    @PatchMapping("{id}")
    public ResponseEntity<Employee> updatePassword(@PathVariable int id, @RequestBody String password) {
        Employee updated;
        if (id <= 0 || password.isEmpty()) {
            return new ResponseEntity<>(BAD_REQUEST);
        }
        try {
            updated = empService.updatePassword(id, password);
        } catch (Exception e) {
            return  new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(updated, OK);
    }
}
