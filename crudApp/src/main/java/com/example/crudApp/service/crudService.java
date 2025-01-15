package com.example.crudApp.service;

import com.example.crudApp.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface crudService {

     boolean deleteEmployee(int id);
     Optional<Employee> getEmployeeById(int id);
     List<Employee> getAllEmployees();
     Employee updateEmployee(int id, Employee updatedEmployee);
     Employee createEmployee(Employee employee);
}
