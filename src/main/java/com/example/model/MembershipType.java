package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MembershipType {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int typeId;

    private String name;
    private Double memberShipFee;
    private String membershipPeriod;
    private Double membershipAmount;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

	

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMemberShipFee() {
		return memberShipFee;
	}

	public void setMemberShipFee(Double memberShipFee) {
		this.memberShipFee = memberShipFee;
	}

	public String getMembershipPeriod() {
		return membershipPeriod;
	}

	public void setMembershipPeriod(String membershipPeriod) {
		this.membershipPeriod = membershipPeriod;
	}

	public Double getMembershipAmount() {
		return membershipAmount;
	}

	public void setMembershipAmount(Double membershipAmount) {
		this.membershipAmount = membershipAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "MembershipType [typeId=" + typeId + ", name=" + name + ", memberShipFee=" + memberShipFee
				+ ", membershipPeriod=" + membershipPeriod + ", membershipAmount=" + membershipAmount + ", user=" + user
				+ "]";
	}
    
    
}
