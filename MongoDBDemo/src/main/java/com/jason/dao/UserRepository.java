package com.jason.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jason.domain.User;

public interface UserRepository extends MongoRepository<User, Long>{

}
