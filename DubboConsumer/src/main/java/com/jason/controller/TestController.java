package com.jason.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jason.api.DubboApi;

@RestController
public class TestController{

	@Reference(check=false)
	private DubboApi dubboApi;
	
	@RequestMapping("/hello")
	public String hello() {
		return dubboApi.hello();
	}
}
