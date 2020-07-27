package com.rlgino.calculadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.rlgino.calculadora")
public class MondaCalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MondaCalcApplication.class, args);
	}

}
