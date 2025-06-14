package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Workout;
import com.example.repository.WorkoutRepository;
import com.example.service.WorkoutService;

@Service
public class WorkoutServiceImpl implements WorkoutService{

	@Autowired
	private WorkoutRepository workoutRepository; // Assuming you have a WorkoutRepository for database operations
	@Override
	public Workout addWorkout(Workout workout) {
		// TODO Auto-generated method stub
		return workoutRepository.save(workout); // Save the workout to the database
	}

	@Override
	public Workout getWorkoutById(Integer id) {
		// TODO Auto-generated method stub
		return workoutRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + id));
	}

	@Override
	public List<Workout> getAllWorkouts() {
		// TODO Auto-generated method stub
		return workoutRepository.findAll(); // Retrieve all workouts from the database
	}

	@Override
	public Workout updateWorkout(Integer workoutId,Workout workout) {
		// TODO Auto-generated method stub
		Workout existingWorkout = workoutRepository.findById(workoutId)
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + workoutId));
		existingWorkout.setWorkoutName(workout.getWorkoutName());
		existingWorkout.setDescription(workout.getDescription());
		existingWorkout.setWorkoutPlan(workout.getWorkoutPlan()); // Assuming Workout has a WorkoutPlan field
		
		return workoutRepository.save(workout); // Update the workout in the database
	}

	@Override
	public String deleteWorkout(Integer id) {
		// TODO Auto-generated method stub
		Workout workout = workoutRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + id));
		workoutRepository.delete(workout); 
		
		return "Workout deleted successfully with id: " + id; // Delete the workout from the database
		
		
	}

}
