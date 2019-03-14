package com.interview.homework.neo4j.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.interview.homework.neo4j.entity.Employee;


public interface EmployeeRepository extends Neo4jRepository<Employee, String>{
	
	@Query(value="MATCH (e:Employee) return e.emp_id as emp_id, e.name as name",
			   countQuery="MATCH (e:Employee) return count(distinct e)")
	Page<Employee> getAllEmployees(Pageable pageable);
	
	@Query("Create (e:Employee {emp_id: {0}, name: {1}}) return e.emp_id as emp_id, e.name as name")
	void createEmployee(int emp_id, String name);
}
