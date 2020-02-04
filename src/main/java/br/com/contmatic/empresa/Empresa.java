package br.com.contmatic.empresa;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.contmatic.constante.Constante;

public class Empresa {

    @NotBlank(message = Constante.ENTRADA_NULA)
    @CNPJ(message = "Cnpj Inválido")
    private String cnpj;

    private String nome;

    private String razaoSocial;

    private String proprietarios;

    public Empresa() {

    }

    public Empresa(String cnpj, String nome, String razaoSocial, String proprietarios) {

        super();
        this.cnpj = cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.proprietarios = proprietarios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getProprietarios() {
        return proprietarios;
    }

    public void setCnpj(String cnpj) {
        verificaTamanhoCnpjValido(cnpj);
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRazaoSocial(String razaoSocial) {
        verificaRazaoSocialCompleta(razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    public void setProprietarios(String proprietarios) {
        verificaProprietarioNull(proprietarios);
        this.proprietarios = proprietarios;
    }

    private void verificaTamanhoCnpjValido(String cnpj) {
        if (cnpj.length() != 18) {
            throw new IllegalArgumentException(Constante.ENTRADA_INVALIDA);
        }
    }

    private void verificaRazaoSocialCompleta(String razaoSocial) {
        if (!StringUtils.containsWhitespace(razaoSocial)) {
            throw new IllegalArgumentException(Constante.ENTRADA_INVALIDA);
        }
    }

    private void verificaProprietarioNull(String proprietarios2) {
        if (proprietarios2 == null) {
            throw new NullPointerException(Constante.ENTRADA_NULA);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((proprietarios == null) ? 0 : proprietarios.hashCode());
        result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
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
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (proprietarios == null) {
            if (other.proprietarios != null)
                return false;
        } else if (!proprietarios.equals(other.proprietarios))
            return false;
        if (razaoSocial == null) {
            if (other.razaoSocial != null)
                return false;
        } else if (!razaoSocial.equals(other.razaoSocial))
            return false;
        return true;
    }

}
