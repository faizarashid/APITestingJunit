package com.example.testcases.service;

import com.example.testcases.model.Employee;
import com.example.testcases.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {

        Employee emp = new Employee();
        emp.setName("Test name 1");
        emp.setEmpId(1L);
        Employee emp1 = new Employee();
        emp1.setName("Test name 2");
        emp1.setEmpId(2L);

        Mockito.when(employeeRepository
                .findById(emp.getEmpId())).thenReturn(Optional.of(emp));

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(emp);
        employees.add(emp1);

        Mockito.when(employeeRepository.findAll()).thenReturn(employees);
    }
    @Test
    public void getAllEmployees() {

        List<Employee> emps = employeeService.getAllEmployees();
        Assert.assertEquals(emps.size(), 2);
    }
}
