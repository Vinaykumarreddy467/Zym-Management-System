package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Payment;
import com.example.repository.PaymentRepository;
import com.example.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

	@Override
	public Payment getPaymentById(String paymentId) {
		// TODO Auto-generated method stub
		Payment payment = paymentRepository.findById(Integer.parseInt(paymentId))
				.orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));
		return payment;
	}

	@Override
	public List<Payment> getPaymentHistory() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
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
		existingPayment.setMember(payment.getMember());
		// Add any other fields that need to be updated
		return paymentRepository.save(existingPayment);
	}

	@Override
	public String deletePayment(Integer paymentId) {
		// TODO Auto-generated method stub
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));
		paymentRepository.delete(payment);
		
		return "Payment with id " + paymentId + " deleted successfully";
	}

	/*
	 * @Override public List<Payment> getPaymentHistoryByMemberId(String memberId) {
	 * // TODO Auto-generated method stub return
	 * paymentRepository.findByMemberId(memberId).getPayments(); }
	 * 
	 */

}
