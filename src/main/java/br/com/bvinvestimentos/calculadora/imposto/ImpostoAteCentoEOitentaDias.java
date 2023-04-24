package br.com.bvinvestimentos.calculadora.imposto;

public class ImpostoAteCentoEOitentaDias extends Imposto {

	public ImpostoAteCentoEOitentaDias(Imposto proximoImposto) {
		super(proximoImposto);
	}

	@Override
	public Double getImposto(Integer numeroDiasInvestido) {
		if (numeroDiasInvestido <= 180) {
			return 0.225;
		}
		return proximoImposto.getImposto(numeroDiasInvestido);
	}

}
