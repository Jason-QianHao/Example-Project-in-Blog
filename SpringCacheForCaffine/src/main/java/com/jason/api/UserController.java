package com.jason.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jason.mapper.UserMapping;

@RestController
public class UserController {
	
	@Autowired
	private UserMapping userMapping;

	/**
	 * 查看所有用户
	 * @return
	 */
	@RequestMapping("/user")
	@Cacheable(value = "user_cache", unless = "#result == null")
	public String user() {
		return userMapping.getAll().toString();
	}
}
