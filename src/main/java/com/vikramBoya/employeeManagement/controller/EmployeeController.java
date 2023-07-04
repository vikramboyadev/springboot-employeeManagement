package com.vikramBoya.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikramBoya.employeeManagement.dto.EmployeeDto;
import com.vikramBoya.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping()
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {

		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	// get the employee details by giving the employee Id

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
		EmployeeDto employeeDto = employeeService.getEmployeeId(employeeId);
		return ResponseEntity.ok(employeeDto);

	}

	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	// this rest service wil update the existing employee information it is present
	// in database if not it wil through the error resource not found
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployeeInformation(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto updatedEmployee) {
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId) {

		employeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok("Employee Details deleted successfully");

	}

}
