package com.cisco.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class PhoneApplication {

	private static final Logger LOGGER= LoggerFactory.getLogger(PhoneApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PhoneApplication.class, args);
		LOGGER.info("Starting the application");
	}

}
