package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	void registerEmployeeData(Employee employee);
	
	long getAllEmployeeCount();
	
	List<Employee> getAllEmployeeAgeWise(int age);
	
	List<Employee> getAllEmployeeAgeWiseEqual(int age);
	
	List<Employee> getEmployeeDataUsingFnameLike(String str);
	
	List<Employee> getEmployeeUsingFnameNotLike(String str);
}
