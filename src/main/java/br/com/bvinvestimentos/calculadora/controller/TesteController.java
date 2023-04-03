package br.com.bvinvestimentos.calculadora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teste")
public class TesteController {

	@GetMapping
	public String get() {
		return "deu tudo certo!";
	}
}
