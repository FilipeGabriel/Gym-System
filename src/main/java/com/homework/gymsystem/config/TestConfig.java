package com.homework.gymsystem.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.homework.gymsystem.entities.Activity;
import com.homework.gymsystem.entities.Classroom;
import com.homework.gymsystem.entities.Student;
import com.homework.gymsystem.repositories.ActivityRepository;
import com.homework.gymsystem.repositories.ClassroomRepository;
import com.homework.gymsystem.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Activity a1 = new Activity(null, "Swimming");
		Activity a2 = new Activity(null, "Dance");
		Activity a3 = new Activity(null, "Martial Arts");
		Activity a4 = new Activity(null, "Gym");	
		activityRepository.saveAll(Arrays.asList(a1, a2, a3, a4));
				
		Student s1 = new Student(null, "Filipe", Instant.now(), "Sucupira", "(81)98494-6724", "18/04/1997", 1.81, 65.5f);
		Student s2 = new Student(null, "Mariana", Instant.now(), "Sucupira", "(81)98494-6724", "24/02/2000", 1.61, 55.5f);		
		studentRepository.saveAll(Arrays.asList(s1, s2));
		
		Classroom c1 = new Classroom(null, LocalDateTime.parse("03/01/2024 18:00", dtf2), LocalDateTime.parse("03/01/2024 00:00", dtf2), LocalDateTime.parse("10/01/2024 00:00", dtf2));
		Classroom c2 = new Classroom(null, LocalDateTime.parse("03/01/2024 15:00", dtf2), LocalDateTime.parse("04/01/2024 00:00", dtf2), LocalDateTime.parse("15/01/2024 00:00", dtf2));
		c1.setDuration(c1.duration());
		c2.setDuration(c2.duration());		
		classroomRepository.saveAll(Arrays.asList(c1, c2));
			
	}
	
}
