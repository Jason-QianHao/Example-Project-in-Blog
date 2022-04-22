package com.jason.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TestController", description = "测试SpringDoc")
@RestController
@RequestMapping("/test")
public class TestController {

	@Operation(summary = "test1", description = "进行SpringDoc的test1")
	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}
	
	@Operation(summary = "test2", description = "进行SpringDoc的test2")
	@GetMapping("/test2")
	public String test2(@Parameter(description = "test2的参数") String param) {
		return "test2 ---" + param;
	}
}
