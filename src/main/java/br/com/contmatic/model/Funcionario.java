package br.com.contmatic.model;

import br.com.contmatic.validator.StringValidator;
import br.com.contmatic.validator.Validator;

public class Funcionario {

    private String nome;

    private String cargoNome;

    private int codigo;

    private double salario;

    public Funcionario(String nome, String cargoNome, int codigo, double salario) {
        this.nome = nome;
        this.cargoNome = cargoNome;
        this.codigo = codigo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargoNome() {
        return cargoNome;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = StringValidator.validaNome(nome);
    }

    public void setCargoNome(String cargoNome) {
        this.cargoNome = (String) Validator.isNotNull(cargoNome);
    }

    public void setCodigo(int codigo) {
        this.codigo = (Integer) Validator.isNotNull(codigo);
    }

    public void setSalario(int salario) {
        this.salario = (Double) Validator.isNotNull(salario);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cargoNome == null) ? 0 : cargoNome.hashCode());
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
        if (cargoNome == null) {
            if (other.cargoNome != null)
                return false;
        } else if (!cargoNome.equals(other.cargoNome))
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
