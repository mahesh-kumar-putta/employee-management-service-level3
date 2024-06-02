package com.practice.rest_crud_app.service;

import java.util.List;

import com.practice.rest_crud_app.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	Employee findById(int id);
	
	Employee save(Employee emp);
		
	void delete(int id);
}
