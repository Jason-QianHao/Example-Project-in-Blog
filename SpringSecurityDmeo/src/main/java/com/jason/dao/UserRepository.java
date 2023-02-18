package com.jason.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jason.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

	User findById(int id);
}
