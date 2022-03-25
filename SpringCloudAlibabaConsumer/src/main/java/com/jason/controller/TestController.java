package com.jason.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jason.feign.TestFeign;

@RestController
public class TestController {

	@Autowired
	private TestFeign testFeign;
	
	 @GetMapping("/test")
     public String test() {
         String result = testFeign.hello("didi");
         return "Return : " + result;
     }
}
