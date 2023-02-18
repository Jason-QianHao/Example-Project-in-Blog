package com.jason.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jason.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	void deleteByUsername(String username);
	
	User findByUsername(String username);
}
