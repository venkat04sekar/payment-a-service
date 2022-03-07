package com.payment.module.payment.a.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentAServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentAServiceApplication.class, args);
	}

}
