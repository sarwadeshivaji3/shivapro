package com.simplecrud.employeeexample.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.employeeexample.modal.Employee;
import com.simplecrud.employeeexample.repository.EmployeeRepository;
import com.simplecrud.employeeexample.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository repo;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		try { 
			List<Employee> employee = employeeService.getAllEmployees();
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		

	}

//	@GetMapping("/employees")
//    public ResponseEntity<?> list() {
//
//        List<Employee> employees = employeeService.getAllEmployees();
//
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//
//    }

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		try {
			Employee employee = employeeService.getEmployeeById(id);
			return new ResponseEntity<Employee>(employee, HttpStatus.FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	@GetMapping("/employee/{id}")
//
//    public ResponseEntity<Employee> get(@PathVariable Long id) {
//
//        try {
//
//            Employee employee = employeeService.getEmployeeById(id);
//
//            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//
//        } catch (NoSuchElementException e) {
//
//            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
//
//        }      
//
//    }

	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		try {
			employee = employeeService.addEmployee(employee);
		//	employee = repo.addEmployee(employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
//		return this.employeeService.saveEmployee(employee);
//		return this.employeeService.addEmployee(employee);
	}

//	@PostMapping("/employee")
//
//    public void add(@RequestBody Employee employee) {
//
//		employeeService.saveEmployee(employee);
//
//    }

	@PutMapping("employee/{id}")

	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee employee) {
		try {
			Employee existemployee = employeeService.updateEmployee(employee);
			existemployee.setId(id);
			existemployee.setFirstName(employee.getFirstName());
			existemployee.setLastName(employee.getLastName());
			existemployee.setEmail(employee.getEmail());
			
			Employee updated_employee = employeeService.updateEmployee(existemployee);
			return new ResponseEntity<Employee>(updated_employee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
//		return this.employeeService.updateEmployee(employee);
	}

//	@PutMapping("employee/{id}")
//
//	public void update(@RequestBody Employee employee, @PathVariable long id ) {
//
//	        Employee emp = employeeService.getEmployeeById(id);
//
//	        emp.setFirstName(employee.getFirstName());
//
//	        emp.setLastName(employee.getLastName());
//
//	        emp.setEmail(employee.getEmail());
//
////	        emp.setSalary(employee.getSalary());
////
////	        emp.setDepartment(employee.getDepartment());
//
//	        employeeService.saveEmployee(emp);
//
//	    }
//	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
		Employee employee = null;
		try {
			employee = employeeService.getEmployeeById(id);
			employeeService.deleteEmployeeById(id);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//		employeeService.deleteEmployeeById(id);
	}
}
