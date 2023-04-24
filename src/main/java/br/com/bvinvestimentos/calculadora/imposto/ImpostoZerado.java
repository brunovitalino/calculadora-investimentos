package br.com.bvinvestimentos.calculadora.imposto;

public class ImpostoZerado extends Imposto {

	public ImpostoZerado() {
		super(null);
	}

	@Override
	public Double getImposto(Integer numeroDiasInvestido) {
		return 0.0;
	}

}
