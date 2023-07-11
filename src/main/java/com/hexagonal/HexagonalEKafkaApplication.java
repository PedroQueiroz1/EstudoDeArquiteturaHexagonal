package com.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HexagonalEKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalEKafkaApplication.class, args);
	}

}
