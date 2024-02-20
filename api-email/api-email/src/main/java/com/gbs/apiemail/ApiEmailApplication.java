package com.gbs.apiemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableFeignClients
@SpringBootApplication
public class ApiEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEmailApplication.class, args);
	}

}
