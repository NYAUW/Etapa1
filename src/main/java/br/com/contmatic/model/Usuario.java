package br.com.contmatic.model;

import br.com.contmatic.validator.StringValidator;

public class Usuario {

    private String nome;

    private String email;

    private String senha;

    private String cpf;

    private String rg;

    private Endereco endereco;

    private Telefone telefone;

    public Usuario(String nome, String email, String senha, String cpf, String rg, Endereco endereco, Telefone telefone) {
        super();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
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
        this.nome = StringValidator.validaNome(nome);
    }

    public void setEmail(String email) {
        this.email = StringValidator.validaEmail(email);
    }

    public void setSenha(String senha) {
        this.senha = StringValidator.validaQuantidadeCaracteres(senha, 4);
    }

    public void setCpf(String cpf) {
        this.cpf = StringValidator.validaFormataCpf(cpf);
    }

    public void setRg(String rg) {
        this.rg = StringValidator.validaFormataRG(rg);
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
