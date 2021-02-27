package br.com.contmatic.model;

import br.com.contmatic.validator.StringValidator;
import br.com.contmatic.validator.Validator;
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
		Validator.isNotNull(tipoTelefone, "tipo do telefone");
		this.tipoTelefone = tipoTelefone;
	}

	public DddType getDdd() {
		return ddd;
	}

	public void setDdd(DddType ddd) {
		Validator.isNotNull(ddd, "DDD");
		this.ddd = ddd;
	}

	public DominioTelefoneType getDominio() {
		return dominio;
	}

	public void setDominio(DominioTelefoneType dominio) {
		Validator.isNotNull(dominio, "domínio");
		this.dominio = dominio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		Validator.isNotNull(numero, "número");
		Validator.isTipoTelefoneNotNull(tipoTelefone);
		StringValidator.isOnlyNumber(numero, "número");
		StringValidator.isNumberTelPattern(numero, tipoTelefone);
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
