package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
	
@Entity
public class User {
		
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId; 
    private String username; 
    private String password; 
    private String completeName; 
    private String role; 
    private String contact; 
    private String address; 
    private String email; 
		  
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MembershipType> memberTypeList; 

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Member> memberList; 

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Instructor> instructorList; 

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Payment> paymentList; 

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PromotionalMaterial> promotionalMaterialList; 
	 
	
    public List<MembershipType> getMemberTypeList() {
        return memberTypeList; 
    }
    public void setMemberTypeList(List<MembershipType> memberTypeList) {
        this.memberTypeList = memberTypeList; 
    }
    public void setUserId(Integer userId) {
        this.userId = userId; 
    }
    public String getEmail() {
        return email; 
    }
    public void setEmail(String email) {
        this.email = email; 
    }
    public String getRole() {
        return role; 
    }
    public void setRole(String role) {
        this.role = role; 
    }
	 
    public int getUserId() {
        return userId; 
    }
    public void setUserId(int userId) {
        this.userId = userId; 
    }
    public String getUsername() {
        return username; 
    }
    public void setUsername(String username) {
        this.username = username; 
    }
    public String getPassword() {
        return password; 
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCompleteName() {
        return completeName; 
    }
    public void setCompleteName(String completeName) {
        this.completeName = completeName; 
    }
    public String getContact() {
        return contact; 
    }
    public void setContact(String contact) {
        this.contact = contact; 
    }
    public String getAddress() {
        return address; 
    }
    public void setAddress(String address) {
        this.address = address; 
    }
    
    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<PromotionalMaterial> getPromotionalMaterialList() {
        return promotionalMaterialList;
    }

    public void setPromotionalMaterialList(List<PromotionalMaterial> promotionalMaterialList) {
        this.promotionalMaterialList = promotionalMaterialList;
    }
    
    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", completeName="
                + completeName + ", role=" + role + ", contact=" + contact + ", address=" + address + ", email="
                + email + "]"; //
    }
}