package com.example.model;	

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MembershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;

    private String memberShipname;
    private Double memberShipFee;
    private String membershipPeriod;

    @OneToMany(mappedBy = "membershipType") 
    @JsonIgnore
    private List<Member> members;

    @ManyToOne
    @JoinColumn(name = "zymId")
    private Zym zym;

    
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Zym getZym() {
        return zym;
    }

    public void setZym(Zym zym) {
        this.zym = zym;
    }

    @Override
    public String toString() {
        // Exclude related lists from toString
        return "MembershipType [typeId=" + typeId + ", memberShipname=" + memberShipname + ", memberShipFee="
                + memberShipFee + ", membershipPeriod=" + membershipPeriod + "]";
    }
}