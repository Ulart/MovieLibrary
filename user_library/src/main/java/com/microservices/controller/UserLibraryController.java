package com.microservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.model.Movie;
import com.microservices.model.MovieRating;
import com.microservices.model.Rating;
import com.microservices.model.UserLibrary;

@RestController
@RequestMapping(value="users", consumes= {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
public class UserLibraryController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userName}")
	public MovieRating getUserLibrary(@PathVariable String userName){
		MovieRating movieRating = restTemplate.getForObject("http://user-service/users/"+userName+"/ratings", MovieRating.class);
		List<UserLibrary> userLibrary = new ArrayList<UserLibrary>();
		movieRating.getMovieRatings().stream().forEach(
				rating->{Movie movie = restTemplate.getForObject("http://movie-service/movies/"+rating.getMovieId(), Movie.class);
			userLibrary.add(new UserLibrary(movie, rating.getRating()));});
		return movieRating;
	}
	
	@GetMapping("/{userName}/{movieId}")
	public UserLibrary getUserLibraryByMovieId(@PathVariable String userName, @PathVariable long movieId) {
		Rating rating = restTemplate.getForObject("http://user-service/users/"+userName+"/ratings"+movieId, Rating.class);
		Movie movie = restTemplate.getForObject("http://movie-service/movies/"+rating.getMovieId(), Movie.class);
		return new UserLibrary(movie, rating.getRating());
	}
}