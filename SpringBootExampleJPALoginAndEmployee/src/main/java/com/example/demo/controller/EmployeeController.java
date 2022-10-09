package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService es;
	
	@RequestMapping(value = "/addemp",method = RequestMethod.POST, consumes = "application/json" )
	public String getEmployeeData(@RequestBody Employee employee) {
		//System.out.println("Employee Data Register : " + employee);
		LOGGER.info("Register Data : " + employee);
		LOGGER.debug("Check Debug");
		LOGGER.warn("Check Warn");
		LOGGER.error("Error Check");
		es.addEmployeeDataWithLoginDetiels(employee);
		return "Data Register";
	}
}
