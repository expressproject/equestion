package com.mkyong.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mkyong.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
