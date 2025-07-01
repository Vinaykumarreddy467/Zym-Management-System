package com.example.controller;

import java.util.List;
import org.json.JSONObject;
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

import com.example.model.Payment;
import com.example.model.User;
import com.example.service.PaymentService;
import com.example.service.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/payments")
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private UserService userService;

	private final String KEY_ID = "rzp_test_8mJ5HT9XEaSIhX";
	private final String KEY_SECRET = "OfELxKadbGMhF78CNM5Nvyno";

	@PostMapping("/{userId}")
	public ResponseEntity<?> processPayment(@PathVariable Integer userId,@RequestBody Payment payment) {
		try {
			
			if (payment.getPaymentId() != null && payment.getPaymentId() == 0) {
			    payment.setPaymentId(null);
			}

			RazorpayClient razorpayClient = new RazorpayClient(KEY_ID, KEY_SECRET);

			JSONObject orderRequest = new JSONObject();

			orderRequest.put("amount", payment.getAmount() );
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "receipt_order_" + System.currentTimeMillis());
			orderRequest.put("payment_capture", 1); //  1 means automatic capture, 0 means manual capture

			Order order = razorpayClient.orders.create(orderRequest);
			
			payment.setRazorpayOrderId(order.get("id"));
			
			User user =userService.findById(userId);
			payment.setUser(user);
			paymentService.addPayment(payment);
			
			return new ResponseEntity<>(order.toString(), HttpStatus.CREATED);
			
		} catch (RazorpayException e) {
			System.err.println("Razorpay Exception: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>("Error processing payment with Razorpay: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			System.err.println("General Exception during payment processing: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>("An unexpected error occurred during payment processing: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{paymentId}")
	public ResponseEntity<String> verifyUser(@PathVariable Integer paymentId) {
		 
		if (paymentService.getPaymentById(paymentId) == null ) {
			return new ResponseEntity<>("Payment found Succesfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Payment found", HttpStatus.OK);
	}
	@GetMapping("/getall")
	public List<Payment> getAllPayments() {
		List<Payment> payments = paymentService.getPaymentHistory();
		if (payments.isEmpty()) {
			return List.of();
		}
		return payments;
	}

	@GetMapping("/getPaymentById/{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Integer paymentId) {
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
		if (updatedPayment != null) {
			return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable Integer paymentId) {
		Payment payment = paymentService.getPaymentById(paymentId);
		if (payment != null) {
			paymentService.deletePayment(paymentId);
			return new ResponseEntity<>("Payment deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Payment not found", HttpStatus.NOT_FOUND);
		}
	}
}