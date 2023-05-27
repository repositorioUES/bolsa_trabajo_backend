package com.bad115.SistemaBolsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BolsaTrabajoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BolsaTrabajoBackendApplication.class, args);
	}

	@GetMapping("/")
	public String apiConfirmacion(){
		return "La api esta corriendo ";
	}
}
