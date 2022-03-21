package com.jason.api;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Productor {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
	private Queue logQueue;

	@Scheduled(fixedDelay = 5000)
	public void send() {
		jmsMessagingTemplate.convertAndSend(logQueue, "测试消息队列" + System.currentTimeMillis());
	}
}
