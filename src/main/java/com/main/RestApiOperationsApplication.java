package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.main.model","com.main.controller","com.main.services"})
@SpringBootApplication
public class RestApiOperationsApplication {

	public static void main(String[] args) {
		System.out.println("Inside");
		SpringApplication.run(RestApiOperationsApplication.class, args);
	}

}
