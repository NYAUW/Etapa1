package br.com.contmatic.empresa;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.br.CNPJ;

import com.google.common.base.Preconditions;

import br.com.contmatic.constante.Constante;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.telefone.Telefone;

public class Empresa {

    @NotEmpty(message = Constante.ENTRADA_NULA)
    @NotNull(message = Constante.ENTRADA_NULA)
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

    @NotNull(message = Constante.ENTRADA_NULA)
    private Set<Telefone> telefones;

    @NotNull(message = Constante.ENTRADA_NULA)
    private Set<Endereco> endereco;

    public Empresa() {

    }

    public Empresa(String cnpj, String nome, String razaoSocial, String proprietarios, Set<Telefone> telefones, Set<Endereco> endereco) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.proprietarios = proprietarios;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    public Empresa(String cnpj, String nome, String razaoSocial, String proprietarios, Telefone telefones, Endereco endereco) {
        this.telefones = new HashSet<>();
        this.endereco = new HashSet<>();
        this.cnpj = cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.proprietarios = proprietarios;
        this.telefones.add(telefones);
        this.endereco.add(endereco);
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

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public Set<Endereco> getEndereco() {
        return endereco;
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

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones.addAll(telefones);
    }

    private void invalidaRazaoSocialIncompleta(String razaoSocial) {
        Preconditions.checkArgument(StringUtils.containsWhitespace(razaoSocial), Constante.ENTRADA_INVALIDA);
    }

    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((proprietarios == null) ? 0 : proprietarios.hashCode());
        result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
        result = prime * result + ((telefones == null) ? 0 : telefones.hashCode());
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
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
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
        if (telefones == null) {
            if (other.telefones != null)
                return false;
        } else if (!telefones.equals(other.telefones))
            return false;
        return true;
    }

}
