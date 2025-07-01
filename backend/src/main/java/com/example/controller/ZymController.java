package com.example.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Zym;
import com.example.service.ZymService;

@RestController
@RequestMapping("/api/zym/")
@CrossOrigin(origins = "http://localhost:4200")
public class ZymController {
	private static final Logger logger = LoggerFactory.getLogger(ZymController.class);
	
	@Autowired
	private ZymService zymService;
	

	@PostMapping("/add")
	public Zym addZym(@RequestBody Zym zym) {
		
		return zymService.addzym(zym);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Zym>> getAllZym() {
		List<Zym> zym = zymService.getAllZyms();
		if (zym != null && !zym.isEmpty()) {
			return new ResponseEntity<>(zym, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getById/{zymId}")
	public ResponseEntity<Zym> getZymById(@PathVariable Integer zymId) {
	    Zym zym = zymService.getZymById(zymId);
	    return new ResponseEntity<>(zym, HttpStatus.OK);
	}
		
	@PostMapping("update/{zymId}")
	public ResponseEntity<String> updateZym(@PathVariable("zymId") Integer zymId, @RequestBody Zym zym) {
		
		Zym existingZym = zymService.getZymById(zymId);
		
		existingZym.setZymName(zym.getZymName());
		existingZym.setZymAddress(zym.getZymAddress());
		
		zymService.updateZym(zymId, zym);
		return new ResponseEntity<String>("Workout plan updated successfully", HttpStatus.OK);
		
	}
		
	@DeleteMapping("delete/{zymId}")
	public ResponseEntity<List<Zym>> deleteWorkoutPlan(@PathVariable("zymId") Integer zymId) {
		List<Zym> response = zymService.deleteZym(zymId);
		if (response.equals("Workout plan deleted successfully")) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

}
