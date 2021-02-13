package br.com.contmatic.model;

import br.com.contmatic.validator.StringValidator;
import br.contmatic.type.DddType;
import br.contmatic.type.DominioTelefoneType;
import br.contmatic.type.TelefoneType;

public class Telefone {
	
	private TelefoneType tipoTelefone;
	
	private DddType ddd;
	
	private DominioTelefoneType dominio;
	
	private String numero;

	public TelefoneType getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TelefoneType tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public DddType getDdd() {
		return ddd;
	}

	public void setDdd(DddType ddd) {
		this.ddd = ddd;
	}

	public DominioTelefoneType getDominio() {
		return dominio;
	}

	public void setDominio(DominioTelefoneType dominio) {
		this.dominio = dominio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = StringValidator.validaNumeroTelefone(numero, tipoTelefone);
	}

	@Override
	public String toString() {
		return "Telefone [tipoTelefone=" + tipoTelefone + ", ddd=" + ddd + ", dominio=" + dominio + ", numero=" + numero
				+ "]";
	}
	
}
