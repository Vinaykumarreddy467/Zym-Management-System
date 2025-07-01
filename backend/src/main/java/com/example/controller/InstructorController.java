package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Instructor;
import com.example.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
	
	private static final Logger logger = LoggerFactory.getLogger(InstructorController.class);
	@Autowired
	private InstructorService instructorService;
	
	@PostMapping
	public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
		Instructor savedInstructor = instructorService.addInstructor(instructor);
		return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "http://localhost/4200")
	@GetMapping("/getall")
	public List<Instructor> getAllInstructors() {
		List<Instructor> instructorList = instructorService.getAllInstructors();
		//return instructors, HttpStatus.OK);
		logger.info("Fetched all instructors successfully to api");
		return instructorList;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Instructor> getInstructorById(@PathVariable("id") Integer id) {
		Instructor instructor = instructorService.getInstructorById(id);
		logger.info("Fetched instructor with id: {} to api", id);
		return new ResponseEntity<>(instructor, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable("id") Integer id, @RequestBody Instructor updatedInstructor) {
		Instructor updated = instructorService.updateInstructor(id, updatedInstructor);
		logger.info("Updated instructor with id: {} successfully to api", id);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInstructor(@PathVariable("id") Integer id) {
		instructorService.deleteInstructorById(id);
		logger.info("Deleted instructor with id: {} successfully through api", id);
		return new ResponseEntity<>("Instructor deleted successfully", HttpStatus.OK);
	}

}
