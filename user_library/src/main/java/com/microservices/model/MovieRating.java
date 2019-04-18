package com.microservices.model;

import java.util.List;

public class MovieRating {

	private List<Rating> rating;

	public List<Rating> getMovieRatings() {
		return rating;
	}

	public void setMovieRatings(List<Rating> rating) {
		this.rating = rating;
	}

	public MovieRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
