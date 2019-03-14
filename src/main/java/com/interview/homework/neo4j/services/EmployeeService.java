package com.interview.homework.neo4j.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interview.homework.neo4j.entity.Employee;
import com.interview.homework.neo4j.repositories.EmployeeRepository;



@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Transactional(readOnly = true)
	public Page<Employee> getAllEmployees(int pagenumber, int pagesize) throws Exception {
		Page<Employee> resPage = null;
		
		try{
			PageRequest pagerequest = PageRequest.of(pagenumber, pagesize);
			resPage = employeeRepository.getAllEmployees(pagerequest);	
		}catch(Exception e){
			throw new Exception(e);
		}
		return resPage;
		
	}
	
	public Employee createEmployee(int emp_id, String name) throws Exception {
		Employee employee = new Employee(name, emp_id);
		
		try{
		employeeRepository.createEmployee(emp_id,name);
		
		}catch(Exception e) {
			throw new Exception(e);
		}
		return employee;
	}
	
}
