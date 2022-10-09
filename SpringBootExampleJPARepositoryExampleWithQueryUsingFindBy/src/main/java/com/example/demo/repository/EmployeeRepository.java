package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByAgeLessThan(int age);
	
	List<Employee> findByAgeLessThanEqual(int age);
	
	List<Employee> findByFnameLike(String str);
	
	List<Employee> findByFnameNotLike(String str);
}
