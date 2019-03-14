package com.microservices.model;


public class UserLibrary {
	
	private int movieId;
	private String name;
	private String description;
	private int rating;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	public UserLibrary(int movieId, String name, String description, int rating) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.description = description;
		this.rating = rating;
	}
	public UserLibrary() {
		super();
	}
}
