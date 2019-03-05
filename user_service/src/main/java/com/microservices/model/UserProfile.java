package com.microservices.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserDetails")
public class UserProfile {

	@Id
	private String userName;
	
	private String password;
	@Column(name="registration")
	private Date dateOfRegistration;
	@ElementCollection(targetClass=Rating.class)
	private List<Rating> ratings;
	
	
	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String UserName) {
		this.userName = UserName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public UserProfile(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.ratings = new ArrayList<Rating>();
		this.dateOfRegistration = new Date();
	}
	
	public UserProfile() {
		super();
		this.ratings = new ArrayList<Rating>();
		this.dateOfRegistration = new Date();
	}
}
