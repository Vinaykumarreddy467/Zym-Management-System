package com.example.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;   //
    private String Zymname;    //
    private String GovtidNumber; //any ID number   //
    private String joiningDate;    //
    private String endOfMembershipDate;   //
    private String address;   //
    private String membershipId; //

    @ManyToOne
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User user; //

    @ManyToOne
    @JoinColumn(name = "typeId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private MembershipType membershipType; //

    @ManyToOne // New Many-to-One relationship with Zym
    @JoinColumn(name = "zymId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Zym zym;

    @OneToMany(mappedBy = "member")
    private List<Payment> payments; //

    @OneToMany(mappedBy = "member")
    private List<WorkoutPlan> workoutPlans; //

	public int getMemberId() {
		return memberId; //
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId; //
	}
	
	public String getZymname() {
		return Zymname;
	}

	public void setZymname(String zymname) {
		Zymname = zymname;
	}

	public String getGovtidNumber() {
		return GovtidNumber; //
	}

	public void setGovtidNumber(String govtidNumber) {
		GovtidNumber = govtidNumber; //
	}

	public String getJoiningDate() {
		return joiningDate; //
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate; //
	}

	public String getEndOfMembershipDate() {
		return endOfMembershipDate; //
	}

	public void setEndOfMembershipDate(String endOfMembershipDate) {
		this.endOfMembershipDate = endOfMembershipDate; //
	}

	public String getAddress() {
		return address; //
	}

	public void setAddress(String address) {
		this.address = address; //
	}

	public String getMembershipId() {
		return membershipId; //
	}

	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId; //
	}

	public User getUser() {
		return user; //
	}

	public void setUser(User user) {
		this.user = user; //
	}

	public MembershipType getMembershipType() {
		return membershipType; //
	}

	public void setMembershipType(MembershipType membershipType) {
		this.membershipType = membershipType; //
	}

    public Zym getZym() {
        return zym;
    }

    public void setZym(Zym zym) {
        this.zym = zym;
    }

    public List<Payment> getPayments() {
        return payments; //
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments; //
    }

    public List<WorkoutPlan> getWorkoutPlans() {
        return workoutPlans; //
    }

    public void setWorkoutPlans(List<WorkoutPlan> workoutPlans) {
        this.workoutPlans = workoutPlans; //

    }
    @Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + Zymname + ", GovtidNumber=" + GovtidNumber + ", joiningDate="
				+ joiningDate + ", endOfMembershipDate=" + endOfMembershipDate + ", address=" + address
				+ ", membershipId=" + membershipId + ", user=" + user + ", membershipType=" + membershipType + ", zym=" + zym + "]"; //
	}
}