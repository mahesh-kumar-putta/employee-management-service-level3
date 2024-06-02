package com.practice.rest_crud_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.rest_crud_app.dao.EmployeeRespository;
import com.practice.rest_crud_app.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRespository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRespository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		return emp.get();
	}

	@Override
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}

	@Override
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

}
