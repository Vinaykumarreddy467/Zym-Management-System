
package com.example.payment;
import com.example.model.Payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import java.util.*;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:4200") // Adjust the origin as needed")
public class RazorpayController {

	@PostMapping("/api/payments")
	public ResponseEntity<?> createOrder(@RequestBody Payment payment) {
	    try {
	        System.out.println("Incoming Payment: " + new ObjectMapper().writeValueAsString(payment));

	        // Optional: null out ID if necessary
	        //payment.setPaymentId(null);

	        // Razorpay client logic here...
	        RazorpayClient client = new RazorpayClient("rzp_test_XXXX", "your_secret");
	        JSONObject options = new JSONObject();
	        options.put("amount", payment.getAmount());
	        options.put("currency", "INR");
	        options.put("receipt", "receipt_" + System.currentTimeMillis());

	        Order order = client.orders.create(options);

	        Map<String, Object> response = new HashMap<>();
	        response.put("id", order.get("id"));
	        response.put("amount", order.get("amount"));
	        response.put("currency", order.get("currency"));

	        return ResponseEntity.ok(response);

	    } catch (Exception e) {
	        e.printStackTrace(); // 👈 CHECK YOUR CONSOLE
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}

}

