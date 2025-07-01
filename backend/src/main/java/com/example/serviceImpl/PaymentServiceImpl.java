package com.example.serviceImpl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Payment;
import com.example.repository.PaymentRepository;
import com.example.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	private static final Logger logger = LogManager.getLogger(PaymentServiceImpl.class);
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		Payment paymentObj = paymentRepository.save(payment);
		logger.info("Adding new payment: {}", payment);
		return paymentObj;
	}

	@Override
	public Payment getPaymentById(Integer paymentId) {
		// TODO Auto-generated method stub
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));
		
		logger.info("Fetching payment with id: {}", paymentId);
		return payment;
	}

	@Override
	public List<Payment> getPaymentHistory() {
		// TODO Auto-generated method stub
		List<Payment> paymentHistory = paymentRepository.findAll();
		logger.info("Fetching all payment history");
		return paymentHistory;
	}

	@Override
	public Payment updatePayment(Integer paymentId, Payment payment) {
		// TODO Auto-generated method stub
		Payment existingPayment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));
		existingPayment.setAmount(payment.getAmount());
		existingPayment.setTime(payment.getTime());
		existingPayment.setDate(payment.getDate());
		existingPayment.setUser(payment.getUser());
		// Add any other fields that need to be updated
		
		 Payment paymentObj = paymentRepository.save(existingPayment);
		 logger.info("Updating payment with id: {}", paymentId);
		 return paymentObj;
	}

	@Override
	public String deletePayment(Integer paymentId) {
		// TODO Auto-generated method stub
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));
		paymentRepository.delete(payment);
		
		logger.info("Deleted payment with id: {}", paymentId);
		
		return "Payment with id " + paymentId + " deleted successfully";
	}

}
