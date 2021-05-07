package com.inatel.projeto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DetalharController {

	public ResponseEntity<String> Detalha() {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> detalhe =restTemplate.getForEntity("https://age-of-empires-2-api.herokuapp.com/api/v1/civilizations",String.class);
		
		
		
		return detalhe;
	}
}
