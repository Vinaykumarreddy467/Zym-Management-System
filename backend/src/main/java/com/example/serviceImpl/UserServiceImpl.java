package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
    	// this method is used to add a new user to the system 
    	// helps to register a new user with their details properties
    	 System.out.println(user);
    	 User nuser =new User();
    	 nuser.setPassword(user.getPassword());
    	 nuser.setUsername(user.getUsername());
    	 nuser.setCompleteName(user.getCompleteName());
    	 nuser.setAddress(user.getAddress());
    	 nuser.setRole(user.getRole());
    	 nuser.setContact(user.getContact());
    	 nuser.setEmail(user.getEmail());
    	 System.out.println(user.getContact());
    	 System.out.println(user.getUsername());
    	 
    	logger.info("Adding new user: {}", nuser);
        userRepository.save(nuser);
        
        return nuser;
       
    }

    @Override
    public User findById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        logger.info("Fetching user with id: {}", id);
        return userOptional.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<User> getAllUsers() {
    	
    	logger.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public boolean isUsernameAvailable(String username) {
    	User user = userRepository.findByUsername(username);
		if (user == null) {
			logger.info("Username is available: {}", username);
			return true;
		}else {
			logger.warn("Username is already taken: {}", username);
			return false;
		}
    }

    @Override
    public String updateById(Integer id, User user) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setCompleteName(user.getCompleteName());
            existingUser.setContact(user.getContact());
            existingUser.setAddress(user.getAddress());

            logger.info("Updating user with id: {}", id);
            userRepository.save(existingUser);
            return "User updated successfully";
        } else {
        	logger.error("User not found with id: {}", id);
            return "User not found";
        }
    }

    @Override
    public String deleteById(Integer id) {
        userRepository.deleteById(id);
        logger.info("Deleted user with id: {}", id);
        return "User deleted successfully";
    }

    @Override
	public User findByUsernameAndPassword(String username, String password) { 
    	
    	User user = userRepository.findByUsernameAndPassword(username, password);
    	logger.info("Finding user by username: {} and password: {}", username, password);
    	return user;
	}
  
}
