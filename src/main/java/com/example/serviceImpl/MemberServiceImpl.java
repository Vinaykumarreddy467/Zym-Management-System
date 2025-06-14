package com.example.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFoundException;
import com.example.model.Member;
import com.example.repository.MemberRepository;
import com.example.service.MemberService;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

	@Override
	public Member addMember(Member member) {
		// TODO Auto-generated method stub
		System.out.println("Saving member: " + member);
		return memberRepository.save(member);
	}

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return memberRepository.findAll();
	}

	@Override
	public Member getMemberById(Integer memberId) {
		// TODO Auto-generated method stub
		Member member = memberRepository.findById(memberId)
			    .orElseThrow(() -> new ResourceNotFoundException("Member", "id", memberId));
		System.out.println("Retrieved member: " + member);	
		return member;
	}

	@Override
	public Member updateMember(Integer memberId, Member updatedMember) {
	    Optional<Member> existingMemberOptional = memberRepository.findById(memberId);
	    
	    if (existingMemberOptional.isPresent()) {
	        Member existingMember = existingMemberOptional.get();
	        // Update the fields of the existing member with the values from the updated member
	        existingMember.setName(updatedMember.getName());
	        existingMember.setIdNumber(updatedMember.getIdNumber());
	        existingMember.setJoiningDate(updatedMember.getJoiningDate());
	        existingMember.setEndOfMembershipDate(updatedMember.getEndOfMembershipDate());
	        existingMember.setAge(updatedMember.getAge());
	        existingMember.setGender(updatedMember.getGender());
	        existingMember.setAddress(updatedMember.getAddress());
	        existingMember.setContact(updatedMember.getContact());
	        existingMember.setEmail(updatedMember.getEmail());
	        existingMember.setMembershipId(updatedMember.getMembershipId());
	        existingMember.setUser(updatedMember.getUser());
	        existingMember.setMembershipType(updatedMember.getMembershipType());
	        
	        return memberRepository.save(existingMember);
	    } else {
	        throw new RuntimeException("Member not found with id: " + memberId);
	    }
	}


	@Override
	public String deleteMemberyId(Integer memberId) {
		memberRepository.deleteById(memberId);
		return "Member deleted successfully with id: " + memberId;
		
	}    
}
