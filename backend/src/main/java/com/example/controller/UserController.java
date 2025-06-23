package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login") 
	public ResponseEntity<User> login(@RequestBody User user) {
		User user1 = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if ( user1!= null) {
	        return new ResponseEntity<>(user1, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
	    }
	}
	@PostMapping("/register")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User savedUser = userService.addUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		User user = userService.findById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateUserById(@PathVariable("id") Integer id, @RequestBody User user) {
		String response = userService.updateById(id, user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") Integer id) {
		String response = userService.deleteById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}

