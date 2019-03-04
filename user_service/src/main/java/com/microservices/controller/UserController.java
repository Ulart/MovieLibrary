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

import com.microservices.model.UserProfile;
import com.microservices.service.UserService;

@RestController
@RequestMapping(value="users", consumes= {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping()
	public List<UserProfile> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public UserProfile getUserById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
	@PostMapping()
	public void addUser(@RequestBody UserProfile newUser) {
		userService.addUser(newUser);
		return;
	}
	
	@PutMapping()
	public void updateUser(@RequestBody UserProfile newUser) {
		userService.addUser(newUser);
		return;
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUserById(@PathVariable int userId) {
		userService.deleteUserById(userId);
		return;
	}
}
