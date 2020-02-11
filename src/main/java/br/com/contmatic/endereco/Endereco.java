package br.com.contmatic.endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.google.common.base.Preconditions;

import br.com.contmatic.constante.Constante;

public class Endereco {

    @NotNull(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.SOMENTE_ALFA, message = Constante.ENTRADA_INVALIDA)
    String rua;

    @NotEmpty(message = Constante.ENTRADA_NULA)
    @NotNull(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.SOMENTE_ALFA, message = "Test")
    String bairro;

    int numero;

    @NotEmpty(message = Constante.ENTRADA_NULA)
    @NotNull(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.SOMENTE_ALFA, message = Constante.ENTRADA_INVALIDA)
    String regiao;

    @NotBlank(message = Constante.ENTRADA_INVALIDA)
    @NotEmpty(message = Constante.ENTRADA_NULA)
    @NotNull(message = Constante.ENTRADA_NULA)
    @Length(max = 8, min = 8, message = Constante.ENTRADA_INVALIDA)
    @Pattern(regexp = "[0-9]{8}", message = Constante.ENTRADA_INVALIDA)
    String cep;

    @NotNull
    TipoEndereco tipo;

    public Endereco() {
    }

    public Endereco(String rua, int numero, String bairro, String regiao, String cep, TipoEndereco tipo) {
        super();
        this.bairro = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.regiao = regiao;
        this.cep = cep;
        this.tipo = tipo;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getCep() {
        return cep;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setRua(String rua) {
        verificaSeContemEspeciais(rua);
        this.bairro = rua;
    }

    public void setNumero(int numero) {
        verificaSeNumeroEZero(numero);
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        verificaSeContemEspeciais(bairro);
        this.bairro = bairro;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setCep(String cep) {
        verificaSeContemEspeciais(cep);
        this.cep = cep;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    private void verificaSeNumeroEZero(int numero) {
        Preconditions.checkArgument(!(numero == 0), Constante.ENTRADA_NULA);
    }

    private void verificaSeContemEspeciais(String var) {
        Preconditions.checkArgument(!(var.contains("!") || var.contains("@") || var.contains("#") || var.contains("$") || var.contains("%") || var.contains("¨") || var.contains("&") ||
            var.contains("*") || var.contains("(") || var.contains(")") || var.contains("-") || var.contains("+") || var.contains("/") || var.contains(",") || var.contains("?") || var.contains(";") ||
            var.contains(":") || var.contains("\\") || var.contains("'")), Constante.ENTRADA_INVALIDA);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        result = prime * result + numero;
        result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
        result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
        Endereco other = (Endereco) obj;
        if (bairro == null) {
            if (other.bairro != null)
                return false;
        } else if (!bairro.equals(other.bairro))
            return false;
        if (cep == null) {
            if (other.cep != null)
                return false;
        } else if (!cep.equals(other.cep))
            return false;
        if (numero != other.numero)
            return false;
        if (regiao == null) {
            if (other.regiao != null)
                return false;
        } else if (!regiao.equals(other.regiao))
            return false;
        if (rua == null) {
            if (other.rua != null)
                return false;
        } else if (!rua.equals(other.rua))
            return false;
        return true;
    }

}
