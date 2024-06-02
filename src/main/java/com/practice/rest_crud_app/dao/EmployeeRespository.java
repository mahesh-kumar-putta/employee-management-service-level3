package com.practice.rest_crud_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.practice.rest_crud_app.entity.Employee;

//@RepositoryRestResource(path="customEndPoint")
// url will be localhost:8080/api/v1/customEndPoint
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
