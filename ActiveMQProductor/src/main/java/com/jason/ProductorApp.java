package com.jason;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductorApp {

	public static void main(String[] args) {
		SpringApplication.run(ProductorApp.class, args);
	}
}
