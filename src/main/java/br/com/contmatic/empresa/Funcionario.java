package br.com.contmatic.empresa;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.google.common.base.Preconditions;

import br.com.contmatic.constante.Constante;

public class Funcionario {

    @NotNull(message = Constante.ENTRADA_NULA)
    @NotBlank(message = Constante.ENTRADA_INVALIDA)
    @Pattern(regexp = Constante.SOMENTE_ALFA, message = Constante.ENTRADA_INVALIDA)
    private String nome;

    @NotNull(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.SOMENTE_ALFA, message = Constante.ENTRADA_INVALIDA)
    private String cargo;

    @NotNull(message = Constante.ENTRADA_NULA)
    @Min(value = 1)
    @Max(value = 9999)
    private int codigo;

    @NotNull(message = Constante.ENTRADA_NULA)
    private int salario;

    public Funcionario() {

    }

    public Funcionario(String nome, String cargo, int codigo, int salario) {
        super();
        this.nome = nome;
        this.cargo = cargo;
        this.codigo = codigo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        verificaSelecaoCargo(cargo);
        this.cargo = cargo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    private void verificaSelecaoCargo(String cargo) {
        Preconditions.checkArgument(cargo.equals("Atendente") || (cargo.equals("Tecnico") || (cargo.equals("Auxiliar"))), Constante.ENTRADA_INVALIDA);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
        result = prime * result + codigo;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        long temp;
        temp = Double.doubleToLongBits(salario);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Funcionario other = (Funcionario) obj;
        if (cargo == null) {
            if (other.cargo != null)
                return false;
        } else if (!cargo.equals(other.cargo))
            return false;
        if (codigo != other.codigo)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
            return false;
        return true;
    }
}
