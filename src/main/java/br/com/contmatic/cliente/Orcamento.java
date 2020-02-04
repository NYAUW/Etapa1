package br.com.contmatic.cliente;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.contmatic.constante.Constante;

public class Orcamento {

    @NotNull(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.SOMENTE_ALFA)
    private String marca;

    @NotBlank(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.SERIAL)
    private String serial;

    @Min(value = 10, message = "Por favor, especifique com mais detalhes")
    @Max(value = 100, message = "LIMITE DE CARACTERES EXCEDIDOS!")
    @NotBlank(message = Constante.ENTRADA_NULA)
    private String defeito;

    public Orcamento() {

    }

    public Orcamento(String marca, String serial, String defeito) {
        this.marca = marca;
        this.serial = serial;
        this.defeito = defeito;
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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setDefeito(String defeito) {
        verificaDefeitoCompleto(defeito);
        this.defeito = defeito;
    }

    private void verificaDefeitoCompleto(String defeito) {
        if (!defeito.contains(" ")) {
            throw new IllegalArgumentException("O defeito precisa ser especificado de maneira legivel e detalhado");
        }
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
