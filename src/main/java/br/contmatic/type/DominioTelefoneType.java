package br.contmatic.type;

public enum DominioTelefoneType {
	
	DOMESTICO("Doméstico"),
	COMERCIAL("Comercial"),
	PESSOAL("Pessoal");

	private String dominio;
	
	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	DominioTelefoneType(String dominio) {
		this.dominio = dominio;
	}
	
	
}
