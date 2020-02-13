package br.com.contmatic.empresa;

import static br.com.contmatic.constante.Constante.ENTRADA_INVALIDA;
import static br.com.contmatic.constante.Constante.ENTRADA_NULA;
import static br.com.contmatic.constante.Constante.SOMENTE_ALFA;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.br.CNPJ;

import com.google.common.base.Preconditions;

import br.com.contmatic.constante.Constante;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.telefone.Telefone;

/**
 * The Class Empresa.
 */
public class Empresa {

    /** The cnpj. */

    @CNPJ(message = "Cnpj Inválido")
    private String cnpj;

    /** The nome. */
    @NotNull(message = ENTRADA_NULA)
    @NotEmpty(message = ENTRADA_NULA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    private String nome;

    /** The razao social. */
    @NotNull(message = ENTRADA_NULA)
    private String razaoSocial;

    /** The proprietarios. */
    @NotBlank(message = ENTRADA_NULA)
    @NotNull(message = ENTRADA_NULA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    private String proprietarios;

    /** The telefones. */
    @NotNull(message = ENTRADA_NULA)
    private Set<Telefone> telefones;

    /** The endereco. */
    @NotNull(message = ENTRADA_NULA)
    private Set<Endereco> endereco;

    /**
     * Instantiates a new empresa.
     */
    public Empresa() {

    }

    /**
     * Instantiates a new empresa.
     *
     * @param cnpj the cnpj
     * @param nome the nome
     * @param razaoSocial the razao social
     * @param proprietarios the proprietarios
     * @param telefones the telefones
     * @param endereco the endereco
     */
    public Empresa(String cnpj, String nome, String razaoSocial, String proprietarios, Set<Telefone> telefones, Set<Endereco> endereco) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.proprietarios = proprietarios;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    /**
     * Instantiates a new empresa.
     *
     * @param cnpj the cnpj
     * @param nome the nome
     * @param razaoSocial the razao social
     * @param proprietarios the proprietarios
     * @param telefones the telefones
     * @param endereco the endereco
     */
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

    /**
     * Gets the cnpj.
     *
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Gets the razao social.
     *
     * @return the razao social
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * Gets the proprietarios.
     *
     * @return the proprietarios
     */
    public String getProprietarios() {
        return proprietarios;
    }

    /**
     * Gets the telefones.
     *
     * @return the telefones
     */
    public Set<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * Gets the endereco.
     *
     * @return the endereco
     */
    public Set<Endereco> getEndereco() {
        return endereco;
    }

    /**
     * Sets the cnpj.
     *
     * @param cnpj the new cnpj
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Sets the razao social.
     *
     * @param razaoSocial the new razao social
     */
    public void setRazaoSocial(String razaoSocial) {
        invalidaRazaoSocialIncompleta(razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    /**
     * Sets the proprietarios.
     *
     * @param proprietarios the new proprietarios
     */
    public void setProprietarios(String proprietarios) {
        this.proprietarios = proprietarios;
    }

    /**
     * Sets the telefones.
     *
     * @param telefones the new telefones
     */
    public void setTelefones(Set<Telefone> telefones) {
        this.telefones.addAll(telefones);
    }

    /**
     * Invalida razao social incompleta.
     *
     * @param razaoSocial the razao social
     */
    private void invalidaRazaoSocialIncompleta(String razaoSocial) {
        Preconditions.checkArgument(StringUtils.containsWhitespace(razaoSocial), Constante.ENTRADA_INVALIDA);
    }

    /**
     * Sets the endereco.
     *
     * @param endereco the new endereco
     */
    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
