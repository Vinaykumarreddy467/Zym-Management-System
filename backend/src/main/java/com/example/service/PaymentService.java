package com.example.service;

import java.util.List;

import com.example.model.Payment;

public interface PaymentService {
	
	Payment addPayment(Payment payment);
	Payment getPaymentById(Integer paymentId);
	List<Payment> getPaymentHistory();
	Payment updatePayment(Integer paymentId ,Payment payment);
	String deletePayment(Integer paymentId);
	//for a specific member
	//List<Payment> getPaymentHistoryByMemberId(String memberId);
	
	
	
	// Define methods for payment processing
	//Payment processPayment(Payment payment);
	// Method to process a payment for a member	
	// Method to refund a payment
	//Payment refundPayment(String paymentId);
	

}
