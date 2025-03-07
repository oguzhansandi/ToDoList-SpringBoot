package com.oguzhansandi.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.oguzhansandi"})
@ComponentScan(basePackages = {"com.oguzhansandi"})
@EnableJpaRepositories(basePackages = {"com.oguzhansandi"})
@SpringBootApplication
public class TodolistApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplicationStarter.class, args);
	}

}
