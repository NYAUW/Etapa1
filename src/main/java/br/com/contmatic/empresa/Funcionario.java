package br.com.contmatic.empresa;

import static br.com.contmatic.constante.Constante.ENTRADA_INVALIDA;
import static br.com.contmatic.constante.Constante.ENTRADA_NULA;
import static br.com.contmatic.constante.Constante.SOMENTE_ALFA;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

import br.com.contmatic.constante.Constante;

/**
 * The Class Funcionario.
 */
public class Funcionario {

    /** The nome. */
    @NotNull(message = ENTRADA_NULA)
    @NotBlank(message = ENTRADA_INVALIDA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    private String nome;

    /** The cargo. */
    @NotNull(message = ENTRADA_NULA)
    @Pattern(regexp = SOMENTE_ALFA, message = ENTRADA_INVALIDA)
    private String cargo;

    /** The codigo. */
    @NotNull(message = ENTRADA_NULA)
    @Min(value = 1)
    @Max(value = 9999)
    private int codigo;

    /** The salario. */
    @NotNull(message = ENTRADA_NULA)
    private BigDecimal salario;

    /**
     * Instantiates a new funcionario.
     */
    public Funcionario() {

    }

    /**
     * Instantiates a new funcionario.
     *
     * @param nome the nome
     * @param cargo the cargo
     * @param codigo the codigo
     * @param salario the salario
     */
    public Funcionario(String nome, String cargo, int codigo, BigDecimal salario) {
        super();
        this.nome = nome;
        this.cargo = cargo;
        this.codigo = codigo;
        this.salario = salario;
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
     * Gets the cargo.
     *
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Gets the codigo.
     *
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Gets the salario.
     *
     * @return the salario
     */
    public BigDecimal getSalario() {
        return salario;
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
     * Sets the cargo.
     *
     * @param cargo the new cargo
     */
    public void setCargo(String cargo) {
        verificaSelecaoCargo(cargo);
        this.cargo = cargo;
    }

    /**
     * Sets the codigo.
     *
     * @param codigo the new codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Sets the salario.
     *
     * @param salario the new salario
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    /**
     * Verifica selecao cargo.
     *
     * @param cargo the cargo
     */
    private void verificaSelecaoCargo(String cargo) {
        Preconditions.checkArgument(cargo.equals("Atendente") || (cargo.equals("Tecnico") || (cargo.equals("Auxiliar"))), Constante.ENTRADA_INVALIDA);
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
