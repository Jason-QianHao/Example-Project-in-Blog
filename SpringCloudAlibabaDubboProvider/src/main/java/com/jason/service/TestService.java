package com.jason.service;

import org.apache.dubbo.config.annotation.Service;

import com.jason.api.DubboApi;

@Service
public class TestService implements DubboApi{

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "hello";
	}

}
