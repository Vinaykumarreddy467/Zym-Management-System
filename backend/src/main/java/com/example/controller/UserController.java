package com.example.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.example.service.EmailService; // Import EmailService
import com.example.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);	

	@Autowired
	private UserService userService;
	
	@Autowired // Inject EmailService
	private EmailService emailService;
	
	
	@PostMapping("/login") 
	public ResponseEntity<User> login(@RequestBody User user) {
		System.out.println("Login attempt for user: " + user.getEmail());
		User user1 = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if ( user1!= null) {
			logger.info("" + user1.getUsername() + " logged in successfully");
			logger.error("Error  in login attempt for user: " + user.getUsername());
	        return new ResponseEntity<>(user1, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
	    }
	}
	@PostMapping("/register")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User savedUser = userService.addUser(user);
		if (savedUser != null) {
			logger.info("User registered successfully: " + savedUser.getUsername());
			logger.info("User details: " + savedUser.getEmail());
			if (savedUser.getEmail() != null) {
	            String subject = "Welcome to Fit Deck Service!";
	            String body = "Dear " + savedUser.getCompleteName() + ",\n\n"
	                        + "Thank you for registering with us. Your username is: " + savedUser.getUsername() + "\n\n"
	                        + "We are excited to have you on board!\n\n"
	                        + "Best regards,\n"
	                        + "FitDeck Team";
	            emailService.sendEmail(savedUser.getEmail(), subject, body);
	            logger.info("Registration email sent to: " + savedUser.getEmail());
			} else {
                logger.warn("User registered, but no email address provided for " + savedUser.getUsername() + ". Skipping email notification.");
            }
		}
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	@GetMapping("/checkusername/{username}")
	public Boolean checkusername(@PathVariable("username") String username) {
		logger.info("Checking availability of username: " + username);
		boolean isAvailable = userService.isUsernameAvailable(username);
		if (isAvailable) {
			logger.info("Username is available: " + username);
			return true;
		} else {
			logger.warn("Username is already taken: " + username);
			return false;
		}
		
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