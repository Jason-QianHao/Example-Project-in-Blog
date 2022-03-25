package com.jason.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class controller {

	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		log.info("invoked name = " + name);
		return "hello " + name;
	}
}