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

import com.microservices.model.Film;
import com.microservices.services.FilmService;

@RestController
@RequestMapping(value="/films", produces= {MediaType.APPLICATION_JSON_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE})
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping
	public List<Film> getAllFilms(){
		return filmService.getAllFilms();
	}

	@GetMapping("/{filmId}")
	public Film getFilmById(@PathVariable int filmId) {
		return filmService.getFilmById(filmId);
	}
	
	@PostMapping
	public Film addFilm(@RequestBody Film film) {
		return filmService.addNewFilm(film);
	}
	
	@DeleteMapping("/{filmId}")
	public void deleteFilm(@PathVariable int filmId) {
		filmService.deleteFilmById(filmId);
		return;
	}
	
	@PutMapping
	public Film updateFilm(@RequestBody Film film) {
		return filmService.updateFilm(film);
	}
}
