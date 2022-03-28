package com.jason.service;


import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.jason.api.DubboApi;

@Service
@Component
public class TestService implements DubboApi{

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "hello";
	}

	
}
