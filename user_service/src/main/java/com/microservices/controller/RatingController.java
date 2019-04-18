package com.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.MovieRating;
import com.microservices.service.RatingService;

@RestController
@RequestMapping(value="/ratings", consumes= {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@GetMapping()
	public MovieRating getAllRatings(){
		return ratingService.getAllRatings();
	}
	
	@GetMapping("/{movieId}")
	public MovieRating getAllRatingsByMovieId(@PathVariable long movieId){
		return ratingService.getAllRatingsByMovieId(movieId);
	}
}
