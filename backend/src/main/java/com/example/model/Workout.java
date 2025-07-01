package com.example.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workoutId;

    private String workoutName;
    private String description;

    @ManyToOne()//fetch = FetchType.LAZY)
    @JoinColumn(name = "workoutPlanId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private WorkoutPlan workoutPlan;

    // Getters and Setters
    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    @Override
    public String toString() {
        // Exclude 'workoutPlan' from toString
        return "Workout [workoutId=" + workoutId + ", workoutName=" + workoutName + ", description=" + description + "]";
    }
}