package br.com.contmatic.model;

import br.com.contmatic.validator.StringValidator;
import br.contmatic.type.RamoAtividadeType;

public class Empresa {

	private String cnpj;

	private String nome;

	private Telefone telefone;

	private Endereco endereco;

	private String razaoSocial;

	private RamoAtividadeType ramoAtividade;

	private String proprietario;

	public String getCnpj() {
		return cnpj;
	}

	public String getNome() {
		return nome;
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
		this.cnpj = StringValidator.validaCnpj(cnpj);
	}

	public void setNome(String nome) {
		this.nome = StringValidator.validaNome(nome);
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public RamoAtividadeType getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividadeType ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public void setProprietario(String proprietarios) {
		this.proprietario = proprietarios;
	}
}
