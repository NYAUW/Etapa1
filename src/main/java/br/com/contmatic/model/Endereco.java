package br.com.contmatic.model;

import br.contmatic.type.EstadosType;
import br.contmatic.type.PaisType;

public class Endereco {
	
	private String bairro;
	
	private PaisType pais;
	
	private EstadosType estado;
	
	private String logradouro;
	
	private String complemento;
	
	private int numero;

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public PaisType getPais() {
		return pais;
	}

	public void setPais(PaisType pais) {
		this.pais = pais;
	}

	public EstadosType getEstado() {
		return estado;
	}

	public void setEstado(EstadosType estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}
