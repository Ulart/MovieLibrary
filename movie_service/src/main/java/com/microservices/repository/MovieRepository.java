package com.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservices.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
