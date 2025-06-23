package com.example.controller;

import java.util.List;
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
		return instructorService.getAllInstructors();
		//return instructors, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Instructor> getInstructorById(@PathVariable("id") Integer id) {
		Instructor instructor = instructorService.getInstructorById(id);
		return new ResponseEntity<>(instructor, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable("id") Integer id, @RequestBody Instructor updatedInstructor) {
		Instructor updated = instructorService.updateInstructor(id, updatedInstructor);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInstructor(@PathVariable("id") Integer id) {
		instructorService.deleteInstructorById(id);
		return new ResponseEntity<>("Instructor deleted successfully", HttpStatus.OK);
	}

}
