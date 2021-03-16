package br.com.contmatic.model;

import static br.com.contmatic.validator.StringValidator.isNumberTelPattern;
import static br.com.contmatic.validator.StringValidator.isOnlyNumber;
import static br.com.contmatic.validator.Validator.isNotNull;
import static br.com.contmatic.validator.Validator.isTipoTelefoneNotNull;

import br.contmatic.type.DddType;
import br.contmatic.type.DominioTelefoneType;
import br.contmatic.type.TelefoneType;

public class Telefone extends AbstractAuditable{

	private TelefoneType tipoTelefone;

	private DddType ddd;

	private DominioTelefoneType dominio;

	private String numero;
	
	public Telefone(String numero, TelefoneType telefoneType) {
		setTipoTelefone(telefoneType);
		setNumero(numero);
	}

	public TelefoneType getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TelefoneType tipoTelefone) {
		isNotNull(tipoTelefone, "tipo do telefone");
		this.tipoTelefone = tipoTelefone;
	}

	public DddType getDdd() {
		return ddd;
	}

	public void setDdd(DddType ddd) {
		isNotNull(ddd, "DDD");
		this.ddd = ddd;
	}

	public DominioTelefoneType getDominio() {
		return dominio;
	}

	public void setDominio(DominioTelefoneType dominio) {
		isNotNull(dominio, "domínio");
		this.dominio = dominio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		isNotNull(numero, "número");
		isTipoTelefoneNotNull(tipoTelefone);
		isOnlyNumber(numero, "número");
		isNumberTelPattern(numero, tipoTelefone);
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

}
