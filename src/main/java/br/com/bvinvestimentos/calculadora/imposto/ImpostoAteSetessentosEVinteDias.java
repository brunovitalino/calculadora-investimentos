package br.com.bvinvestimentos.calculadora.imposto;

public class ImpostoAteSetessentosEVinteDias extends Imposto {

	public ImpostoAteSetessentosEVinteDias(Imposto proximoImposto) {
		super(proximoImposto);
	}

	@Override
	public Double getImposto(Integer numeroDiasInvestido) {
		if (360 < numeroDiasInvestido && numeroDiasInvestido <= 720) {
			return 0.175;
		}
		return proximoImposto.getImposto(numeroDiasInvestido);
	}

}
