package br.com.contmatic.cliente;

import static br.com.contmatic.constante.Constante.ENTRADA_INVALIDA;
import static br.com.contmatic.constante.Constante.ENTRADA_NULA;
import static br.com.contmatic.constante.Constante.SERIAL;
import static br.com.contmatic.constante.Constante.SOMENTE_ALFA;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.joda.time.DateTime;

/**
 * The Class Orcamento.
 */
public class Orcamento {

    /** The marca. */
    @NotNull(message = ENTRADA_NULA)
    @Pattern(regexp = SOMENTE_ALFA)
    private String marca;

    /** The serial. */
    @NotBlank(message = ENTRADA_NULA)
    @Pattern(regexp = SERIAL)
    private String serial;

    /** The defeito. */
    @Size(min = 10, max = 200, message = ENTRADA_INVALIDA)
    @NotNull(message = ENTRADA_NULA)
    private String defeito;

    /** The data. */
    private DateTime data;

    /**
     * Instantiates a new orcamento.
     */
    public Orcamento() {

    }

    /**
     * Instantiates a new orcamento.
     *
     * @param marca the marca
     * @param serial the serial
     * @param defeito the defeito
     * @param data the data
     */
    public Orcamento(String marca, String serial, String defeito, DateTime data) {
        this.marca = marca;
        this.serial = serial;
        this.defeito = defeito;
        this.data = data;
    }

    /**
     * Gets the marca.
     *
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Gets the serial.
     *
     * @return the serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Gets the defeito.
     *
     * @return the defeito
     */
    public String getDefeito() {
        return defeito;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public DateTime getData() {
        return data;
    }

    /**
     * Sets the marca.
     *
     * @param marca the new marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Sets the serial.
     *
     * @param serial the new serial
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * Sets the defeito.
     *
     * @param defeito the new defeito
     */
    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(DateTime data) {
        this.data = data;
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
