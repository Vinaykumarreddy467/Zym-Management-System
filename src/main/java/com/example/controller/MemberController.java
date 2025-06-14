package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Member;
import com.example.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "http://localhost:4200")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> addMember(Member member) {
    	Member savedMember = memberService.addMember(member);
		return new ResponseEntity<>(savedMember, HttpStatus.CREATED);   
    }

    @GetMapping("/getall")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
	public Member getMemberById(@PathVariable Integer id) {
	    return memberService.getMemberById(id);
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

