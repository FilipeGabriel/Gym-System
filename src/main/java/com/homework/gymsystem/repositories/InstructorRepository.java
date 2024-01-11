package com.homework.gymsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homework.gymsystem.entities.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
