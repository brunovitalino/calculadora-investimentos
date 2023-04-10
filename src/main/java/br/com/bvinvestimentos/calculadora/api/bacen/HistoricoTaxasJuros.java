package br.com.bvinvestimentos.calculadora.api.bacen;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record HistoricoTaxasJuros(@JsonProperty("conteudo") List<Conteudo> conteudos) {}
