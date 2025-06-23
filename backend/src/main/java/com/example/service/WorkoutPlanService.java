package com.example.service;

import java.util.List;

import com.example.model.WorkoutPlan;

public interface WorkoutPlanService {
	
	WorkoutPlan addWorkoutPlan(WorkoutPlan workoutPlan);
	WorkoutPlan getWorkoutPlanById(Integer planId);
	List<WorkoutPlan> getAllWorkoutPlans();
	WorkoutPlan updateWorkoutPlan(Integer planId, WorkoutPlan workoutPlan);
	String deleteWorkoutPlan(Integer planId);
	//List<WorkoutPlan> getWorkoutPlansByMemberId(Integer memberId);
	//WorkoutPlan getWorkoutPlanByName(String workoutName);

}
