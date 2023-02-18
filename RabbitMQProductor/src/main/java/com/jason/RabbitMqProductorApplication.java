package com.jason;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMqProductorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqProductorApplication.class, args);
	}

}
