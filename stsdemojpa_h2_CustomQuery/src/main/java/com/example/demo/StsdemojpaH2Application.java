package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example"})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.dao")
public class StsdemojpaH2Application {

	public static void main(String[] args) {
		SpringApplication.run(StsdemojpaH2Application.class, args);
	}

}
