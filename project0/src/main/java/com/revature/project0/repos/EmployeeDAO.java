package com.revature.project0.repos;

import com.revature.project0.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

    Optional<Employee> findEmployeeByUsername(String username);
}
