package com.example.demo.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

	Student finByUnameAndPass(String uname, String pass);
}
