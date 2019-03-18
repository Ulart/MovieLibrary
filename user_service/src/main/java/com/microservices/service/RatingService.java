package com.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.model.Rating;
import com.microservices.repository.RatingRepository;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	public List<Rating> getAllRatings(){
		return (List<Rating>) ratingRepository.findAll();
	}
	
	public List<Rating> getAllRatingsByMovieId(int movieId){
		return ratingRepository.findAllByMovieId(movieId);
	}

}
