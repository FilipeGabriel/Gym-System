package com.homework.gymsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homework.gymsystem.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
