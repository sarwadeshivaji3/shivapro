package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository er;
	
	@Override
	public void registerEmployeeData(Employee employee) {
		// TODO Auto-generated method stub
		er.save(employee);
	}

	@Override
	public long getAllEmployeeCount() {
		// TODO Auto-generated method stub
		return er.count();
	}

	@Override
	public List<Employee> getAllEmployeeAgeWise(int age) {
		// TODO Auto-generated method stub
		return er.findByAgeLessThan(age);
		
	}

	@Override
	public List<Employee> getAllEmployeeAgeWiseEqual(int age) {
		// TODO Auto-generated method stub
		return er.findByAgeLessThanEqual(age);
	}

	@Override
	public List<Employee> getEmployeeDataUsingFnameLike(String str) {
		// TODO Auto-generated method stub
		return er.findByFnameLike(str);
	}

	@Override
	public List<Employee> getEmployeeUsingFnameNotLike(String str) {
		// TODO Auto-generated method stub
		return er.findByFnameNotLike(str);
	}

}
