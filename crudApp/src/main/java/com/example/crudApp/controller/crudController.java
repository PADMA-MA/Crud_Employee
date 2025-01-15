package com.example.crudApp.controller;

import com.example.crudApp.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.crudApp.service.crudService;

import java.util.List;
import java.util.Optional;

@RestController
public class crudController {

    @Autowired
    public crudService crudService;

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = crudService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Employee updated = crudService.updateEmployee(id, updatedEmployee);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployees() {
        return crudService.getAllEmployees();
    }

    @GetMapping("/employeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Optional<Employee> employee = crudService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        return crudService.deleteEmployee(id) ? ResponseEntity.ok("Successful") : ResponseEntity.notFound().build();
    }
}
