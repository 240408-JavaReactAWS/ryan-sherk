package com.revature.project0.services;

import com.revature.project0.models.Employee;
import com.revature.project0.repos.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeDAO empDAO;

    @Autowired
    public EmployeeService(EmployeeDAO empDAO) {
        this.empDAO = empDAO;
    }

    public List<Employee> getAllEmployees() {
        return null;
    }

    public Employee getEmployeeById(int id) {
        return null;
    }

    public Employee createNewEmployee(Employee employee) {
        return null;
    }

    public Employee updatePassword(int id, String password) {
        return null;
    }
}
