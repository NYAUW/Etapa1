package br.com.contmatic.model;

import br.com.contmatic.validator.StringValidator;
import br.com.contmatic.validator.Validator;
import br.contmatic.type.RamoAtividadeType;

public class Empresa {

	private String cnpj;

	private String nomeFantasia;

	private Telefone telefone;

	private Endereco endereco;

	private String razaoSocial;

	private RamoAtividadeType ramoAtividade;

	private String proprietario;

	public String getCnpj() {
		return cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setCnpj(String cnpj) {
		Validator.isNotNull(cnpj, "cnpj");
		StringValidator.isOnlyNumber(cnpj, "cnpj");
		StringValidator.isCnpjPattern(cnpj);
		this.cnpj = cnpj;
	}

	public void setNomeFantasia(String nome) {
		Validator.isNotNull(nome.trim(), "nome fantasia");
		StringValidator.isNomePattern(nome);
		this.nomeFantasia = nome;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		Validator.isNotNull(telefone, "telefone");
		this.telefone = telefone;
	}

	public void setEndereco(Endereco endereco) {
		Validator.isNotNull(endereco, "endereço");
		this.endereco = endereco;
	}

	public void setRazaoSocial(String razaoSocial) {
		Validator.isNotNull(razaoSocial, "razão social");
		this.razaoSocial = razaoSocial;
	}

	public RamoAtividadeType getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividadeType ramoAtividade) {
		Validator.isNotNull(ramoAtividade, "ramo de atividade");
		this.ramoAtividade = ramoAtividade;
	}

	public void setProprietario(String proprietario) {
		Validator.isNotNull(proprietario, "nome do proprietário");
		this.proprietario = proprietario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
}
