package com.gof.springpaterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring Initializr
 * Os seguintes módulos foram selecionados:
 * Spring Web
 * Spring Data JPA
 * H2 Database
 * OpenFeign
 * */
@EnableFeignClients
@SpringBootApplication
public class SpringPaternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPaternsApplication.class, args);
	}

}
