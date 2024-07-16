package com.springwithtesting.productapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductapplicationApplication {

	private static Logger logger = LoggerFactory.getLogger(ProductapplicationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductapplicationApplication.class, args);
		runapplication();
	}

	public static void runapplication() {
		logger.info("Product application is running");
	}
}
