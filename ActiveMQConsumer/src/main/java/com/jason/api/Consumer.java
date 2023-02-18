package com.jason.api;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination = "${queue}")
	public void receive(String msg) {
		System.out.println("监听器收到msg:" + msg);
	}
}
