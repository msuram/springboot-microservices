package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	// Define the logger object for this class
	private final Logger log = LoggerFactory.getLogger(this.getClass());
		
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
