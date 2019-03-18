package com.microservices.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservices.model.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, String>{
	
	public List<Rating> findAllByMovieId(int movieId);
}
