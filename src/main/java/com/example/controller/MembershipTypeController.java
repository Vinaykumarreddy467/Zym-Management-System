package com.example.controller;

import java.util.List;

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

import com.example.model.MembershipType;
import com.example.service.MembershipTypeService;

@RestController
@RequestMapping("/api/membership-types")
@CrossOrigin(origins = "http://localhost:4200")
public class MembershipTypeController {
	
	@Autowired
	private MembershipTypeService membershipTypeService;
	// Define endpoints for CRUD operations on MembershipType here
	
	@PostMapping
	public ResponseEntity<MembershipType> addMembershipType(@RequestBody MembershipType membershipType) {
		MembershipType savedMembershipType = membershipTypeService.addMembershipType(membershipType);
		return new ResponseEntity<>(savedMembershipType, HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<MembershipType>> getAllMembershipTypes() {
		List<MembershipType> membershipTypes = membershipTypeService.getAllMembershipTypes();
		return new ResponseEntity<>(membershipTypes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MembershipType> getMembershipTypeById(@PathVariable("id") Integer id) {
		MembershipType membershipType = membershipTypeService.getMembershipTypeById(id);
		return new ResponseEntity<>(membershipType, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<MembershipType> updateMembershipType(@PathVariable("id") Integer id, @RequestBody MembershipType updatedMembershipType) {
		MembershipType updated = membershipTypeService.updateMembershipType(id, updatedMembershipType);
		return new ResponseEntity<MembershipType>(updated, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMembershipType(@PathVariable("id") Integer id) {
		membershipTypeService.deleteMembershipType(id);
		return new ResponseEntity<>("Membership Type deleted successfully", HttpStatus.OK);
	}
	
	

}
