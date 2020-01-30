package br.com.contmatic.empresa;

import org.apache.commons.lang3.StringUtils;

public class Funcionario {

    private static final String NUMEROS = "Numeros Encontrados";

    private static final String ENTRADA_INVALIDA = "Entrada inválida";

    private static final String ENTRADA_NULA = "A entrada não pode ficar nula";

    private String nome;

    private String cargo;

    private int codigo;

    private double salario;

    public Funcionario(String nome, String cargo, int codigo, double salario) {
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
        verificaNomeNuloFuncionario(nome);
        verificaNomeCompleto(nome);
        verificaNomeNumero(nome);
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        verificaSeCargoENull(cargo);
        verificaSelecaoCargo(cargo);
        this.cargo = cargo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setSalario(int salario) {
        verificaNullSalario(salario);
        this.salario = salario;
    }

    private void verificaNomeNuloFuncionario(String nome) {
        if (StringUtils.isEmpty(nome)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaNomeNumero(String nome) {
        for(int i = 0; nome.length() > i; i++) {
            if (Character.isDigit(nome.charAt(i))) {
                throw new IllegalArgumentException(NUMEROS);
            }
         }
    }

    private void verificaNomeCompleto(String nome) {
        if (!StringUtils.containsWhitespace(nome)) {
            throw new IllegalArgumentException(ENTRADA_NULA);
        }
    }

    private void verificaSelecaoCargo(String cargo) {
        if (!(cargo.equals("Atendente")) || (cargo.equals("Tecnico")) || (cargo.equals("Auxiliar"))) {
            throw new IllegalArgumentException(ENTRADA_INVALIDA);
        }
    }

    private void verificaSeCargoENull(String cargo) {
        if (StringUtils.isEmpty(cargo)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaNullSalario(double salario) {
        if (salario == 0) {
            throw new NullPointerException(ENTRADA_NULA);
        }
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
