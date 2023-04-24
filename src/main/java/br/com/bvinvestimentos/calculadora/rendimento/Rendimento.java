package br.com.bvinvestimentos.calculadora.rendimento;

import java.math.BigDecimal;

public record Rendimento(TipoRendimento tipoRendimento, BigDecimal valorRendido) {}