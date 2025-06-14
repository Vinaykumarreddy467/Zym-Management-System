package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.MembershipType;
import com.example.repository.MembershipTypeRepository;
import com.example.service.MembershipTypeService;

@Service
public class MembershipTypeServiceImpl implements MembershipTypeService{

	@Autowired
	private MembershipTypeRepository membershipTypeRepository; // Assuming you have a repository for membership types

	@Override
	public MembershipType addMembershipType(MembershipType membershipType) {
		// TODO Auto-generated method stub
		return membershipTypeRepository.save(membershipType);
	}

	@Override
	public List<MembershipType> getAllMembershipTypes() {
		// TODO Auto-generated method stub
		return membershipTypeRepository.findAll();
	}

	@Override
	public MembershipType updateMembershipType(Integer membershipTypeId, MembershipType updatedMembershipType) {
		// TODO Auto-generated method stub
		MembershipType existingMembershipType = membershipTypeRepository.findById(membershipTypeId)
				.orElseThrow(() -> new RuntimeException("Membership Type not found with id: " + membershipTypeId));
		existingMembershipType.setName(updatedMembershipType.getName());
		existingMembershipType.setMemberShipFee(updatedMembershipType.getMemberShipFee());
		existingMembershipType.setMembershipPeriod(updatedMembershipType.getMembershipPeriod());
		existingMembershipType.setMembershipAmount(updatedMembershipType.getMembershipAmount());
		return membershipTypeRepository.save(existingMembershipType);
	
	}

	@Override
	public void deleteMembershipType(Integer membershipTypeId) {
		// TODO Auto-generated method stub
		MembershipType existingMembershipType = membershipTypeRepository.findById(membershipTypeId)
				.orElseThrow(() -> new RuntimeException("Membership Type not found with id: " + membershipTypeId));
		membershipTypeRepository.delete(existingMembershipType);
	}

	@Override
	public MembershipType getMembershipTypeById(Integer membershipTypeId) {
		// TODO Auto-generated method stub
		MembershipType membershipType = membershipTypeRepository.findById(membershipTypeId)
				.orElseThrow(() -> new RuntimeException("Membership Type not found with id: " + membershipTypeId));
		return membershipType;
	}

	

		

}
