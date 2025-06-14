package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planId;
    
    private String workOutname;
    private String workoutDate;
    private String workoutTime;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;
    
    




	public String getWorkOutname() {
		return workOutname;
	}

	public void setWorkOutname(String workOutname) {
		this.workOutname = workOutname;
	}

	public int getPlanId() {
		return planId;
	}
	
	public void setPlanId(int planId) {
		this.planId = planId;
	}



	public String getWorkoutDate() {
		return workoutDate;
	}



	public void setWorkoutDate(String workoutDate) {
		this.workoutDate = workoutDate;
	}



	public String getWorkoutTime() {
		return workoutTime;
	}



	public void setWorkoutTime(String workoutTime) {
		this.workoutTime = workoutTime;
	}



	public Member getMember() {
		return member;
	}



	public void setMember(Member member) {
		this.member = member;
	}



	public Instructor getInstructor() {
		return instructor;
	}



	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "WorkoutPlan [planId=" + planId + ", workOutname=" + workOutname + ", workoutDate=" + workoutDate
				+ ", workoutTime=" + workoutTime + ", member=" + member + ", instructor=" + instructor + "]";
	}



		
    
    
}
