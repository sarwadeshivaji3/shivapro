package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	void addStudentData(Student student);
	
	Student loginCheckAll(String uname,String pass);
	
	Student getStudentDataUsingId(int id);
	
	Student updateStudentData(Student student);
	
	List<Student> getAllDataAfterDelete(int id);
}
