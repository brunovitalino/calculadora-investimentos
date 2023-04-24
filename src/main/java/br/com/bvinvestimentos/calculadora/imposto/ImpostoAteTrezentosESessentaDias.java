package br.com.bvinvestimentos.calculadora.imposto;

public class ImpostoAteTrezentosESessentaDias extends Imposto {

	public ImpostoAteTrezentosESessentaDias(Imposto proximoImposto) {
		super(proximoImposto);
	}

	@Override
	public Double getImposto(Integer numeroDiasInvestido) {
		if (180 < numeroDiasInvestido && numeroDiasInvestido <= 360) {
			return 0.2;
		}
		return proximoImposto.getImposto(numeroDiasInvestido);
	}

}
