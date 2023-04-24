package br.com.bvinvestimentos.calculadora.rendimento;

import org.springframework.stereotype.Service;

import br.com.bvinvestimentos.calculadora.imposto.ImpostoAteCentoEOitentaDias;
import br.com.bvinvestimentos.calculadora.imposto.ImpostoAteSetessentosEVinteDias;
import br.com.bvinvestimentos.calculadora.imposto.ImpostoAteTrezentosESessentaDias;
import br.com.bvinvestimentos.calculadora.imposto.ImpostoMaiorQueSetessentosEVinteDias;
import br.com.bvinvestimentos.calculadora.imposto.ImpostoZerado;

@Service
public class RendimentoService {
	
	public Double getRendimentoTaxavel(Double valorInvestido) {
		Double rendimentoBruto = getRendimentoCDI(1.10, 0.1365);
		Integer numeroDiasInvestido = 721;
		Double rendimentoEfetivo = getRendimentoEfetivo(rendimentoBruto, numeroDiasInvestido);
		return valorInvestido + (valorInvestido * rendimentoEfetivo);
	}
	
	public Double getRendimentoCDI(Double rendimentoCDI, Double aliquotaCDI) {
		return rendimentoCDI * aliquotaCDI;
	}
	
	public Double getRendimentoEfetivo(Double rendimentoBruto, Integer numeroDiasInvestido) {
		return rendimentoBruto - (rendimentoBruto * getImposto(numeroDiasInvestido));
	}
	
	public Double getImposto(Integer numeroDiasInvestido) {
		return new ImpostoAteCentoEOitentaDias(
				new ImpostoAteTrezentosESessentaDias(
						new ImpostoAteSetessentosEVinteDias(
								new ImpostoMaiorQueSetessentosEVinteDias(
										new ImpostoZerado())))).getImposto(numeroDiasInvestido);
	}
	
	public Double getRendimentoIsento() {
		return null;
	}

}
