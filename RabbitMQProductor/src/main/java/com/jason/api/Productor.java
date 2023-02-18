package com.jason.api;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jason.config.QueueEnum;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Productor {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Scheduled(fixedDelay = 5000)
    public void sendMessage(){
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE.getExchange(), QueueEnum.QUEUE.getRouteKey(), System.currentTimeMillis());
//        log.info("send msg:{}",System.currentTimeMillis());
    }
}
