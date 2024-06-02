package com.practice.rest_crud_app.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.rest_crud_app.entity.Employee;
import com.practice.rest_crud_app.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable int empId){
		 Employee emp = employeeService.findById(empId);
		 if(emp == null) {
			 throw new RuntimeException("Employee doesn't exist with id :"+empId);
		 }
		 
		 return emp;
	}
	
	@PostMapping("/employees")
	public Employee AddEmployee(@RequestBody Employee emp) {
		emp.setId(0);
		
		Employee employee = employeeService.save(emp);
		
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeService.save(emp);
	}
	
	@DeleteMapping("/employees/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		Employee emp = employeeService.findById(empId);
		
		if(emp == null ) {
			throw new RuntimeException("employee not found with id "+empId);
		}
		
		employeeService.delete(empId);
		
		return "Employee with id: "+empId+" Deleted Successfully!";
	}
	
	
}
