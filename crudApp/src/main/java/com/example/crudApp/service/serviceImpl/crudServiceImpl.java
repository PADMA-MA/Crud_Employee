package com.example.crudApp.service.serviceImpl;

import com.example.crudApp.Entity.Employee;
import com.example.crudApp.jpa.EmployeeRepository;
import com.example.crudApp.service.crudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class crudServiceImpl implements crudService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get an employee by ID
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    //update Employee
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);

        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();

            // Update the fields you want to update, leaving 'id' unchanged
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setDesignation(updatedEmployee.getDesignation());
            existingEmployee.setSkills(updatedEmployee.getSkills());

            // Save the updated employee object
            return employeeRepository.save(existingEmployee);
        } else {
            return null;  // Employee with the given id not found
        }
    }

    // Delete an employee by ID
    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
