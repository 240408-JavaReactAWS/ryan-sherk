package com.revature.project0.services;

import com.revature.project0.repos.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeDAO empDAO;

    @Autowired
    public EmployeeService(EmployeeDAO empDAO) {
        this.empDAO = empDAO;
    }
}
