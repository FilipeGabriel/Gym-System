package com.homework.gymsystem.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.gymsystem.entities.Classroom;
import com.homework.gymsystem.services.ClassroomService;

@RestController
@RequestMapping(value = "/classrooms")
public class ClassroomResource {
	
	@Autowired
	private ClassroomService classroomService;
	
	@GetMapping
	public ResponseEntity<List<Classroom>> findAll(){
		List<Classroom> classrooms = classroomService.findAll();
		return ResponseEntity.ok().body(classrooms);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Classroom> findById(@PathVariable Long id) {
		Classroom classroom = classroomService.findById(id);
		return ResponseEntity.ok().body(classroom);
	}
	
}
