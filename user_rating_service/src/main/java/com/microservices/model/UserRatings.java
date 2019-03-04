package com.microservices.model;

import java.util.List;

public class UserRatings {

	int userId;
	List<Rating> ratings;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	public UserRatings(int userId, List<Rating> ratings) {
		super();
		this.userId = userId;
		this.ratings = ratings;
	}
	public UserRatings() {
		super();
	}
	
}
