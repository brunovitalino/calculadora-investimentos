package br.com.bvinvestimentos.calculadora.api.selic.bacen;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Conteudo(
		@JsonProperty("NumeroReuniaoCopom") Integer numeroReuniaoCopom,
		@JsonProperty("DataReuniaoCopom") LocalDate dataReuniaoCopom,
		@JsonProperty("MetaSelic") Double metaSelic,
		@JsonProperty("TaxaSelicEfetivaVigencia") Double taxaSelicEfetivaVigencia,
		@JsonProperty("TaxaSelicEfetivaAnualizada") Double taxaSelicEfetivaAnualizada
) {}
