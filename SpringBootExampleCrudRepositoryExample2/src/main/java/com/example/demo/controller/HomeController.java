package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class HomeController {

	@Autowired
	private StudentService stuService;
	
	@PostMapping(value = "/reg")
	public String registerStudentData(@RequestBody Student student) {
		System.out.println("Student Data : " + student);
		stuService.addStudentData(student);
		return "Data Register";
	}
	
	@GetMapping(value = "/getLogin")
	public Student getLoginCheck(@RequestParam String uname, @RequestParam String pass) {
		System.out.println("Login Credentails : " + uname + " " + pass);
		Student student = stuService.loginCheckAll(uname, pass);
		return student;
	}
	
	@PostMapping(value = "/getLogin")
	public Student getLoginCheckUsingPost(@RequestBody Student student) {
		System.out.println("Login Credentials : " + student.getUname() + " " + student.getPass());
		Student student1 = stuService.loginCheckAll(student.getUname(), student.getPass());
		return student1;
	}
	
	@GetMapping(value = "/get/{id}")
	public Student getStudentUsingId(@PathVariable("id") int id) {
		System.out.println("Get Id Using Path Variable " + id);
		Student student = stuService.getStudentDataUsingId(id);
		return student;
	}
	
	@PutMapping(value = "/update")
	public String updateStudentData(@RequestBody Student student) {
		System.out.println("Student update Data : " + student);
		Student student1 = stuService.updateStudentData(student);
		if(student1.getId()>0) {
			return "Data Updated";
		}
		return "Not Updated";
	}
	
	@DeleteMapping(value = "/del/{id}")
	public List<Student> getData(@PathVariable("id") int id){
		System.out.println("Id Data : " + id);
		List<Student> l =stuService.getAllDataAfterDelete(id);
		return l;
	}
}
