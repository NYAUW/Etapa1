package br.com.contmatic.telefone;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.contmatic.constante.Constante;

public class Telefone {

    @NotEmpty(message = Constante.ENTRADA_NULA)
    @NotNull(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = "(([1][1-9])|([2][1-2])|([2][4-8])|([3][1-5])|([3][7-8])|([4][1-9])|([5][1])|([5][3-5])|([6][1-9])|([7][1])|([7][3-5])|([7][7])|([7][9])|([8][1-9]))(([0-9]{8})|([0-9]{9}))", message = "Numero Inválido")
    String numero;

    @NotEmpty(message = Constante.ENTRADA_NULA)
    @NotNull(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = "^[0-9]{3}$*", message = Constante.ENTRADA_INVALIDA)
    String ramal;

    @NotNull(message = Constante.ENTRADA_NULA)
    TipoTelefone tipo;

    public Telefone() {

    }

    public Telefone(String numero, String ramal, TipoTelefone tipo) {
        super();
        this.numero = numero;
        this.ramal = ramal;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public String getRamal() {
        return ramal;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        result = prime * result + ((ramal == null) ? 0 : ramal.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
        Telefone other = (Telefone) obj;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        if (ramal == null) {
            if (other.ramal != null)
                return false;
        } else if (!ramal.equals(other.ramal))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        return true;
    }

}
