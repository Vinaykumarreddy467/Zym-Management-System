package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.MembershipType;

public interface MembershipTypeRepository extends JpaRepository<MembershipType, Integer> {

	// Custom query methods can be defined here if needed
	// For example:
	// List<MembershipType> findByName(String name);
	// List<MembershipType> findByDurationMonths(int durationMonths);

}
