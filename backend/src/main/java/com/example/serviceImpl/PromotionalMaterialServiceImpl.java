package com.example.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFoundException;
import com.example.model.PromotionalMaterial;
import com.example.repository.PromotionalMaterialRepository;
import com.example.service.PromotionalMaterialService;

@Service
public class PromotionalMaterialServiceImpl implements PromotionalMaterialService {
	private static final Logger logger = LogManager.getLogger(PromotionalMaterialServiceImpl.class);

	@Autowired
	private PromotionalMaterialRepository promotionalMaterialRepository;
	@Override
	public PromotionalMaterial addPromotionalMaterial(PromotionalMaterial promotionalMaterial) {
		// TODO Auto-generated method stub
		logger.info("Adding new promotional material: {}", promotionalMaterial);
		return promotionalMaterialRepository.save(promotionalMaterial);
	}

	@Override
	public PromotionalMaterial findById(Integer id) {
		
		// TODO Auto-generated method stub
		
		logger.info("Fetching promotional material with id: {}", id);
		return promotionalMaterialRepository.findById(id)
				.orElseThrow(() ->  new ResourceNotFoundException("Promotional Material", "id", id));
	}

	@Override
	public List<PromotionalMaterial> getAllPromotionalMaterials() {
		// TODO Auto-generated method stub
		logger.info("Fetching all promotional materials");
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
		
		logger.info("Updating promotional material with id: {}", id);
		return "Promotional Material updated successfully";
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		PromotionalMaterial existingMaterial = findById(id);
		promotionalMaterialRepository.delete(existingMaterial);
		
		logger.info("Deleting promotional material with id: {}", id);
		return "Promotional Material deleted successfully";
	}

}
