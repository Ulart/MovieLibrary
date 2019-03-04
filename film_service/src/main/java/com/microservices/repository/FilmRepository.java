package com.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservices.model.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {

}
