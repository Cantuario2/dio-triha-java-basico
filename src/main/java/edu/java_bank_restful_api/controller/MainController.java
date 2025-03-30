package edu.java_bank_restful_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/")
	private ResponseEntity<String> home() {
		return ResponseEntity.ok("Cantuario2 Banking RESTFull API with Java 21 e Spring Boot");
	}

}
