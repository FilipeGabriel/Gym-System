package com.homework.gymsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.gymsystem.entities.Student;
import com.homework.gymsystem.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		return student.get();
	}
	
}
