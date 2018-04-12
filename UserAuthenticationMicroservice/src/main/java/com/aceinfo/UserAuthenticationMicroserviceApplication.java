/*
 * Application for User Authentication
 * */ 	
package com.aceinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserAuthenticationMicroserviceApplication {
    

	// Define the logger object for this class
	private final Logger log = LoggerFactory.getLogger(this.getClass());
			
	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationMicroserviceApplication.class, args);
	}
}
