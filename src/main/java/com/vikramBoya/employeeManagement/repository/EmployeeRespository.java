package com.vikramBoya.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikramBoya.employeeManagement.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {

}
