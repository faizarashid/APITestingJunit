package com.example.testcases.controller;

import com.example.testcases.controllers.EmployeeController;
import com.example.testcases.model.Employee;
import com.example.testcases.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
//@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getAllEmployees() throws Exception {

        Employee emp = new Employee();
        emp.setName("Test name 3");
        emp.setEmpId(3L);
        Employee emp1 = new Employee();
        emp1.setName("Test name 4");
        emp1.setEmpId(4L);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(emp);
        employees.add(emp1);

        when(employeeService.getAllEmployees()).thenReturn(employees);

        mvc.perform(MockMvcRequestBuilders.get("/getEmp")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.length()").value(2));

    }
}
