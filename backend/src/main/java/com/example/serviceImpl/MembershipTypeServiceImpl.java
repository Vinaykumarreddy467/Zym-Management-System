package com.example.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.MembershipType;
import com.example.repository.MembershipTypeRepository;
import com.example.service.MembershipTypeService;


@Service
public class MembershipTypeServiceImpl implements MembershipTypeService{
	private static final Logger logger = LogManager.getLogger(MembershipTypeServiceImpl.class);
	
	@Autowired
	private MembershipTypeRepository membershipTypeRepository; // Assuming you have a repository for membership types

	

	@Override
	public List<MembershipType> getAllMembershipTypes() {
		// TODO Auto-generated method stub
		List<MembershipType> membershipTypes = membershipTypeRepository.findAll();
		logger.info("Fetching all membership types");
		return membershipTypes;
	}

	@Override
	public MembershipType updateMembershipType(Integer membershipTypeId, MembershipType updatedMembershipType) {
		// TODO Auto-generated method stub
		MembershipType existingMembershipType = membershipTypeRepository.findById(membershipTypeId)
				.orElseThrow(() -> new RuntimeException("Membership Type not found with id: " + membershipTypeId));
		existingMembershipType.setMemberShipname(updatedMembershipType.getMemberShipname());
		existingMembershipType.setMemberShipFee(updatedMembershipType.getMemberShipFee());
		existingMembershipType.setMembershipPeriod(updatedMembershipType.getMembershipPeriod());
		System.out.println("Membership Type updated successfully: " + existingMembershipType);
		
		MembershipType membershipType = membershipTypeRepository.save(existingMembershipType);
				logger.info("Updating membership type with id: {}", membershipTypeId);
		return membershipType ;
	
	}

	@Override
	public void deleteMembershipType(Integer membershipTypeId) {
		// TODO Auto-generated method stub
		MembershipType existingMembershipType = membershipTypeRepository.findById(membershipTypeId)
				.orElseThrow(() -> new RuntimeException("Membership Type not found with id: " + membershipTypeId));
		
		membershipTypeRepository.delete(existingMembershipType);
		logger.info("Deleting membership type with id: {}", membershipTypeId);
		
	}

	@Override
	public MembershipType getMembershipTypeById(Integer membershipTypeId) {
		// TODO Auto-generated method stub
		MembershipType membershipType = membershipTypeRepository.findById(membershipTypeId)
				.orElseThrow(() -> new RuntimeException("Membership Type not found with id: " + membershipTypeId));
		logger.info("Fetching membership type with id: {}", membershipTypeId);
		return membershipType;
	}

	@Override
	public MembershipType addMembership(MembershipType membershipType) {
		// TODO Auto-generated method stub
		
		MembershipType  membershipType1 = membershipTypeRepository.save(membershipType);
		logger.info("Adding new membership type: {}", membershipType1);
		return membershipType1; 
	}
	

}
