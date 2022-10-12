package com.simplecrud.employeeexample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.simplecrud.employeeexample.modal.Employee;
import com.simplecrud.employeeexample.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.repo = employeeRepository;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return this.repo.findAll();
	}
	
	@Override
	public Employee getEmployeeById(Long id) {
		
		return repo.findById(id).get(); 
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		//List<Employee> employees = new ArrayList<Employee>();  
		//repo.findAll().forEach(employees1 -> employees.add(employees1));  
		//repo.findAll().forEach(employees1 -> employees1.getClass());
		return employee;  
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		 repo.save(employee);  
		 return employee;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		//Employee foundEmployee = this.repo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee","id",id));
		this.repo.deleteById(id);
		repo.deleteById(id);  
	}

}
