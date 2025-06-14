package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;   
    private String name;
    private String idNumber; //any ID number   
    private String joiningDate;    
    private String endOfMembershipDate;   
    private int age;   
    private String gender;    
    private String address;   
    private String contact;   
    private String email;    
    private String membershipId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private MembershipType membershipType;

    
    //Getters and setters
	

	public String getName() {
		return name;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEndOfMembershipDate() {
		return endOfMembershipDate;
	}

	public void setEndOfMembershipDate(String endOfMembershipDate) {
		this.endOfMembershipDate = endOfMembershipDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MembershipType getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(MembershipType membershipType) {
		this.membershipType = membershipType;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", idNumber=" + idNumber + ", joiningDate="
				+ joiningDate + ", endOfMembershipDate=" + endOfMembershipDate + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", contact=" + contact + ", email=" + email + ", membershipId="
				+ membershipId + ", user=" + user + ", membershipType=" + membershipType + "]";
	}
    
    
}
