package br.com.contmatic.empresa;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.br.CNPJ;

import com.google.common.base.Preconditions;

import br.com.contmatic.constante.Constante;

public class Empresa {

    @NotEmpty(message = Constante.ENTRADA_NULA)
    @NotBlank(message = Constante.ENTRADA_INVALIDA)
    @CNPJ(message = "Cnpj Inválido")
    private String cnpj;

    @NotNull(message = Constante.ENTRADA_NULA)
    @NotEmpty(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.SOMENTE_ALFA, message = Constante.ENTRADA_INVALIDA)
    private String nome;

    @NotNull(message = Constante.ENTRADA_NULA)
    private String razaoSocial;

    @NotBlank(message = Constante.ENTRADA_NULA)
    @NotNull(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.SOMENTE_ALFA, message = Constante.ENTRADA_INVALIDA)
    private String proprietarios;

    @Null
    private String observaçoes;

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
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRazaoSocial(String razaoSocial) {
        invalidaRazaoSocialIncompleta(razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    public void setProprietarios(String proprietarios) {
        this.proprietarios = proprietarios;
    }

    private void invalidaRazaoSocialIncompleta(String razaoSocial) {
        Preconditions.checkArgument(StringUtils.containsWhitespace(razaoSocial), Constante.ENTRADA_INVALIDA);
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
