package com.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.model.Movie;
import com.microservices.model.MovieRating;
import com.microservices.model.Rating;
import com.microservices.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public List<Movie> getAllMovies() {
		List<Movie> movies = (List<Movie>) movieRepository.findAll();
		movies.stream().forEach(movie->getScoreOfMovie(movie));
		return movies;
	}

	public Movie getMovieById(long id) {
		Movie movie =  movieRepository.findById(id).orElse(null);
		getScoreOfMovie(movie);
		return movie;
	}
	
	private Movie getScoreOfMovie(Movie movie) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<MovieRating> entity = new HttpEntity<MovieRating>(headers);

		ResponseEntity<MovieRating> response = restTemplate.exchange("http://user-service/ratings/" + movie.getId(), HttpMethod.GET, entity, MovieRating.class);
		
		List<Rating> ratings = response.getBody().getMovieRatings();
		long votes = ratings.size();
		
		if(votes==0)
			movie.setAvgRating(0);
		else
			movie.setAvgRating(ratings.stream().mapToInt(rating->rating.getRating()).sum()/votes);
		movie.setNumberOfVotes(votes);
		return movie;
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
