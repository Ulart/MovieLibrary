package com.microservices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.model.Movie;
import com.microservices.model.MovieRating;
import com.microservices.model.Rating;
import com.microservices.model.UserLibrary;

@Service
public class UserLibraryService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HttpHeaders headers;

	public List<UserLibrary> getMoviesRatingsForUser(String userName) {
		HttpEntity<MovieRating> entity = new HttpEntity<MovieRating>(headers);

		ResponseEntity<MovieRating> response = restTemplate.exchange("http://user-service/users/" + userName + "/ratings", HttpMethod.GET, entity, MovieRating.class);
		MovieRating moviesRating = response.getBody();
		
		List<UserLibrary> userLibrary = new ArrayList<UserLibrary>();
		moviesRating.getMovieRatings().stream().forEach(
				rating->{userLibrary.add(new UserLibrary(callForMovie(rating.getMovieId()), rating.getRating()));});
		return userLibrary;
	}

	public UserLibrary getRatingForUserOfMovie(String userName, long movieId) {
		HttpEntity<Rating> entity = new HttpEntity<Rating>(headers);
		ResponseEntity<Rating> response = restTemplate.exchange("http://user-service/users/"+userName+"/ratings/"+movieId, HttpMethod.GET, entity, Rating.class);
		Rating rating = response.getBody();
		
		Movie movie = callForMovie(movieId);
		return new UserLibrary(movie, rating.getRating());
	}

	private Movie callForMovie(long movieId) {
		HttpEntity<Movie> entity = new HttpEntity<Movie>(headers);

		ResponseEntity<Movie> response = restTemplate.exchange("http://movie-service/movies/" + movieId, HttpMethod.GET, entity, Movie.class);
		return response.getBody();
	}
}
