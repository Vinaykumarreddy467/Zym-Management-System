package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsernameAndPassword(String username, String password);
	public User findByUsername(String username);
		

}
