package com.example.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class MembershipType {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int typeId;

    private String memberShipname;
    private Double memberShipFee;
    private String membershipPeriod;

    @ManyToOne
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User user;

    @OneToMany(mappedBy = "membershipType")
    private List<Member> members;


    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    

    public String getMemberShipname() {
		return memberShipname;
	}

	public void setMemberShipname(String memberShipname) {
		this.memberShipname = memberShipname;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

	@Override
	public String toString() {
		return "MembershipType [typeId=" + typeId + ", memberShipname=" + memberShipname + ", memberShipFee="
				+ memberShipFee + ", membershipPeriod=" + membershipPeriod + ", user=" + user + ", members=" + members
				+ "]";
	}

    
}