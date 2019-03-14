package com.interview.homework.neo4j.entity;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class Employee {
	
	private String name;
	private int emp_id;
	
	public Employee(String name, int emp_id) {
		super();
		this.name = name;
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	
}
