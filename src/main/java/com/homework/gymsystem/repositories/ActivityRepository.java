package com.homework.gymsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homework.gymsystem.entities.Activity;

public interface ActivityRepository extends	JpaRepository<Activity, Long>{

}
