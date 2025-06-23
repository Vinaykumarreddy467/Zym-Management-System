package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.PromotionalMaterial;

public interface PromotionalMaterialRepository extends JpaRepository<PromotionalMaterial, Integer> {

	// Custom query methods can be defined here if needed
	// For example:
	// List<PromotionalMaterial> findByType(String type);
	// List<PromotionalMaterial> findByExpirationDateAfter(LocalDate date);

}
