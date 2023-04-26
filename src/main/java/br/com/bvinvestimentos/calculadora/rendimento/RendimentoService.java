package br.com.bvinvestimentos.calculadora.rendimento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bvinvestimentos.calculadora.api.selic.SelicAdapter;
import br.com.bvinvestimentos.calculadora.imposto.ImpostoAteCentoEOitentaDias;
import br.com.bvinvestimentos.calculadora.imposto.ImpostoAteSetessentosEVinteDias;
import br.com.bvinvestimentos.calculadora.imposto.ImpostoAteTrezentosESessentaDias;
import br.com.bvinvestimentos.calculadora.imposto.ImpostoMaiorQueSetessentosEVinteDias;
import br.com.bvinvestimentos.calculadora.imposto.ImpostoZerado;

@Service
public class RendimentoService {
	
	@Autowired
	SelicAdapter selicAdapter;
	
	public List<Rendimento> getAllRendimentoTaxavel(BigDecimal valorInvestido, Integer numeroDiasInvestido, Integer rendimentoCDI, BigDecimal aliquotaCDI) {
		var rendimentos = new ArrayList<Rendimento>();
		rendimentos.add(new Rendimento(TipoRendimento.SELIC, getRendimentoEfetivoSelic(valorInvestido, numeroDiasInvestido)));
		rendimentos.add(new Rendimento(TipoRendimento.CDI, getRendimentoEfetivoCDI(valorInvestido, numeroDiasInvestido, rendimentoCDI, aliquotaCDI)));
		return rendimentos;
	}
	
	public BigDecimal getRendimentoEfetivoSelic(BigDecimal valorInvestido, Integer numeroDiasInvestido) {
		BigDecimal rendimentoBruto = getRendimentoSELIC(selicAdapter.getSelic());
		BigDecimal rendimentoEfetivo = getRendimentoEfetivo(rendimentoBruto, numeroDiasInvestido);
		return valorInvestido.add( valorInvestido.multiply(rendimentoEfetivo) ).setScale(2, RoundingMode.HALF_DOWN);
	}
	
	private BigDecimal getRendimentoSELIC(BigDecimal taxaSELIC) {
		return taxaSELIC.divide(new BigDecimal(100));
	}
	
	public BigDecimal getRendimentoEfetivoCDI(BigDecimal valorInvestido, Integer numeroDiasInvestido, Integer rendimentoCDI, BigDecimal aliquotaCDI) {
		BigDecimal rendimentoBruto = getRendimentoCDI(rendimentoCDI, aliquotaCDI);
		BigDecimal rendimentoEfetivo = getRendimentoEfetivo(rendimentoBruto, numeroDiasInvestido);
		return valorInvestido.add( valorInvestido.multiply(rendimentoEfetivo) ).setScale(2, RoundingMode.HALF_DOWN);
	}
	
	private BigDecimal getRendimentoCDI(Integer rendimentoCDI, BigDecimal aliquotaCDI) {
		return new BigDecimal(rendimentoCDI).divide(new BigDecimal(100)).multiply( aliquotaCDI.divide(new BigDecimal(100)) );
	}
	
	private BigDecimal getRendimentoEfetivo(BigDecimal rendimentoBruto, Integer numeroDiasInvestido) {
		return rendimentoBruto.subtract( rendimentoBruto.multiply(new BigDecimal(getImposto(numeroDiasInvestido))) );
	}
	
	private Double getImposto(Integer numeroDiasInvestido) {
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
