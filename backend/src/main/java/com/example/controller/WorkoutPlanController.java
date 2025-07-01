package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.WorkoutPlan;
import com.example.service.WorkoutPlanService;

@RestController
@RequestMapping("/api/workoutPlans")
@CrossOrigin(origins = "http://localhost:4200")

public class WorkoutPlanController {
	private static final Logger logger = LoggerFactory.getLogger(WorkoutPlanController.class);
	
	@Autowired
	private WorkoutPlanService workoutPlanService;
	
	@PostMapping
	public ResponseEntity<String> addWorkoutPlan(@RequestBody WorkoutPlan workoutPlan) {
		workoutPlanService.addWorkoutPlan(workoutPlan);
		return new ResponseEntity<>("Workout plan added successfully", HttpStatus.CREATED);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<WorkoutPlan>> getAllWorkoutPlans() {
		List<WorkoutPlan> workoutPlans = workoutPlanService.getAllWorkoutPlans();
		if (workoutPlans != null && !workoutPlans.isEmpty()) {
			return new ResponseEntity<>(workoutPlans, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getbyid")
	public ResponseEntity<WorkoutPlan> getWorkoutPlanById(@RequestBody Integer workoutPlanId) {
		WorkoutPlan workoutPlan = workoutPlanService.getWorkoutPlanById(workoutPlanId);
		
			return new ResponseEntity<>(workoutPlan, HttpStatus.OK);
	}
	@PostMapping("{id}")
	public ResponseEntity<String> updateWorkoutPlan(@PathVariable("id") Integer workoutPlanId, @RequestBody WorkoutPlan workoutPlan) {
		
		WorkoutPlan existingPlan = workoutPlanService.getWorkoutPlanById(workoutPlanId);
		
		existingPlan.setWorkOutname(workoutPlan.getWorkOutname());
		existingPlan.setWorkoutDate(workoutPlan.getWorkoutDate());
		existingPlan.setWorkoutTime(workoutPlan.getWorkoutTime());
		existingPlan.setMember(workoutPlan.getMember());
		workoutPlanService.updateWorkoutPlan(workoutPlanId, existingPlan);
		return new ResponseEntity<String>("Workout plan updated successfully", HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteWorkoutPlan(@PathVariable("id") Integer workoutPlanId) {
		String response = workoutPlanService.deleteWorkoutPlan(workoutPlanId);
		if (response.equals("Workout plan deleted successfully")) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

}
