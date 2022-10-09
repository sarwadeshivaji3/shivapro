package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class MainController {

	@Autowired
	private EmployeeService es;
	
	@PostMapping(value = "/addemp",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Employee> registerData(@RequestBody Employee employee){
		System.out.println("Register Data : " + employee);
		es.registerEmployeeData(employee);
		return ResponseEntity.ok().body(employee);
	}
	
	@GetMapping("/empcount")
	public ResponseEntity<Long> getAllEmployeeCount(){
		long l = es.getAllEmployeeCount();
		return ResponseEntity.ok().body(l);
	}
	
	@GetMapping(value = "/findemp/{age}")
	public ResponseEntity<List<Employee>> getEmployeeLessThanAge(@PathVariable("age") int age){
		List<Employee> list = es.getAllEmployeeAgeWise(age);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/findempequal/{age}")
	public ResponseEntity<List<Employee>> geEmployeeLessThanAgeEqual(@PathVariable("age") int age){
		List<Employee> list = es.getAllEmployeeAgeWiseEqual(age);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/find/{fname}")
	public ResponseEntity<List<Employee>> getEmployeeDataUsingFname(@PathVariable("fname")String str){
		System.out.println("strData : " + str);
		List<Employee> list = es.getEmployeeDataUsingFnameLike(str);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/findnot/{fname}")
	public ResponseEntity<List<Employee>> getEmployeeUsingFnameNotLike(@PathVariable("fname")String str){
	System.out.println("strData : " + str);
	List<Employee> list = es.getEmployeeUsingFnameNotLike(str);
	return ResponseEntity.ok().body(list);
	}
	
}
