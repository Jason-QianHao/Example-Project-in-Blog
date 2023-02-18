package com.jason.api;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Comsumer {

	@RabbitListener(queues = "queue")
    @RabbitHandler
    public void handle(String msg){
        log.info("recive orderId:{}", msg);
    }
}
