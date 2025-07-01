package com.example.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Workout;
import com.example.repository.WorkoutRepository;
import com.example.service.WorkoutService;

@Service
public class WorkoutServiceImpl implements WorkoutService{
	private static final Logger logger = LogManager.getLogger(WorkoutServiceImpl.class);

	@Autowired
	private WorkoutRepository workoutRepository; 
	@Override
	public Workout addWorkout(Workout workout) {
		
		logger.info("Adding new workout: {}", workout);
		return workoutRepository.save(workout); 
	}

	@Override
	public Workout getWorkoutById(Integer id) {

		logger.info("Fetching workout with id: {}", id);
		return workoutRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + id));
	}

	@Override
	public List<Workout> getAllWorkouts() {
		// TODO Auto-generated method stub
		logger.info("Fetching all workouts");
		return workoutRepository.findAll(); 
	}

	@Override
	public Workout updateWorkout(Integer workoutId,Workout workout) {
		// TODO Auto-generated method stub
		Workout existingWorkout = workoutRepository.findById(workoutId)
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + workoutId));
		existingWorkout.setWorkoutName(workout.getWorkoutName());
		existingWorkout.setDescription(workout.getDescription());
		existingWorkout.setWorkoutPlan(workout.getWorkoutPlan()); 
		
		logger.info("Updating workout with id: {}", workoutId);
		return workoutRepository.save(workout); 
	}

	@Override
	public String deleteWorkout(Integer id) {
		// TODO Auto-generated method stub
		Workout workout = workoutRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + id));
		workoutRepository.delete(workout); 
		
		logger.info("Deleted workout with id: {}", id);
		return "Workout deleted successfully with id: " + id;		
	}

}
