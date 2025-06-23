package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	 Member findByUserUserId(Integer userId);
}
