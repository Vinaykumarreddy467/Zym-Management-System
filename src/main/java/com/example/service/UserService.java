package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {
	
	User addUser(User user);
	User findById(Integer id);
	List<User> getAllUsers();
	String updateById(Integer id, User user);
	String deleteById(Integer id);
// add user
//	find user by id
//	find all users
//	update user
//	delete use
}
