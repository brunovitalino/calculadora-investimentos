package br.com.bvinvestimentos.calculadora.api.selic.bacennovo;

import java.math.BigDecimal;

public record Registro(String dataCotacao, Double media, BigDecimal taxaAnual) {}
