package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {	

	// Custom query methods can be defined here if needed
	// For example:
	// List<Payment> findByUserId(String userId);
	// List<Payment> findByStatus(String status);

}
