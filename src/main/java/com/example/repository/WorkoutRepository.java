package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

	// Custom query methods can be defined here if needed
	// For example:
	// List<Workout> findByType(String type);
	// List<Workout> findByDurationGreaterThan(int minutes);
	
	// Note: JpaRepository provides basic CRUD operations out of the box
	// Additional methods can be added as needed

}
