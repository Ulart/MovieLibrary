package com.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.Rating;
import com.microservices.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@GetMapping()
	public List<Rating> getAllRatings(){
		return ratingService.getAllRatings();
	}
	
	@GetMapping("/{movieId}")
	public List<Rating> getAllRatingsByMovieId(@PathVariable int movieId){
		return ratingService.getAllRatingsByMovieId(movieId);
	}
}
