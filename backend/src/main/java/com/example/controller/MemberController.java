package com.example.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Member;
import com.example.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;
    

    @PostMapping
    public ResponseEntity<Member> addMember(Member member) {
    	Member savedMember = memberService.addMember(member);
		return new ResponseEntity<>(savedMember, HttpStatus.CREATED);   
    }
    ///addmemberbyuser
    @GetMapping("/getall")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
    

    @GetMapping("/{id}")
	public Member getMemberById(@PathVariable Integer id) {
	    return memberService.getMemberById(id);
	}
    @GetMapping("/getByUserId/{userId}")
    public Member getmemberByuserId(@PathVariable Integer userId) {
    	 return memberService.getmemberByuserId(userId);
    }
    
	@PutMapping("/{id}")
	public Member updateMemberById(@PathVariable Integer id, @RequestBody Member member) {
	    return memberService.updateMember(id, member);
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") Integer id) {
		String response = memberService.deleteMemberyId(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
    

  
}

