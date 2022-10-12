package com.simplecrud.employeeexample.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.simplecrud.employeeexample.modal.Employee;

class EmployeeRepositoryTest {

	@Autowired
    private EmployeeRepository employeeRepo;
	
	 @Test
	    void isEmployeeExitsById() {
	        Employee employee = new Employee(1L, "Amiya", "Bhubaneswar", "Amiya123@gmail.com");
	        employeeRepo.save(employee);
	        Boolean actualResult = employeeRepo.isEmployeeExitsById(1L);
	        assertThat(actualResult).isTrue();
	    }

}
