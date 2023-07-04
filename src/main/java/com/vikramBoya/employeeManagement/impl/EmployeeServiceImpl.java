package com.vikramBoya.employeeManagement.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikramBoya.employeeManagement.dto.EmployeeDto;
import com.vikramBoya.employeeManagement.entity.Employee;
import com.vikramBoya.employeeManagement.exception.ResourceNotFoundException;
import com.vikramBoya.employeeManagement.mapper.EmployeeMapper;
import com.vikramBoya.employeeManagement.repository.EmployeeRespository;
import com.vikramBoya.employeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRespository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeId(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exist with the given Id" + employeeId));

		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(long employeeId, EmployeeDto updatedEmployee) {

		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				"Employee is not exist with the given employee Id to update the details)" + employeeId));

		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());

		Employee updatedEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployeeById(long employeeId) {

		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				"Employee is not exist with the given employee Id to update the details)" + employeeId));

		employeeRepository.deleteById(employeeId);

	}

}
