package com.homework.gymsystem.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.gymsystem.entities.Instructor;
import com.homework.gymsystem.services.InstructorService;

@RestController
@RequestMapping(value = "/instructors")
public class InstructorResource {
	
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping
	public ResponseEntity<List<Instructor>> findAll(){
		List<Instructor> instructors = instructorService.findAll();
		return ResponseEntity.ok().body(instructors);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Instructor> findById(@PathVariable Long id){
		Instructor instructor = instructorService.findById(id);
		return ResponseEntity.ok().body(instructor);
	}
	
}
