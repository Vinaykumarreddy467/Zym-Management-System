package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	// Custom query methods can be defined here if needed
	// For example:
	// List<Member> findByLastName(String lastName);

}
