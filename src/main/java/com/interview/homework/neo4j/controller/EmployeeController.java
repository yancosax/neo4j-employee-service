package com.interview.homework.neo4j.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.interview.homework.neo4j.entity.Employee;
import com.interview.homework.neo4j.services.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
@RestController
public class EmployeeController {
	
	private final EmployeeService  employeeService;	
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
    
	@GetMapping("employees")
	@ApiOperation(value="Return all employee nodes from the Neo4j Employee Graph")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="All Employee nodes found in the neo4j graph"),
			@ApiResponse(code = 500, message="Error connecting to the neo4j database")
	})
	public ResponseEntity<Page<Employee>> getAllGraphEmployees(
			@ApiParam(value = "Number of pages requested, default value is 0 if not provided", required = false)
			@RequestParam(name = " page", defaultValue = "0") int pageNumber,
			
			@ApiParam(value = "Size of pages requested, default value is 100 if not provided", required = false)
			@RequestParam(name = "size", defaultValue = "100") int pageSize			
			)throws Exception {
		
		ResponseEntity<Page<Employee>> resp = null;
		
		Page<Employee> page = employeeService.getAllEmployees(pageNumber,pageSize);
		
		if (page != null)
			resp = ResponseEntity.ok(page);
		else 
			throw new Exception();
		
		return resp;
	}	
	
	@PostMapping( path = "create/employee")
	@ApiOperation(value="Create an employee node in the Neo4j Employee Graph")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Employee successfully created"),
			@ApiResponse(code = 500, message="Error creating the new Employee")
	})
	public ResponseEntity<Employee> createEmployee(
			@ApiParam(value = "Id for new employee", required = true)
			@RequestParam int emp_id,
			
			@ApiParam(value = "Name for new employee",required = true)
			@RequestParam String name 
			) throws Exception{
		
		ResponseEntity<Employee> resp = null;
		Employee emp = employeeService.createEmployee(emp_id,name);
		
		if (emp != null) 
			resp = ResponseEntity.ok(emp);
		else 
			throw new Exception();
		
		return resp;
		
	}
	
}
