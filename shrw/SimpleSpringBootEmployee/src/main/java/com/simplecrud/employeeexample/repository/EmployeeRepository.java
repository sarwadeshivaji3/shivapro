package com.simplecrud.employeeexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplecrud.employeeexample.modal.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

}
