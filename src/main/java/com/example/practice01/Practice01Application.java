package com.example.practice01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Practice01Application {

    	public static void main(String[] args) {
		SpringApplication.run(Practice01Application.class, args);
	}
}
