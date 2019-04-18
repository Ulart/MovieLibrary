package com.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.model.Movie;
import com.microservices.model.MovieRating;
import com.microservices.model.Rating;
import com.microservices.services.MovieService;

@RestController
@RequestMapping(value="/movies", produces= {MediaType.APPLICATION_JSON_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE})
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}

	@GetMapping("/{movieId}")
	public Movie getMovieById(@PathVariable long movieId) {
		Movie movie = movieService.getMovieById(movieId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<MovieRating> entity = new HttpEntity<MovieRating>(headers);

		ResponseEntity<MovieRating> response = restTemplate.exchange("http://user-service/ratings/" + movieId, HttpMethod.GET, entity, MovieRating.class);
		
		List<Rating> ratings = response.getBody().getMovieRatings();
		long votes = ratings.size();
		System.out.println(votes);
		if(votes==0)
			movie.setAvgRating(0);
		else
			movie.setAvgRating(ratings.stream().mapToInt(rating->rating.getRating()).sum()/votes);
		movie.setNumberOfVotes(votes);
		return movie;
	}
	
	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addNewMovie(movie);
	}
	
	@DeleteMapping("/{movieId}")
	public void deleteMovie(@PathVariable long movieId) {
		movieService.deleteMovieById(movieId);
		return;
	}
	
	@PutMapping
	public Movie updateMovie(@RequestBody Movie movie) {
		return movieService.updateMovie(movie);
	}
}
