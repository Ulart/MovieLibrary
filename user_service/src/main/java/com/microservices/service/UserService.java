package com.microservices.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.model.UserProfile;
import com.microservices.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<UserProfile> getAllUsers(){
		return (List<UserProfile>) userRepository.findAll();
	}
	
	public UserProfile getUserById(int userId) {
		return userRepository.findById(userId).orElse(null);
	}
	
	public void addUser(UserProfile newUser) {
		userRepository.save(newUser);
		return;
	}
	
	public void deleteUserById(int userId) {
		userRepository.deleteById(userId);
		return;
	}
	
	public void updateUser(UserProfile user) {
		userRepository.save(user);
		return;
	}
}
