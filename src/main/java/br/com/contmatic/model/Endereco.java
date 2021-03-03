package br.com.contmatic.model;

import static br.com.contmatic.validator.StringValidator.isMaxChararacters;
import static br.com.contmatic.validator.StringValidator.isMinChararacters;
import static br.com.contmatic.validator.StringValidator.isNotBlank;
import static br.com.contmatic.validator.StringValidator.isThisExactChararacters;
import static br.com.contmatic.validator.Validator.isGreaterThanZero;
import static br.com.contmatic.validator.Validator.isNotNull;

import br.contmatic.type.EstadosType;
import br.contmatic.type.PaisType;

public class Endereco extends AbstractAuditable {

	private String bairro;

	private PaisType pais;

	private EstadosType estado;

	private String logradouro;

	public Endereco(String cep, Integer numero) {
		setCep(cep);
		setNumero(numero);
	}

	private String cep;

	private String complemento;

	private Integer numero;
	
	

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		isNotNull(bairro, "bairro");
		isNotBlank(bairro, "bairro");
		isMinChararacters(bairro, 2);
		isMaxChararacters(bairro, 60);
		this.bairro = bairro;
	}

	public PaisType getPais() {
		return pais;
	}

	public void setPais(PaisType pais) {
		isNotNull(pais, "país");
		this.pais = pais;
	}

	public EstadosType getEstado() {
		return estado;
	}

	public void setEstado(EstadosType estado) {
		isNotNull(estado, "estado");
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		isNotNull(logradouro, "logradouro");
		isNotBlank(logradouro, "logradouro");
		isMinChararacters(logradouro, 3);
		isMaxChararacters(logradouro, 50);
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		if (complemento != null) {
			isNotBlank(complemento, "complemento");
			isMinChararacters(complemento, 3);
			isMaxChararacters(complemento, 20);
		}
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		isNotNull(numero, "número da residência");
		isGreaterThanZero(numero);
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		isNotNull(cep, "cep");
		isNotBlank(cep, "cep");
		isThisExactChararacters(cep, 8);
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + numero;
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
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

}
