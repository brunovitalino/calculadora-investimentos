package br.com.bvinvestimentos.calculadora.api.selic.bacen;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record HistoricoTaxasJuros(@JsonProperty("conteudo") List<Conteudo> conteudos) {}
