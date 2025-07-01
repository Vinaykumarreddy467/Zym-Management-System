package com.example.serviceImpl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Zym;
import com.example.repository.ZymRepository;
import com.example.service.ZymService;

@Service
public class ZymServiceImpl implements ZymService{
	private static final Logger logger = LogManager.getLogger(ZymServiceImpl.class);
	
	@Autowired
	private ZymRepository zymRepository;
	
	@Override
	public Zym addzym(Zym zym) {
		logger.info("Adding new zym record: {}", zym);
		return zymRepository.save(zym);
	}

	@Override
	public Zym getZymById(Integer zymid) {
		logger.info("Fetching zym record with id: {}", zymid);		
		return zymRepository.findById(zymid)
				.orElseThrow(() -> new RuntimeException("Zym not found with id: " + zymid));
	}

	@Override
	public List<Zym> getAllZyms() {
		logger.info("Fetching all zym records");
		
		return zymRepository.findAll();
	}

	@Override
	public Zym updateZym(Integer zymId, Zym zym) {
		Zym existingZym = zymRepository.findById(zymId)
				.orElseThrow(() -> new RuntimeException("Zym not found with id: " +zymId));
		
			existingZym.setZymName(zym.getZymName());
			existingZym.setZymAddress(zym.getZymAddress());
			logger.info("Updating zym record with id: {}", zymId);
			return zymRepository.save(existingZym);
	}

	@Override
	public List<Zym> deleteZym(Integer zymId) {
		Zym zym = zymRepository.findById(zymId)
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + zymId));
		zymRepository.delete(zym);
		logger.info("Deleted zym record with id: {}", zymId);
		return zymRepository.findAll() ; 
	}		


}
