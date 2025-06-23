package com.example.service;

import java.util.List;

import com.example.model.Instructor;

public interface InstructorService {
	
	Instructor addInstructor(Instructor instructor);
	Instructor getInstructorById(Integer instructorId);
	List<Instructor> getAllInstructors();
	Instructor updateInstructor(Integer instructorId, Instructor updatedInstructor);
	String deleteInstructorById(Integer instructorId);

}
