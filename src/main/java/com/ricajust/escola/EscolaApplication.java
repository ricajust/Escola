package com.ricajust.escola;

import com.ricajust.escola.entities.Turma;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EscolaApplication {

	public static final Logger log = LoggerFactory.getLogger(EscolaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (arg) -> {

		};
	}
}
