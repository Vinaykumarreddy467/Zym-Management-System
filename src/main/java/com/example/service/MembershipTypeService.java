package com.example.service;

import java.util.List;

import com.example.model.MembershipType;

public interface MembershipTypeService {
	
	MembershipType addMembershipType(MembershipType membershipType);
	List<MembershipType> getAllMembershipTypes();	
	MembershipType getMembershipTypeById(Integer membershipTypeId);
	MembershipType updateMembershipType(Integer membershipTypeId, MembershipType updatedMembershipType);	
	void deleteMembershipType(Integer membershipTypeId);

}
