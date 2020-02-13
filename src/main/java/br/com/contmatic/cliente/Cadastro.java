package br.com.contmatic.cliente;

import static br.com.contmatic.constante.Constante.ENTRADA_INVALIDA;
import static br.com.contmatic.constante.Constante.ENTRADA_NULA;
import static br.com.contmatic.constante.Constante.RG;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

/**
 * The Class Cadastro.
 */
public class Cadastro {

    /** The nome. */
    @NotBlank(message = ENTRADA_NULA)
    @NotEmpty(message = ENTRADA_NULA)
    @NotNull(message = ENTRADA_NULA)
    @Length(min = 5, message = "Nome Incompleto")
    @Size(max = 50, message = "Quantidade de caracteres excedida")
    private String nome;

    /** The email. */
    @Email(message = ENTRADA_INVALIDA)
    private String email;

    /** The senha. */
    @NotEmpty(message = ENTRADA_NULA)
    @NotNull(message = ENTRADA_NULA)
    private String senha;

    /** The cpf. */
    @CPF(message = ENTRADA_INVALIDA)
    private String cpf;

    /** The rg. */
    @NotEmpty(message = ENTRADA_NULA)
    @Pattern(regexp = RG, message = "Rg Inválido")
    private String rg;

    /**
     * Instantiates a new cadastro.
     */
    public Cadastro() {
    }

    /**
     * Instantiates a new cadastro.
     *
     * @param nome the nome
     * @param email the email
     * @param senha the senha
     * @param cpf the cpf
     * @param rg the rg
     */
    public Cadastro(String nome, String email, String senha, String cpf, String rg) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
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
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the senha.
     *
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Gets the cpf.
     *
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Gets the rg.
     *
     * @return the rg
     */
    public String getRg() {
        return rg;
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
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the senha.
     *
     * @param senha the new senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Sets the cpf.
     *
     * @param cpf the new cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Sets the rg.
     *
     * @param rg the new rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Verifica dominio email.
     *
     * @param email the email
     */

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((rg == null) ? 0 : rg.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
        return result;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cadastro other = (Cadastro) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (rg == null) {
            if (other.rg != null)
                return false;
        } else if (!rg.equals(other.rg))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        return true;
    }
}
