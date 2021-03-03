package br.com.contmatic.model;

import static br.com.contmatic.validator.CnpjValidator.isCnpjValid;
import static br.com.contmatic.validator.StringValidator.isMaxChararacters;
import static br.com.contmatic.validator.StringValidator.isMinChararacters;
import static br.com.contmatic.validator.StringValidator.isNotBlank;
import static br.com.contmatic.validator.StringValidator.isOnlyNumber;
import static br.com.contmatic.validator.Validator.isNotNull;

import br.contmatic.type.RamoAtividadeType;

public class Empresa extends AbstractAuditable{

	private String cnpj;

	private String nomeFantasia;

	private Telefone telefone;

	private Endereco endereco;

	private String razaoSocial;

	private RamoAtividadeType ramoAtividade;

	private String proprietario;
	
	public Empresa(String cnpj) {
		this.setCnpj(cnpj);
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		isNotNull(cnpj, "cnpj");
		isNotBlank(cnpj, "cnpj");
		isOnlyNumber(cnpj, "cnpj");
		isCnpjValid(cnpj);
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		isNotNull(nomeFantasia, "nome fantasia");
		isNotBlank(nomeFantasia, "nome fantasia");
		isMinChararacters(nomeFantasia, 2);
		isMaxChararacters(nomeFantasia, 60);
		this.nomeFantasia = nomeFantasia;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		isNotNull(telefone, "telefone");
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		isNotNull(endereco, "endereço");
		this.endereco = endereco;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		isNotNull(razaoSocial, "razão social");
		isNotBlank(razaoSocial, "razão social");
		isMinChararacters(razaoSocial, 2);
		isMaxChararacters(razaoSocial, 60);
		this.razaoSocial = razaoSocial;
	}

	public RamoAtividadeType getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividadeType ramoAtividade) {
		isNotNull(ramoAtividade, "ramo de Atividade");
		this.ramoAtividade = ramoAtividade;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		isNotNull(proprietario, "proprietário");
		isNotBlank(proprietario, "proprietário");
		isMinChararacters(proprietario, 2);
		isMaxChararacters(proprietario, 60);
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
