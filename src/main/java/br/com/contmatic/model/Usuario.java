package br.com.contmatic.model;

import br.com.contmatic.validator.CpfValidator;
import br.com.contmatic.validator.StringValidator;
import br.com.contmatic.validator.Validator;

public class Usuario {

    private String nome;

    private String email;

    private String senha;

    private String cpf;

    private String rg;

    private Endereco endereco;

    private Telefone telefone;

    public Usuario() {
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
    	Validator.isNotNull(nome, "nome");
    	StringValidator.isNomePattern(nome);
        this.nome = nome;
    }

    public void setEmail(String email) {
    	Validator.isNotNull(email, "email");
    	StringValidator.isEmailPattern(email);
        this.email = email;
    }

    public void setSenha(String senha) {
    	Validator.isNotNull(senha, "senha");
    	Validator.isNumberBetween(senha.length(), 4, 16, "senha");
        this.senha = senha;
    }

    public void setCpf(String cpf) {
    	Validator.isNotNull(cpf, "cpf");
    	StringValidator.isCpfPattern(cpf);
    	CpfValidator.isCpfValid(cpf);
        this.cpf = cpf;
    }

    public void setRg(String rg) {
    	Validator.isNotNull(rg, "rg");
    	StringValidator.isRGPattern(rg);
        this.rg = rg;
    }

    public void setEndereco(Endereco endereco) {
    	Validator.isNotNull(endereco, "endereço");
        this.endereco = endereco;
    }

    public void setTelefone(Telefone telefone) {
    	Validator.isNotNull(telefone, "telefone");
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
