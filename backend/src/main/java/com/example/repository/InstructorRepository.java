package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	// Custom query methods can be defined here if needed
	// For example:
	// List<Instructor> findBySpecialization(String specialization);
	// List<Instructor> findByExperienceGreaterThan(int years);

}
