package com.bad115.SistemaBolsa;

import com.bad115.SistemaBolsa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
