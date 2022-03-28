package com.jason.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jason.api.DubboApi;

@RestController
public class TestController {

	@Reference // 注意：这里的@Reference注解是org.apache.dubbo.config.annotation.Reference
	private DubboApi dubboApi;
	
	@RequestMapping("/hello")
	public String hello() {
		return dubboApi.hello();
	}
}
