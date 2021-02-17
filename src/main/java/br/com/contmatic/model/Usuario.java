package br.com.contmatic.model;

import static br.com.contmatic.validator.StringValidator.validaEmail;
import static br.com.contmatic.validator.StringValidator.validaFormataCpf;
import static br.com.contmatic.validator.StringValidator.validaFormataRG;
import static br.com.contmatic.validator.StringValidator.validaNome;
import static br.com.contmatic.validator.StringValidator.validaSenha;

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
        this.nome = validaNome(nome);
    }

    public void setEmail(String email) {
        this.email = validaEmail(email);
    }

    public void setSenha(String senha) {
        this.senha = validaSenha(senha);
    }

    public void setCpf(String cpf) {
        this.cpf = validaFormataCpf(cpf);
    }

    public void setRg(String rg) {
        this.rg = validaFormataRG(rg);
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
