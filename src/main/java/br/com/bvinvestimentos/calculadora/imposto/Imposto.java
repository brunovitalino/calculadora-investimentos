package br.com.bvinvestimentos.calculadora.imposto;

public class Imposto {
		
	public static Double getImposto(Integer numeroDiasInvestido) {
		if (numeroDiasInvestido <= 180) {
			return 0.225;
		}
		if (180 < numeroDiasInvestido && numeroDiasInvestido <= 360) {
			return 0.2;
		}
		if (360 < numeroDiasInvestido && numeroDiasInvestido <= 720) {
			return 0.175;
		}
		if (720 < numeroDiasInvestido) {
			return 0.15;
		}
		return 0.0;
	}

}
