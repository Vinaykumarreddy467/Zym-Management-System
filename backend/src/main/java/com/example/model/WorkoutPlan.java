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
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    private String workOutname;
    private String workoutDate;
    private String workoutTime;

    @ManyToOne()//fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Member member;

    @ManyToOne()//fetch = FetchType.LAZY)
    @JoinColumn(name = "instructorId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Instructor instructor;

    @ManyToOne()//fetch = FetchType.LAZY)
    @JoinColumn(name = "zymId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Zym zym;

    @OneToMany(mappedBy = "workoutPlan", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Workout> workouts;

    // Getters and Setters
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getWorkOutname() {
        return workOutname;
    }

    public void setWorkOutname(String workOutname) {
        this.workOutname = workOutname;
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

    public Zym getZym() {
        return zym;
    }

    public void setZym(Zym zym) {
        this.zym = zym;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    @Override
    public String toString() {
        // Exclude related entities from toString
        return "WorkoutPlan [planId=" + planId + ", workOutname=" + workOutname + ", workoutDate=" + workoutDate
                + ", workoutTime=" + workoutTime + "]";
    }
}