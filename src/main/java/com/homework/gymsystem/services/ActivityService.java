package com.homework.gymsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.gymsystem.entities.Activity;
import com.homework.gymsystem.repositories.ActivityRepository;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	public List<Activity> findAll(){
		return activityRepository.findAll();
	}
	
	public Activity findById(Long id) {
		Optional<Activity> activity = activityRepository.findById(id);
		return activity.get();
	}
	
}
