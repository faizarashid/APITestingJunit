package com.example.testcases.controllers;

import com.example.testcases.model.Employee;
import com.example.testcases.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/getEmp")
    private ResponseEntity<List<Employee>>  getEmployees(){
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK) ;
    }
    @PostMapping("/addEmp")
    private ResponseEntity<Employee>  addEmployee(@RequestBody Employee emp){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(emp), HttpStatus.OK) ;
    }
    @PutMapping("/updateEmp")
    private ResponseEntity<Employee>  updateEmployee(@RequestBody Employee emp){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(emp), HttpStatus.OK) ;
    }
    @DeleteMapping(value = "/{id}")
    private void delete(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
}
