package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFoundException;
import com.example.model.PromotionalMaterial;
import com.example.repository.PromotionalMaterialRepository;
import com.example.service.PromotionalMaterialService;

@Service
public class PromotionalMaterialServiceImpl implements PromotionalMaterialService {

	@Autowired
	private PromotionalMaterialRepository promotionalMaterialRepository;
	@Override
	public PromotionalMaterial addPromotionalMaterial(PromotionalMaterial promotionalMaterial) {
		// TODO Auto-generated method stub
		return promotionalMaterialRepository.save(promotionalMaterial);
	}

	@Override
	public PromotionalMaterial findById(Integer id) {
		// TODO Auto-generated method stub
		return promotionalMaterialRepository.findById(id)
				.orElseThrow(() ->  new ResourceNotFoundException("Promotional Material", "id", id));
	}

	@Override
	public List<PromotionalMaterial> getAllPromotionalMaterials() {
		// TODO Auto-generated method stub
		return promotionalMaterialRepository.findAll();
	}

	@Override
	public String updateById(Integer id, PromotionalMaterial promotionalMaterial) {
		// TODO Auto-generated method stub
		PromotionalMaterial existingMaterial = findById(id);
		
		existingMaterial.setReview(promotionalMaterial.getReview());
		existingMaterial.setFileUpload(promotionalMaterial.getFileUpload());
		existingMaterial.setUser(promotionalMaterial.getUser());
		promotionalMaterialRepository.save(existingMaterial);
		return "Promotional Material updated successfully";
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		PromotionalMaterial existingMaterial = findById(id);
		promotionalMaterialRepository.delete(existingMaterial);
		return "Promotional Material deleted successfully";
	}

}
