package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Payment;
import com.example.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<String> processPayment(@RequestBody Payment payment) {
		paymentService.addPayment(payment);
		
		return new ResponseEntity<>("Payment processed successfully", HttpStatus.CREATED);
	}
	@PostMapping("/getall")
	public ResponseEntity<List<Payment>> getAllPayments() {
		return new ResponseEntity<>(paymentService.getPaymentHistory(), HttpStatus.OK);
	}
	
	@PostMapping("/getPaymentById")
	public ResponseEntity<Payment> getPaymentById(@RequestBody String paymentId) {
		Payment payment = paymentService.getPaymentById(paymentId);
		if (payment != null) {
			return new ResponseEntity<>(payment, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("{paymentId}")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable Integer paymentId) {
		Payment updatedPayment = paymentService.updatePayment(paymentId, payment);
		
		return new ResponseEntity<Payment>(updatedPayment, HttpStatus.OK);

	}
	@DeleteMapping("{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable Integer paymentId) {
		Payment payment = paymentService.getPaymentById(String.valueOf(paymentId));
		if (payment != null) {
			paymentService.deletePayment(paymentId);
			return new ResponseEntity<>("Payment deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Payment not found", HttpStatus.NOT_FOUND);
		}
	}
}
