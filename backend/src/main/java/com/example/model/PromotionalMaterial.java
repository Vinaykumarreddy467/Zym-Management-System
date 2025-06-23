package com.example.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PromotionalMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promotionId;

    private String review;
    private String fileUpload;

    @ManyToOne
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User user;


    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    

    public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(String fileUpload) {
        this.fileUpload = fileUpload;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PromotionalMaterial [promotionId=" + promotionId + ", review=" + review + ", fileUpload=" + fileUpload
                + ", user=" + user + "]";
    }
}