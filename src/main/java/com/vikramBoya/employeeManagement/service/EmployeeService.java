package com.vikramBoya.employeeManagement.service;

import java.util.List;

import com.vikramBoya.employeeManagement.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto getEmployeeId(Long employeeId);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto updateEmployee(long employeeId, EmployeeDto updatedEmployee);

	void deleteEmployeeById(long employeeId);

}
