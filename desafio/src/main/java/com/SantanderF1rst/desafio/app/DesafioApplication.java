package com.SantanderF1rst.desafio.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.SantanderF1rst.desafio.repository")
@ComponentScan(
		basePackages = {"com.SantanderF1rst.desafio"})
@EntityScan(
		basePackages = {"com.SantanderF1rst.desafio.entity"})
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

}
