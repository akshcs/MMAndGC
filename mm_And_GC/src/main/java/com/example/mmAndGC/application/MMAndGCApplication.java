package com.example.mmAndGC.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.mmAndGC.config", "com.example.mmAndGC.rest"})
public class MMAndGCApplication {
	public static void main(String[] args) {
		SpringApplication.run(MMAndGCApplication.class, args);
	}
}
