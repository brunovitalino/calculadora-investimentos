package br.com.bvinvestimentos.calculadora.imposto;

public abstract class Imposto {
	
	protected Imposto proximoImposto;
	
	public Imposto(Imposto proximoImposto) {
		this.proximoImposto = proximoImposto;
	}
		
	public abstract Double getImposto(Integer numeroDiasInvestido);

}
