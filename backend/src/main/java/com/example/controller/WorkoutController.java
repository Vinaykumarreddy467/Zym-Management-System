package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Workout;
import com.example.service.WorkoutService;

@RestController
@RequestMapping("/api/workOuts")
@CrossOrigin(origins = "http://localhost:4200")

public class WorkoutController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@PostMapping
	public ResponseEntity<String> addWorkout(@RequestBody Workout workout) {
		workoutService.addWorkout(workout);
		return new ResponseEntity<>("Workout added successfully", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<Workout>> getAllWorkouts() {
		List<Workout> workouts = workoutService.getAllWorkouts();
		if (workouts != null && !workouts.isEmpty()) {
			return new ResponseEntity<>(workouts, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getbyid")
	public ResponseEntity<Workout> getWorkoutById(@RequestBody Integer workoutId) {
		Workout workout = workoutService.getWorkoutById(workoutId);
		if (workout != null) {
			return new ResponseEntity<>(workout, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Workout> updateWorkout(@PathVariable Integer id, @RequestBody Workout workout) {
		Workout updatedWorkout = workoutService.updateWorkout(id, workout);
		if (updatedWorkout != null) {
			return new ResponseEntity<Workout>(updatedWorkout, HttpStatus.OK);
		} else {
			return new ResponseEntity<Workout>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteWorkout(@PathVariable Integer id) {
		String response = workoutService.deleteWorkout(id);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Workout not found", HttpStatus.NOT_FOUND);
		}
	}

}
