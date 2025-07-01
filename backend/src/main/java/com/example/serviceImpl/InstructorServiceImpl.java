package com.example.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Instructor;
import com.example.repository.InstructorRepository;
import com.example.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService {
    private static final Logger logger = LogManager.getLogger(InstructorServiceImpl.class);

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        logger.info("Adding new instructor: {}", instructor);
        Instructor savedInstructor = instructorRepository.save(instructor);
        logger.info("Successfully added instructor with id: {}", savedInstructor.getInstructorId());
        return savedInstructor;
    }

    @Override
    public Instructor getInstructorById(Integer instructorId) {
        logger.info("Fetching instructor with id: {}", instructorId);
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> {
                    logger.error("Instructor not found with id: {}", instructorId);
                    return new RuntimeException("Instructor not found with id: " + instructorId);
                });
        return instructor;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        logger.info("Fetching all instructors");
        List<Instructor> instructors = instructorRepository.findAll();
        logger.info("Retrieved {} instructors", instructors.size());
        return instructors;
    }

    @Override
    public Instructor updateInstructor(Integer instructorId, Instructor updatedInstructor) {
        logger.info("Updating instructor with id: {}", instructorId);
        Instructor existingInstructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> {
                    logger.error("Instructor not found with id: {}", instructorId);
                    return new RuntimeException("Instructor not found with id: " + instructorId);
                });
        existingInstructor.setName(updatedInstructor.getName());
        existingInstructor.setContact(updatedInstructor.getContact());
        existingInstructor.setEmail(updatedInstructor.getEmail());
        existingInstructor.setAddress(updatedInstructor.getAddress());
        Instructor savedInstructor = instructorRepository.save(existingInstructor);
        logger.info("Successfully updated instructor with id: {}", instructorId);
        return savedInstructor;
    }

    @Override
    public String  deleteInstructorById(Integer instructorId) {
        logger.info("Deleting instructor with id: {}", instructorId);
        Instructor existingInstructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> {
                    logger.error("Instructor not found with id: {}", instructorId);
                    return new RuntimeException("Instructor not found with id: " + instructorId);
                });
        instructorRepository.deleteById(instructorId);
        logger.info("Successfully deleted instructor with id: {}", instructorId);
		return "Deleted instructor with id: " + existingInstructor;

    }
}