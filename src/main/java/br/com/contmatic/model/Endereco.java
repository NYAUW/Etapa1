package br.com.contmatic.model;

import static br.com.contmatic.validator.Validator.isNotNull;

import br.com.contmatic.validator.StringValidator;
import br.com.contmatic.validator.Validator;
import br.contmatic.type.EstadosType;
import br.contmatic.type.PaisType;

public class Endereco {
	
	private String bairro;
	
	private PaisType pais;
	
	private EstadosType estado;
	
	private String logradouro;
	
	private String cep;
	
	private String complemento;
	
	private int numero;

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		isNotNull(bairro, "bairro");
		StringValidator.isMinChararacters(bairro, 2);
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
		StringValidator.isMinChararacters(logradouro, 3);
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		isNotNull(complemento, "complemento");
		StringValidator.isMinChararacters(complemento, 3);
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		Validator.isGreaterThanZero(numero);
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
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
