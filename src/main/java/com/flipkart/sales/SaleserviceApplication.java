package com.flipkart.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.flipkart.sales")
public class SaleserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleserviceApplication.class, args);
	}

}
