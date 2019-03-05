package com.microservices.repository;
import org.springframework.data.repository.CrudRepository;

import com.microservices.model.UserProfile;

public interface UserRepository extends CrudRepository<UserProfile, String> {

}
