package com.example.service;

import java.util.List;

import com.example.model.Member;

public interface MemberService {
	
    Member addMember(Member member);
    List<Member> getAllMembers();
    Member getMemberById(Integer memberId);
    Member getmemberByuserId(Integer memberId);
    Member updateMember(Integer memberId, Member updatedMember);
	String deleteMemberyId(Integer memberId);

}