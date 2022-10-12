package com.simplecrud.employeeexample.service;

import java.util.List;

import com.simplecrud.employeeexample.modal.Employee;


public interface EmployeeService {

	
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Long id);
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployeeById(Long id);
}
