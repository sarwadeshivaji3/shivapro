package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository sr;
	
	@Override
	public void addStudentData(Student student) {
		// TODO Auto-generated method stub
		sr.save(student);
	}

	@Override
	public Student loginCheckAll(String uname, String pass) {
		// TODO Auto-generated method stub
		return sr.finByUnameAndPass(uname, pass);
	}

	@Override
	public Student getStudentDataUsingId(int id) {
		// TODO Auto-generated method stub
		Student student = sr.findById(id).get();
		return student;
	}

	@Override
	public Student updateStudentData(Student student) {
		// TODO Auto-generated method stub
		Student s = sr.save(student);
		return s;
	}

	@Override
	public List<Student> getAllDataAfterDelete(int id) {
		// TODO Auto-generated method stub
		//1st way
		sr.deleteById(id);
		List<Student> list = (List<Student>) sr.findAll();
		//2nd way
//		Student student = sr.findById(id).get();
//		sr.delete(student);
//		List<Student> list1 = (List<Student>) sr.findAll();
		return list;
	}

}
