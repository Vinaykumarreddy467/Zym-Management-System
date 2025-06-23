package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Zym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zymId;

    private String zymName;
    private String ZymAddress;
    
    @OneToMany(mappedBy = "zym")
    private List<WorkoutPlan> workoutPlans;

    @OneToMany(mappedBy = "zym")
    private List<Instructor> instructors;

    public int getZymId() {
        return zymId;
    }

    public void setZymId(int zymId) {
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

    @Override
    public String toString() {
        return "Zym [zymId=" + zymId + ", zymName=" + zymName + "]";
    }
}