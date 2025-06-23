package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Instructor;
import com.example.repository.InstructorRepository;
import com.example.service.InstructorService;

@Service
public class InstructorServiceImpl  implements InstructorService{

	@Autowired
	private InstructorRepository instructorRepository;
	@Override
	public Instructor addInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return instructorRepository.save(instructor);
	}

	@Override
	public Instructor getInstructorById(Integer instructorId) {
		// TODO Auto-generated method stub
		return instructorRepository.findById(instructorId)
				.orElseThrow(() -> new RuntimeException("Instructor not found with id: " + instructorId));
	}

	@Override
	public List<Instructor> getAllInstructors() {
		
		return instructorRepository.findAll();
	}

	@Override
	public Instructor updateInstructor(Integer instructorId, Instructor updatedInstructor) {
		// TODO Auto-generated method stub
		Instructor existingInstructor = instructorRepository.findById(instructorId)
				.orElseThrow(() -> new RuntimeException("Instructor not found with id: " + instructorId));
		existingInstructor.setName(updatedInstructor.getName());
		existingInstructor.setContact(updatedInstructor.getContact());
		existingInstructor.setEmail(updatedInstructor.getEmail());
		existingInstructor.setAddress(updatedInstructor.getAddress());
		
		return instructorRepository.save(existingInstructor);
	}

	@Override
	public String deleteInstructorById(Integer instructorId) {
		// TODO Auto-generated method stub
		Instructor existingInstructor = instructorRepository.findById(instructorId).get();
		instructorRepository.deleteById(existingInstructor.getInstructorId());
		return null;
	}

}
