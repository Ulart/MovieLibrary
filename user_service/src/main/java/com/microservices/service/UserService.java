package com.microservices.service;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void addRating(String userName, Rating rating) {
		UserProfile user = userRepository.findById(userName).orElse(null);
		user.getRatings().add(rating);
		userRepository.save(user);
		return;
	}

	public Set<Rating> getAllRatingsForUser(String userName) {
		return null;// userRepository.findByUserName(userName);
	}
}
