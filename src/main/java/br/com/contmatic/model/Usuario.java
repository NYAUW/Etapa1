package br.com.contmatic.model;

import static br.com.contmatic.validator.CpfValidator.isCpfValid;
import static br.com.contmatic.validator.StringValidator.isCpfPattern;
import static br.com.contmatic.validator.StringValidator.isEmailPattern;
import static br.com.contmatic.validator.StringValidator.isMaxChararacters;
import static br.com.contmatic.validator.StringValidator.isMinChararacters;
import static br.com.contmatic.validator.StringValidator.isNomePattern;
import static br.com.contmatic.validator.StringValidator.isNotBlank;
import static br.com.contmatic.validator.StringValidator.isRGPattern;
import static br.com.contmatic.validator.Validator.isNotNull;
import static br.com.contmatic.validator.Validator.isNumberBetween;

public class Usuario extends AbstractAuditable{

    private String nome;

    private String email;

    private String senha;

    private String cpf;

    private String rg;

    private Endereco endereco;

    private Telefone telefone;

    public Usuario(String cpf) {
		setCpf(cpf);
	}

	public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
    	isNotNull(nome, "nome");
    	isNotBlank(nome, "nome");
    	isMinChararacters(nome, 2);
    	isMaxChararacters(nome, 60);
    	isNomePattern(nome);
        this.nome = nome;
    }

    public void setEmail(String email) {
    	isNotNull(email, "email");
    	isNotBlank(email, "email");
    	isEmailPattern(email);
        this.email = email;
    }

    public void setSenha(String senha) {
    	isNotNull(senha, "senha");
    	isNotBlank(senha, "senha");
    	isNumberBetween(senha.length(), 4, 16, "senha");
        this.senha = senha;
    }

    public void setCpf(String cpf) {
    	isNotNull(cpf, "cpf");
    	isNotBlank(cpf, "cpf");
    	isCpfPattern(cpf);
    	isCpfValid(cpf);
        this.cpf = cpf;
    }

    public void setRg(String rg) {
    	isNotNull(rg, "rg");
    	isNotBlank(rg, "rg");
    	isRGPattern(rg);
        this.rg = rg;
    }

    public void setEndereco(Endereco endereco) {
    	isNotNull(endereco, "endereço");
        this.endereco = endereco;
    }

    public void setTelefone(Telefone telefone) {
    	isNotNull(telefone, "telefone");
        this.telefone = telefone;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
