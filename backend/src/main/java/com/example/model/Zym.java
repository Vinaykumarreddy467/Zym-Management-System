package com.example.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Zym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zymId;
    private String zymName;
    private String ZymAddress;

    @OneToMany(mappedBy = "zym")// , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<WorkoutPlan> workoutPlans;

    @OneToMany(mappedBy = "zym")// , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Instructor> instructors	;

    @OneToMany(mappedBy = "zym")// , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Member> member;

    @OneToMany(mappedBy = "zym")// , fetch = FetchType.LAZY)
    @JsonIgnore
   private List<MembershipType> membershipType;

    // Getters and Setters
    public Long getZymId() {
        return zymId;
    }

    public void setZymId(Long zymId) {
        this.zymId = zymId;
    }

    public String getZymName() {
        return zymName;
    }

    public void setZymName(String zymName) {
        this.zymName = zymName;
    }

    public String getZymAddress() {
        return ZymAddress;
    }

    public void setZymAddress(String zymAddress) {
        ZymAddress = zymAddress;
    }

    public List<WorkoutPlan> getWorkoutPlans() {
        return workoutPlans;
    }

    public void setWorkoutPlans(List<WorkoutPlan> workoutPlans) {
        this.workoutPlans = workoutPlans;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

   
    public List<Member> getMember() {
		return member;
	}

	public void setMember(List<Member> member) {
		this.member = member;
	}

	public List<MembershipType> getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(List<MembershipType> membershipType) {
		this.membershipType = membershipType;
	}

	@Override
    public String toString() {
        // Exclude related lists from toString
        return "Zym [zymId=" + zymId + ", zymName=" + zymName + ", ZymAddress=" + ZymAddress + "]";
    }
}