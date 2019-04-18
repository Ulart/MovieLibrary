package com.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.model.MovieRating;
import com.microservices.model.Rating;
import com.microservices.repository.RatingRepository;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	public MovieRating getAllRatings(){
		MovieRating movieRating = new MovieRating( (List<Rating>) ratingRepository.findAll());
		return movieRating;
	}
	
	public MovieRating getAllRatingsByMovieId(long movieId){
		MovieRating movieRating =  new MovieRating(ratingRepository.findAllByMovieId(movieId));
		return movieRating;
	}

}