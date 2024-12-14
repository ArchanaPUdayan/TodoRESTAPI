package com.example.SimpleRestApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SimpleRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestApplication.class, args);
	}

}
