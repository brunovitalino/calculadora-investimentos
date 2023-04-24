package br.com.bvinvestimentos.calculadora.rendimento;

import org.springframework.stereotype.Service;

import br.com.bvinvestimentos.calculadora.imposto.Imposto;

@Service
public class RendimentoService {
	
	public Double getRendimentoTaxavel(Double valorInvestido) {
		Double rendimentoBruto = getRendimentoCDI(1.10, 0.1365);
		Integer numeroDiasInvestido = 721;
		Double rendimentoEfetivo = getRendimentoEfetivo(rendimentoBruto, numeroDiasInvestido);
		return valorInvestido + (valorInvestido * rendimentoEfetivo);
	}
	
	public Double getRendimentoEfetivo(Double rendimentoBruto, Integer numeroDiasInvestido) {
		return rendimentoBruto - (rendimentoBruto * Imposto.getImposto(numeroDiasInvestido));
	}
	
	public Double getRendimentoCDI(Double rendimentoCDI, Double aliquotaCDI) {
		return rendimentoCDI * aliquotaCDI;
	}
	
	public Double getRendimentoIsento() {
		return null;
	}

}
