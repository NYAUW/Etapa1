package br.com.contmatic.entidades;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FuncionarioTest {
    Funcionario funcionario = new Funcionario("Marcela Oliveira", "Atendente", 0, 1500);
    Funcionario funcionario2 = new Funcionario("Marcela Oliveira", "Atendente", 0, 1500);

    @Test
    public void deve_verificar_nome() {
        Funcionario funcionario = new Funcionario("Marcela Oliveira", "Atendente", 00000, 1500);
        assertTrue(funcionario.getNome().equals("Marcela Oliveira"));
    }

    @Test
    public void deve_verificar_cargo() {

        assertTrue(funcionario.getCargoNome().equals("Atendente"));
    }

    @Test
    public void deve_gerar_e_verificar_codigo() {
        funcionario.setCodigo(funcionario2.getNome().hashCode());
        funcionario2.setCodigo(funcionario.getNome().hashCode());
        assertTrue(funcionario2.getCodigo() == funcionario.getCodigo());
        assertTrue(funcionario.equals(funcionario2));
    }

    @Test
    public void deve_verificar_salario() {
        assertTrue(funcionario.getSalario() == funcionario2.getSalario());
    }

    @Test
    public void nao_deve_verificar_nome() throws Exception {
        funcionario.setNome("Jose Paulo");
        String nome = funcionario2.getNome();
        assertNotEquals(funcionario.getNome(), nome);
    }

    @Test
    public void nao_deve_verificar_cargo() {
        funcionario.setCargoNome("Atenden");
        String cargo = funcionario2.getCargoNome();
        assertNotEquals(funcionario.getCargoNome(), cargo);
    }

    @Test
    public void nao_deve_verificar_salario() {
        funcionario.setSalario(2000);
        double cargo = funcionario2.getSalario();
        assertNotEquals(funcionario.getSalario(), cargo);
    }

    @Test
    public void nao_deve_verificar_codigo() {
        funcionario.setCodigo(funcionario.getNome().hashCode());
        assertNotEquals(funcionario.getCodigo(), funcionario2.getCodigo());
    }
}
