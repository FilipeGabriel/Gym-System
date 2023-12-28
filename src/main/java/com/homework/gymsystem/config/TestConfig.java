package com.homework.gymsystem.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.homework.gymsystem.entities.Student;
import com.homework.gymsystem.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		Student s1 = new Student(null, "Filipe", Instant.now(), "Sucupira", "(81)98494-6724", "18/04/1997", 1.81, 65.5f);
		Student s2 = new Student(null, "Mariana", Instant.now(), "Sucupira", "(81)98494-6724", "24/02/2000", 1.61, 55.5f);
		
		studentRepository.saveAll(Arrays.asList(s1, s2));
		
	}
	
}
