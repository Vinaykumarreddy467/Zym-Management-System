package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;

    private String GovtIdNumber;
    private String joiningDate;
    private String endOfMembershipDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User user;

    @ManyToOne
    @JoinColumn(name = "typeId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private MembershipType membershipType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zymId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Zym zym;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<WorkoutPlan> workoutPlans;

    // Getters and Setters
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getGovtIdNumber() {
        return GovtIdNumber;
    }

    public void setGovtIdNumber(String govtIdNumber) {
        GovtIdNumber = govtIdNumber;
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

    public Zym getZym() {
        return zym;
    }

    public void setZym(Zym zym) {
        this.zym = zym;
    }

    public List<WorkoutPlan> getWorkoutPlans() {
        return workoutPlans;
    }

    public void setWorkoutPlans(List<WorkoutPlan> workoutPlans) {
        this.workoutPlans = workoutPlans;
    }

    @Override
    public String toString() {
        // Exclude related entities from toString
        return "Member [memberId=" + memberId + ", GovtIdNumber=" + GovtIdNumber + ", joiningDate=" + joiningDate
                + ", endOfMembershipDate=" + endOfMembershipDate + "]";
    }
}