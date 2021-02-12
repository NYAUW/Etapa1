package br.contmatic.type;

public enum TelefoneType {
	
	CELULAR(9,"Celular"),
	FIXO(8,"Fixo");

	private final int quantidadeNumeros;
	
	private final String tipoTelefone;
	
	private TelefoneType(int quantidadeNumero, String nome) {
		this.quantidadeNumeros = quantidadeNumero;
		this.tipoTelefone = nome;
	}
	
	public String getTelefone() {
		return tipoTelefone;
	}
	
	public int getQuantidadeNumeros() {
		return quantidadeNumeros;
	}
}
