package br.com.bvinvestimentos.calculadora.imposto;

public class ImpostoMaiorQueSetessentosEVinteDias extends Imposto {

	public ImpostoMaiorQueSetessentosEVinteDias(Imposto proximoImposto) {
		super(proximoImposto);
	}

	@Override
	public Double getImposto(Integer numeroDiasInvestido) {
		if (720 < numeroDiasInvestido) {
			return 0.15;
		}
		return proximoImposto.getImposto(numeroDiasInvestido);
	}

}
