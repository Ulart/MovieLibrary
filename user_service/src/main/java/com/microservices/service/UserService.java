package com.microservices.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.model.MovieRating;
import com.microservices.model.Rating;
import com.microservices.model.UserProfile;
import com.microservices.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<UserProfile> getAllUsers(){
		return (List<UserProfile>) userRepository.findAll();
	}
	
	public UserProfile getUserById(String userName) {
		return userRepository.findById(userName).orElse(null);
	}
	
	public void addUser(UserProfile newUser) {
		userRepository.save(newUser);
		return;
	}
	
	public void deleteUserById(String userName) {
		userRepository.deleteById(userName);
		return;
	}
	
	public void updateUser(UserProfile user) {
		userRepository.save(user);
		return;
	}
	
	public void addOrUpdateRating(String userName, Rating rating) {
		int numberOfRating = -1;
		UserProfile user = userRepository.findById(userName).orElse(null);
		long movieId = rating.getMovieId();
		List<Rating> ratings = user.getRatings();
		for(int i=0; i<ratings.size(); i++) {
			if(ratings.get(i).getMovieId()==movieId) {
				numberOfRating = i;
				break;
			}
		}
		if(numberOfRating==-1)
			ratings.add(rating);
		else
			ratings.set(numberOfRating, rating);
		userRepository.save(user);
		return;
	}

	public MovieRating getAllRatingsForUser(String userName) {
		return new MovieRating(userRepository.findById(userName).orElse(null).getRatings());
	}

	public void deleteRatingByMovieId(String userName, int movieId) {
		UserProfile user = userRepository.findById(userName).orElse(null);
		List<Rating> ratings = user.getRatings();
		for(int i=0; i<ratings.size(); i++) {
			if(ratings.get(i).getMovieId()==movieId) {
				ratings.remove(i);
				userRepository.save(user);
				return;
			}
		}
		return;
	}

	public Rating getRatingForUserAndMovie(String userName, long movieId) {
		UserProfile user = userRepository.findById(userName).orElse(null);
		List<Rating> ratings = user.getRatings();
		for(int i=0; i<ratings.size(); i++) {
			if(ratings.get(i).getMovieId()==movieId) {
				return ratings.get(i);
			}
		}
		return new Rating(movieId, 0);
	}
}
