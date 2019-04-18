package com.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.UserLibrary;
import com.microservices.services.UserLibraryService;

@RestController
@RequestMapping(value="users", consumes= {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
public class UserLibraryController {

	@Autowired	
	private UserLibraryService userLibraryService;
	
	@GetMapping("/{userName}")
	public List<UserLibrary> getUserLibrary(@PathVariable String userName){
		return userLibraryService.getMoviesRatingsForUser(userName);
	}
	
	@GetMapping("/{userName}/{movieId}")
	public UserLibrary getUserLibraryByMovieId(@PathVariable String userName, @PathVariable long movieId) {
		return userLibraryService.getRatingForUserOfMovie(userName, movieId);
	}
}