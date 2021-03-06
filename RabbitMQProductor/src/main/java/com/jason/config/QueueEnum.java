package com.jason.config;

import lombok.Getter;

@Getter
public enum QueueEnum {

	 /**
     * 消息通知队列
     */
    QUEUE("direct", "queue", "queue");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
