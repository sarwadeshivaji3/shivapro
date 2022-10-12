package com.simplecrud.employeeexample.service;

import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;


import com.simplecrud.employeeexample.repository.EmployeeRepository;

class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepo;

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void getAllEmployee() {
		employeeService.getAllEmployees();
		verify(employeeRepo).findAll();

	}

}