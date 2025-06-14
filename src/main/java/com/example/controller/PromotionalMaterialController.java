package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PromotionalMaterial;
import com.example.service.PromotionalMaterialService;


@RestController
@RequestMapping("/api/promotional-materials")
@CrossOrigin(origins = "http://localhost:4200")
public class PromotionalMaterialController {
	
	@Autowired
	private PromotionalMaterialService promotionalMaterialService;
	
	@PostMapping
	public ResponseEntity<String> addPromotionalMaterial(@RequestBody PromotionalMaterial promotionalMaterial) {
		promotionalMaterialService.addPromotionalMaterial(promotionalMaterial);
		return new ResponseEntity<>("Promotional material added successfully", HttpStatus.CREATED);
	}
	@PostMapping("/getall")
	public ResponseEntity<List<PromotionalMaterial>> getAllPromotionalMaterials() {
		List<PromotionalMaterial> promotionalMaterial = promotionalMaterialService.getAllPromotionalMaterials();
		if (promotionalMaterial != null) {
			return new ResponseEntity<List<PromotionalMaterial>>(promotionalMaterial, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/getbyid")
	public ResponseEntity<PromotionalMaterial> getPromotionalMaterialById(@RequestBody Integer promotionId) {
		PromotionalMaterial promotionalMaterial = promotionalMaterialService.findById(promotionId);
				if (promotionalMaterial != null) {
			return new ResponseEntity<>(promotionalMaterial, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("{id}")
	public ResponseEntity<String> updatePromotionalMaterialById(@PathVariable("{id}") Integer promotionId,@RequestBody PromotionalMaterial promotionalMaterial) {
		
		PromotionalMaterial existingPromotionalMaterial = promotionalMaterialService.findById(promotionId);
		
		if (existingPromotionalMaterial == null) {
			return new ResponseEntity<>("Promotional material not found", HttpStatus.NOT_FOUND);
		}
		else {

			existingPromotionalMaterial.setName(promotionalMaterial.getName());
			existingPromotionalMaterial.setFileUpload(promotionalMaterial.getFileUpload());
			existingPromotionalMaterial.setUser(promotionalMaterial.getUser());
			
			promotionalMaterialService.updateById(promotionId, existingPromotionalMaterial);
			return new ResponseEntity<>("Promotional material updated successfully", HttpStatus.OK);
		}
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePromotionalMaterialById(@PathVariable("{id}") Integer promotionId) {
		PromotionalMaterial promotionalMaterial = promotionalMaterialService.findById(promotionId);
		if (promotionalMaterial != null) {
			promotionalMaterialService.deleteById(promotionId);
			return new ResponseEntity<String>("Promotional material deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Promotional material not found", HttpStatus.NOT_FOUND);
		}
	}
}
