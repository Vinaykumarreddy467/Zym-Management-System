package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.WorkoutPlan;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Integer> {

	// Custom query methods can be defined here if needed
	// For example:
	// List<WorkoutPlan> findByMemberId(String memberId);
	// List<WorkoutPlan> findByType(String type);
	// List<WorkoutPlan> findByDurationGreaterThan(int duration);

}
