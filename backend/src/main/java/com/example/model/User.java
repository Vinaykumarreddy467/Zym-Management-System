package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.OnDelete; // Keeping OnDelete for database cascade behavior
import org.hibernate.annotations.OnDeleteAction; // Keeping OnDeleteAction

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
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

    @ManyToOne()//fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "typeId")
    @OnDelete(action = OnDeleteAction.SET_NULL) 
    private MembershipType membershipType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Member> member;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Instructor> instructor;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Payment> payment;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PromotionalMaterial> promotionalMaterial;

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    
    public List<Member> getMember() {
		return member;
	}

	public void setMember(List<Member> member) {
		this.member = member;
	}

	public List<Instructor> getInstructor() {
		return instructor;
	}

	public void setInstructor(List<Instructor> instructor) {
		this.instructor = instructor;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public List<PromotionalMaterial> getPromotionalMaterial() {
		return promotionalMaterial;
	}

	public void setPromotionalMaterial(List<PromotionalMaterial> promotionalMaterial) {
		this.promotionalMaterial = promotionalMaterial;
	}

	@Override
    public String toString() {
        // Exclude related lists from toString to prevent potential StackOverflowError
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", completeName="
                + completeName + ", role=" + role + ", contact=" + contact + ", address=" + address + ", email="
                + email + "]";
    }
}