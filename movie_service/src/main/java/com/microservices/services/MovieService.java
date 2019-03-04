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

	public Movie getMovieById(int id) {
		return movieRepository.findById(id).orElse(null);
	}

	public Movie addNewMovie(Movie newFilm) {
		return movieRepository.save(newFilm);
	}

	public Movie updateMovie(Movie film) {
		return movieRepository.save(film);
	}

	public void deleteMovieById(int filmId) {
		movieRepository.deleteById(filmId);
		return;
	}

}
