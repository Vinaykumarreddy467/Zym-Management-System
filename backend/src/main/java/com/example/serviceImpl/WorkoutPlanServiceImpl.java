package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.WorkoutPlan;
import com.example.repository.WorkoutPlanRepository;
import com.example.service.WorkoutPlanService;

@Service
public  class WorkoutPlanServiceImpl implements WorkoutPlanService{
	
	@Autowired
	private WorkoutPlanRepository workoutPlanRepository; // Assuming you have a WorkoutPlanRepository for database operations

	@Override
	public WorkoutPlan addWorkoutPlan(WorkoutPlan workoutPlan) {
		// TODO Auto-generated method stub
		return workoutPlanRepository.save(workoutPlan); // Save the workout plan to the database
	}

	@Override
	public WorkoutPlan getWorkoutPlanById(Integer planId) {
		// TODO Auto-generated method stub
		return workoutPlanRepository.findById(planId)
				.orElseThrow(() -> new RuntimeException("Workout Plan not found with id: " + planId));
		
	}

	@Override
	public List<WorkoutPlan> getAllWorkoutPlans() {
		// TODO Auto-generated method stub
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
	   
	    return workoutPlanRepository.save(existingPlan); // Update the workout plan in the database
	}

	@Override
	public String deleteWorkoutPlan(Integer planId) {
		// TODO Auto-generated method stub
		WorkoutPlan workoutPlan = workoutPlanRepository.findById(planId)
				.orElseThrow(() -> new RuntimeException("Workout Plan not found with id: " + planId));
		workoutPlanRepository.delete(workoutPlan);
		return "Workout Plan deleted successfully with id: " + planId; // Delete the workout plan from the database
	}

	/*
	 * @Override public WorkoutPlan getWorkoutPlanByName(String name) { // TODO
	 * Auto-generated method stub List<WorkoutPlan> plans =
	 * workoutPlanRepository.findBy; if (plans != null && !plans.isEmpty()) { return
	 * plans.get(0); // Assuming you want the first match } return null; }
	 */
	
	
	
}
