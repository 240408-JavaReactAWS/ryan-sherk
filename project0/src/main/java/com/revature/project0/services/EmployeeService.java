package com.revature.project0.services;

import com.revature.project0.models.Employee;
import com.revature.project0.repos.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeDAO empDAO;

    @Autowired
    public EmployeeService(EmployeeDAO empDAO) {
        this.empDAO = empDAO;
    }

    public List<Employee> getAllEmployees() {
        return empDAO.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optionalEmployee = empDAO.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new NoSuchElementException("No user found");
        }
        return optionalEmployee.get();
    }

    public Employee createNewEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = empDAO.findEmployeeByUsername(employee.getUsername());
        if (optionalEmployee.isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        empDAO.save(employee);
        return null;
    }

    public Employee updatePassword(int id, String password) {
        Optional<Employee> employee = empDAO.findById(id);
        if (employee.isEmpty()) {
            throw new NoSuchElementException("There was no employee found");
        }
        employee.get().setPassword(password);
        empDAO.save(employee.get());
        return employee.get();
    }
}
