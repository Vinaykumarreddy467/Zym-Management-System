package com.example.service;

import java.util.List;


import com.example.model.PromotionalMaterial;

public interface PromotionalMaterialService {
	
	
	// Define methods for managing promotional materials
	PromotionalMaterial addPromotionalMaterial(PromotionalMaterial promotionalMaterial);
	PromotionalMaterial findById(Integer id);
	List<PromotionalMaterial> getAllPromotionalMaterials();
	String updateById(Integer id, PromotionalMaterial promotionalMaterial);
	String deleteById(Integer id);
	

}
