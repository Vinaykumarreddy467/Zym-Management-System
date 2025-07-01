package com.example.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.WorkoutPlan;
import com.example.repository.WorkoutPlanRepository;
import com.example.service.WorkoutPlanService;

@Service
public  class WorkoutPlanServiceImpl implements WorkoutPlanService{
	private static final Logger logger = LogManager.getLogger(WorkoutPlanServiceImpl.class);
	
	@Autowired
	private WorkoutPlanRepository workoutPlanRepository; // Assuming you have a WorkoutPlanRepository for database operations

	@Override
	public WorkoutPlan addWorkoutPlan(WorkoutPlan workoutPlan) {
		// TODO Auto-generated method stub
		logger.info("Adding new workout plan: {}", workoutPlan);
		return workoutPlanRepository.save(workoutPlan); // Save the workout plan to the database
	}

	@Override
	public WorkoutPlan getWorkoutPlanById(Integer planId) {
		// TODO Auto-generated method stub
		logger.info("Fetching workout plan with id: {}", planId);
		return workoutPlanRepository.findById(planId)
				.orElseThrow(() -> new RuntimeException("Workout Plan not found with id: " + planId));
		
	}

	@Override
	public List<WorkoutPlan> getAllWorkoutPlans() {
		// TODO Auto-generated method stub
		logger.info("Fetching all workout plans");
		return workoutPlanRepository.findAll(); // Retrieve all workout plans from the database
	}

	@Override
	public WorkoutPlan updateWorkoutPlan(Integer planId, WorkoutPlan workoutPlan) {
		// TODO Auto-generated method stub
		WorkoutPlan existingPlan = workoutPlanRepository.findById(planId)
				.orElseThrow(() -> new RuntimeException("Workout Plan not found with id: " + planId));
		
	    existingPlan.setWorkoutDate(workoutPlan.getWorkoutDate());
	    existingPlan.setWorkoutTime(workoutPlan.getWorkoutTime());
	    existingPlan.setMember(workoutPlan.getMember());
	    existingPlan.setInstructor(workoutPlan.getInstructor());
	   
	    logger.info("Updating workout plan with id: {}", planId);
	    return workoutPlanRepository.save(existingPlan); 
	}

	@Override
	public String deleteWorkoutPlan(Integer planId) {
		// TODO Auto-generated method stub
		WorkoutPlan workoutPlan = workoutPlanRepository.findById(planId)
				.orElseThrow(() -> new RuntimeException("Workout Plan not found with id: " + planId));
		workoutPlanRepository.delete(workoutPlan);
		
		logger.info("Deleted workout plan with id: {}", planId);
		return "Workout Plan deleted successfully with id: " + planId; 
	}
	
	
}
