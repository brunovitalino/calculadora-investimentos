package br.com.bvinvestimentos.calculadora.api.selic.bacennovo;

import java.util.List;

public record Conteudo(
		Integer totalItems,
		List<Registro> registros,
		String dataAtual
) {}
