package com.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.model.Movie;
import com.microservices.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> getAllMovies() {
		return (List<Movie>) movieRepository.findAll();
	}

	public Movie getMovieById(long id) {
		return movieRepository.findById(id).orElse(null);
	}

	public Movie addNewMovie(Movie newMovie) {
		return movieRepository.save(newMovie);
	}

	public Movie updateMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public void deleteMovieById(long movieId) {
		movieRepository.deleteById(movieId);
		return;
	}

}
