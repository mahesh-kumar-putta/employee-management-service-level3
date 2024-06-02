package com.practice.rest_crud_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.rest_crud_app.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
