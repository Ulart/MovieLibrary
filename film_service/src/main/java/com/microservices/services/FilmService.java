package com.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.model.Film;
import com.microservices.repository.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;

	public List<Film> getAllFilms() {
		return (List<Film>) filmRepository.findAll();
	}

	public Film getFilmById(int id) {
		return filmRepository.findById(id).orElse(null);
	}

	public Film addNewFilm(Film newFilm) {
		return filmRepository.save(newFilm);
	}

	public Film updateFilm(Film film) {
		return filmRepository.save(film);
	}

	public void deleteFilmById(int filmId) {
		filmRepository.deleteById(filmId);
		return;
	}

}
