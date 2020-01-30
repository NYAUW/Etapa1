package br.com.contmatic.entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.contmatic.empresa.Funcionario;

public class FuncionarioTest {
    Funcionario funcionario = new Funcionario("Marcela Oliveira", "Atendente", 0, 1500);
    
    @Test
    public void verifica_classes_iguais_hashcode() {
        Funcionario funcionario1= new Funcionario("Marcela Oliveira", "Atendente", 0, 1500);
        Funcionario funcionario2 = new Funcionario("Marcela Oliveira", "Atendente", 0, 1500);
        
        assertEquals(funcionario1.hashCode(), funcionario2.hashCode());
    }
    
    @Test
    public void verifica_classes_iguais_equals() {
        Funcionario funcionario1= new Funcionario("Marcela Oliveira", "Atendente", 0, 1500);
        Funcionario funcionario2 = new Funcionario("Marcela Oliveira", "Atendente", 0, 1500);
        
        assertEquals(funcionario1, funcionario2);
    }
    
    @Test
    public void deve_armazenar_nome_funcionario() {
        funcionario.setNome("Marcelo Luis Pereira");
    }

    @Test
    public void deve_verificar_nome() {
        Funcionario funcionario = new Funcionario("Marcela Oliveira", "Atendente", 00000, 1500);
        assertTrue(funcionario.getNome().equals("Marcela Oliveira"));
    }

    @Test
    public void deve_verificar_cargo() {

        assertTrue(funcionario.getCargo().equals("Atendente"));
    }

    @Test
    public void deve_armazenar_codigo() {
        funcionario.setCodigo(150);
    }
    
    @Test
    public void deve_armazenar_cargo() {
        funcionario.setCargo("Atendente");
    }
    
    @Test
    public void deve_verificar_codigo_not_null() {
        assertNotNull(funcionario.getCodigo());
    }

    @Test
    public void deve_verificar_salario_nao_nulo() {
        assertNotNull(funcionario.getSalario());
    }
    
    @Test
    public void deve_armazenar_salario() {
        funcionario.setSalario(1500);
    }

    @Test
    public void deve_verificar_nome_nao_nulo() throws Exception {
        assertNotNull(funcionario.getNome());
    }
    
    @Test
    public void deve_verificar_cargo_nao_nulo() throws Exception {
        assertNotNull(funcionario.getCargo());
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_verificar_cargo() {
        funcionario.setCargo(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_armazenar_cargo_exixtente() {
        funcionario.setCargo("Faxineira");
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_armazenar_salario_nao_nulo() {
        funcionario.setSalario(0);
    }
    
    @Test(expected = NullPointerException.class)
    public void nao_deve_armazenar_nome_nulo() {
        funcionario.setNome(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_armazenar_nome_incompleto() {
        funcionario.setNome("MarcelaOliveira");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_armazenar_nome_numerico() {
        funcionario.setNome("M3rcela Olive1ra");
    }
}
