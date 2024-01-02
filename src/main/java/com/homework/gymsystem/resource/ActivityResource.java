package com.homework.gymsystem.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.gymsystem.entities.Activity;
import com.homework.gymsystem.services.ActivityService;

@RestController
@RequestMapping(value = "/activities")
public class ActivityResource {
	
	@Autowired
	private ActivityService activityService;
	
	@GetMapping
	public ResponseEntity<List<Activity>> findAll(){
		List<Activity> activities = activityService.findAll();
		return ResponseEntity.ok().body(activities);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Activity> findById(@PathVariable Long id){
		Activity activity = activityService.findById(id);
		return	ResponseEntity.ok().body(activity);
	}
	
}
