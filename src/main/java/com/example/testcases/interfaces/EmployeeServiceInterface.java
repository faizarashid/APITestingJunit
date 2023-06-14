package com.example.testcases.interfaces;

import com.example.testcases.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    Optional<Employee> getEmployeeById(long id);
    Employee updateEmployee(Employee updatedEmployee);
    void deleteEmployee(long id);
}
