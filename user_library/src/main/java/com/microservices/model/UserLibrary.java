package com.microservices.model;


public class UserLibrary {
	
	private long movieId;
	private String name;
	private String description;
	private int rating;
	private double avgRating;
	private long numberOfVotes;
	
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public long getNumberOfVotes() {
		return numberOfVotes;
	}
	public void setNumberOfVotes(long numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
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
	
	
	public UserLibrary(Movie movie, int rating) {
		this.movieId=movie.getId();
		this.name=movie.getName();
		this.description=movie.getDescription();
		this.avgRating=movie.getAvgRating();
		this.numberOfVotes=movie.getNumberOfVotes();
		this.rating=rating;
	}
	public UserLibrary(long movieId, String name, String description, int rating, double avgRating, long numberOfVotes) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.avgRating = avgRating;
		this.numberOfVotes = numberOfVotes;
	}
	public UserLibrary() {
		super();
	}
}
