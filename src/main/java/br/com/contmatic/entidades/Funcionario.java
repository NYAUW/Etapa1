package br.com.contmatic.entidades;

import java.util.MissingFormatArgumentException;

import javax.naming.InvalidNameException;

public class Funcionario {

    private static final String NUMEROS = "Numeros Encontrados";

    private static final String ENTRADAINVALIDA = "Entrada inválida";

    private static final String ENTRADANULA = "A entrada não pode ficar nula";

    private String nome;

    private String cargoNome;

    private int codigo;

    private double salario;

    public Funcionario(String nome, String cargoNome, int codigo, double salario) {
        super();
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
        verificaNomeFuncionario(nome);
        verificaNomeNumero(nome);
        try {
            verificaNomeCompleto(nome);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        this.nome = nome;
    }

    public void setCargoNome(String cargoNome) {
        verificaSelecaoCargo(cargoNome);
        this.cargoNome = cargoNome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setSalario(int salario) {
        verificaNullSalario(salario);
        this.salario = salario;
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

    private void verificaNomeFuncionario(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException(ENTRADANULA);
        }
    }

    private void verificaNomeNumero(String nome) {
        for(int i = 0 ; nome.length() > i ; i++) {
            if (Character.isDigit(nome.charAt(i))) {
                throw new IllegalArgumentException(NUMEROS);
            }
        }
    }

    private void verificaNomeCompleto(String nome) throws InvalidNameException {
        if (nome.trim().isEmpty()) {
            throw new InvalidNameException(ENTRADANULA);
        }
    }

    private void verificaSelecaoCargo(String cargoNome) {
        if ((cargoNome.equals("Atendente")) || (cargoNome.equals("Tecnico")) || (cargoNome.equals("Auxiliar"))) {
            throw new IllegalArgumentException(ENTRADAINVALIDA);
        }
    }

    private void verificaNullSalario(double salario) {
        if (salario == 0) {
            throw new MissingFormatArgumentException(ENTRADANULA);
        }
    }

}
