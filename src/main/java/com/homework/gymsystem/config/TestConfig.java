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
import com.homework.gymsystem.entities.Instructor;
import com.homework.gymsystem.entities.Student;
import com.homework.gymsystem.repositories.ActivityRepository;
import com.homework.gymsystem.repositories.ClassroomRepository;
import com.homework.gymsystem.repositories.InstructorRepository;
import com.homework.gymsystem.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");		//Testar criar uma classe para receber esse formato de forma statica
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Activity a1 = new Activity(null, "Swimming");
		Activity a2 = new Activity(null, "Dance");
		Activity a3 = new Activity(null, "Martial Arts");
		Activity a4 = new Activity(null, "Gym");	
		activityRepository.saveAll(Arrays.asList(a1, a2, a3, a4));
				
		Student s1 = new Student(null, "Filipe", Instant.now(), "Sucupira", "(81)98494-6724", "18/04/1997", 1.81, 65.5f);
		Student s2 = new Student(null, "Mariana", Instant.now(), "Sucupira", "(81)98494-6724", "24/02/2000", 1.61, 55.5f);
		Student s3 = new Student(null, "Alice", Instant.now(), "Canadá", "(81)98494-6724", "24/02/2023", 1.50, 40.5f);
		Student s4 = new Student(null, "Rebeca", Instant.now(), "México", "(81)98494-6724", "31/03/2003", 1.75, 60.0f);
		Student s5 = new Student(null, "Felix", Instant.now(), "USA", "(81)98494-6724", "01/10/1973", 1.75, 75.5f);
		Student s6 = new Student(null, "Oberly", Instant.now(), "Dubai", "(81)98494-6724", "15/08/1976", 1.72, 60.5f);
		Student s7 = new Student(null, "Sophia", Instant.now(), "Totó", "(81)98494-6724", "24/02/2000", 1.60, 50.8f);
		studentRepository.saveAll(Arrays.asList(s1, s2,s3, s4, s5, s6, s7));
		
		Instructor i1 = new Instructor(null, "112.019.554-32", "Instructor 1", LocalDateTime.parse("05/07/1984 00:00", dtf2), 123);
		Instructor i2 = new Instructor(null, "245.419.644-11", "Instructor 2", LocalDateTime.parse("09/11/1991 00:00", dtf2), 321);
		Instructor i3 = new Instructor(null, "379.539.793-28", "Instructor 3", LocalDateTime.parse("29/07/1978 00:00", dtf2), 456);
		Instructor i4 = new Instructor(null, "768.012.285-67", "Instructor 4", LocalDateTime.parse("20/01/1981 00:00", dtf2), 645);
		instructorRepository.saveAll(Arrays.asList(i1, i2, i3, i4));
		
		
		Classroom c1 = new Classroom(null, LocalDateTime.parse("03/01/2024 18:00", dtf2), LocalDateTime.parse("03/01/2024 00:00", dtf2), LocalDateTime.parse("10/01/2024 00:00", dtf2), a1, i1);
		Classroom c2 = new Classroom(null, LocalDateTime.parse("03/01/2024 15:00", dtf2), LocalDateTime.parse("04/01/2024 00:00", dtf2), LocalDateTime.parse("15/01/2024 00:00", dtf2), a2, i2);
		Classroom c3 = new Classroom(null, LocalDateTime.parse("03/01/2024 11:00", dtf2), LocalDateTime.parse("10/03/2024 00:00", dtf2), LocalDateTime.parse("01/04/2024 00:00", dtf2), a1, i3);
		Classroom c4 = new Classroom(null, LocalDateTime.parse("03/01/2024 22:00", dtf2), LocalDateTime.parse("19/02/2024 00:00", dtf2), LocalDateTime.parse("05/03/2024 00:00", dtf2), a3, i4);
		Classroom c5 = new Classroom(null, LocalDateTime.parse("03/01/2024 07:00", dtf2), LocalDateTime.parse("27/09/2024 00:00", dtf2), LocalDateTime.parse("27/10/2024 00:00", dtf2), a3, i2);
		Classroom c6 = new Classroom(null, LocalDateTime.parse("03/01/2024 08:00", dtf2), LocalDateTime.parse("02/10/2024 00:00", dtf2), LocalDateTime.parse("26/11/2024 00:00", dtf2), a3, i2);
		Classroom c7 = new Classroom(null, LocalDateTime.parse("03/01/2024 10:00", dtf2), LocalDateTime.parse("06/03/2024 00:00", dtf2), LocalDateTime.parse("15/04/2024 00:00", dtf2), a3, i3);
		Classroom c8 = new Classroom(null, LocalDateTime.parse("03/01/2024 19:00", dtf2), LocalDateTime.parse("15/06/2024 00:00", dtf2), LocalDateTime.parse("18/08/2024 00:00", dtf2), a3, i1);
		c1.setDuration(c1.duration());
		c2.setDuration(c2.duration());
		c3.setDuration(c3.duration());
		c4.setDuration(c4.duration());
		c5.setDuration(c5.duration());
		c6.setDuration(c6.duration());
		c7.setDuration(c7.duration());
		c8.setDuration(c8.duration());
		c1.getStudents().add(s2);
		c2.getStudents().add(s1);
		c3.getStudents().add(s7);
		c4.getStudents().add(s5);
		c5.getStudents().add(s4);
		c8.getStudents().add(s1);
		c1.getStudents().add(s1);
		c1.getStudents().add(s5);
		classroomRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8));
		
	}
	
}
