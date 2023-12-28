package com.homework.gymsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.gymsystem.entities.Classroom;
import com.homework.gymsystem.repositories.ClassroomRepository;

@Service
public class ClassroomService {
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	public List<Classroom> findAll(){
		return classroomRepository.findAll();
	}
	
	public Classroom findById(Long id){
		Optional<Classroom> cr = classroomRepository.findById(id);
		return cr.get();
	}
	
}
