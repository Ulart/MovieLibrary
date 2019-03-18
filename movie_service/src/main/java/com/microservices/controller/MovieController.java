package com.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.Movie;
import com.microservices.services.MovieService;

@RestController
@RequestMapping(value="/movies", produces= {MediaType.APPLICATION_JSON_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE})
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}

	@GetMapping("/{movieId}")
	public Movie getMovieById(@PathVariable int movieId) {
		return movieService.getMovieById(movieId);
	}
	
	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addNewMovie(movie);
	}
	
	@DeleteMapping("/{movieId}")
	public void deleteMovie(@PathVariable int movieId) {
		movieService.deleteMovieById(movieId);
		return;
	}
	
	@PutMapping
	public Movie updateMovie(@RequestBody Movie movie) {
		return movieService.updateMovie(movie);
	}
}
