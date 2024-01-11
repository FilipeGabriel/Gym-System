package com.homework.gymsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.gymsystem.entities.Instructor;
import com.homework.gymsystem.repositories.InstructorRepository;

@Service
public class InstructorService {
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	public List<Instructor> findAll(){
		return instructorRepository.findAll();
	}
	
	public Instructor findById(Long id) {
		Optional<Instructor> instructor = instructorRepository.findById(id);
		return instructor.get();
	}
	
}
