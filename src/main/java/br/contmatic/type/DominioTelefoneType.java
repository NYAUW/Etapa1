package br.contmatic.type;

public enum DominioTelefoneType {
	
	DOMESTICO("Doméstico"),
	COMERCIAL("Comercial"),
	PESSOAL("Pessoal");

	private String dominio;
	
	public String getDominio() {
		return dominio;
	}

	DominioTelefoneType(String dominio) {
		this.dominio = dominio;
	}
	
	
}
