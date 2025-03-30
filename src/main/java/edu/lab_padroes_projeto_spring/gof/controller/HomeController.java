package edu.lab_padroes_projeto_spring.gof.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@PostMapping("/")
	public ResponseEntity<String> welcome() {
		return ResponseEntity.ok("Spring Boot Web API V2");
	}
}
