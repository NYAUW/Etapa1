package br.com.contmatic.cliente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import br.com.contmatic.constante.Constante;

public class Orcamento {

    @NotNull(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.SOMENTE_ALFA)
    private String marca;

    @NotBlank(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.SERIAL)
    private String serial;

    @Size(min = 10, max = 200, message = Constante.ENTRADA_INVALIDA)
    @NotNull(message = Constante.ENTRADA_NULA)
    private String defeito;

    private DateTime data;

    public Orcamento() {

    }

    public Orcamento(String marca, String serial, String defeito, DateTime data) {
        this.marca = marca;
        this.serial = serial;
        this.defeito = defeito;
        this.data = data;
    }

    public String getMarca() {
        return marca;
    }

    public String getSerial() {
        return serial;
    }

    public String getDefeito() {
        return defeito;
    }

    public DateTime getData() {
        return data;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public void setData(DateTime data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((defeito == null) ? 0 : defeito.hashCode());
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((serial == null) ? 0 : serial.hashCode());
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
        Orcamento other = (Orcamento) obj;
        if (defeito == null) {
            if (other.defeito != null)
                return false;
        } else if (!defeito.equals(other.defeito))
            return false;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (serial == null) {
            if (other.serial != null)
                return false;
        } else if (!serial.equals(other.serial))
            return false;
        return true;
    }

}
