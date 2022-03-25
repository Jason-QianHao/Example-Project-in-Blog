package com.jason.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jason.domain.User;
import com.jason.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(User user) {
		String jwt = userService.login(user);
		return jwt;
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
