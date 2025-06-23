package com.example.service;

import java.util.List;

import com.example.model.Workout;

public interface WorkoutService {
	
	Workout addWorkout(Workout workout);
	Workout getWorkoutById(Integer workoutId);
	List<Workout> getAllWorkouts();
	Workout updateWorkout(Integer workoutId,Workout workout);
	String deleteWorkout(Integer id);
	//List<Workout> getWorkoutsByUserId(Integer userId);
}
