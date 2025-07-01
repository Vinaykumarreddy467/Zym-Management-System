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
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer instructorId;

    private String name;
    private String email;
    private String contact;
    private String address;

    @ManyToOne
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User user;

    @ManyToOne
    @JoinColumn(name = "zymId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Zym zym;

    @OneToMany(mappedBy = "instructor")
    @JsonIgnore
    private List<WorkoutPlan> workoutPlans;

    // Getters and Setters
    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Instructor [instructorId=" + instructorId + ", name=" + name + ", email=" + email + ", contact="
                + contact + ", address=" + address + "]";
    }
}