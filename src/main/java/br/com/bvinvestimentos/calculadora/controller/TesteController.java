package br.com.bvinvestimentos.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bvinvestimentos.calculadora.api.selic.SelicAdapter;

@RestController
@RequestMapping("/api/v1/teste")
public class TesteController {
	
	@Autowired
	private SelicAdapter selicAdapter;

	@GetMapping
	public String get() {
		selicAdapter.getSelic();
		return "deu tudo certo!";
	}
}
