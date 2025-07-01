package com.example.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;	
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
	private static final Logger logger = LogManager.getLogger(MemberServiceImpl.class);
	
    @Autowired
    private MemberRepository memberRepository;

	@Override
	public Member addMember(Member member) {
		// TODO Auto-generated method stub
		Member member1 = memberRepository.save(member);
		logger.info("Adding new member: {}", member1);
		return member1;
	}

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		List<Member> memberList = memberRepository.findAll();
		logger.info("Fetching all members");
		return memberList;
	}

	@Override
	public Member getMemberById(Integer memberId) {
		// TODO Auto-generated method stub
		Member member = memberRepository.findById(memberId)
			    .orElseThrow(() -> new ResourceNotFoundException("Member", "id", memberId));
		System.out.println("Retrieved member: " + member);	
		logger.info("Fetching member with id: {}", memberId);
		return member;
	}

	@Override
	public Member updateMember(Integer memberId, Member updatedMember) {
	    Optional<Member> existingMemberOptional = memberRepository.findById(memberId);
	    
	    if (existingMemberOptional.isPresent()) {
	       Member  existingMember = memberRepository.findById(memberId)
	        		 .orElseThrow(() -> new ResourceNotFoundException("Member", "id", memberId));
	       
	       existingMember.setGovtIdNumber(updatedMember.getGovtIdNumber());
	       existingMember.setJoiningDate(updatedMember.getJoiningDate());
	       existingMember.setEndOfMembershipDate(updatedMember.getEndOfMembershipDate());
	       
	       logger.info("Updating member with id: {}", memberId);
	       return memberRepository.save(existingMember);
	    }
		return updatedMember; 
		
	        
	}


	@Override
	public String deleteMemberyId(Integer memberId) {
		memberRepository.deleteById(memberId);
		
		logger.info("Deleted member with id: {}", memberId);
		return   "Member deleted Successfullly by memberid" +memberId;
		
	}

	@Override
	public Member getmemberByuserId(Integer userId) {
		// TODO Auto-generated method stub
		
		Member member = memberRepository.findByUserUserId(userId);
				
		logger.info("Fetching member by user id: {}", userId);
		return member;
	}

	   
}
