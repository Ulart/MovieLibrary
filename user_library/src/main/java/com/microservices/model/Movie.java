package com.microservices.model;

public class Movie {
	
	private int id;
	private String name;
	private String description;
	private int avgRating;
	private long numberOfVotes;
	
	public int getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}
	public long getNumberOfVotes() {
		return numberOfVotes;
	}
	public void setNumberOfVotes(long numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public Movie(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Movie() {
		super();
	}
}
