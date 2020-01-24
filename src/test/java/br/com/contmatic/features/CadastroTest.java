package br.com.contmatic.features;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CadastroTest {
    Cadastro cadastro = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875", "Rua Fada Selvagem 234", "20156787");
    Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875", "Rua Fada Selvagem 234", "20156787");

    @Test
    public void deve_verificar_nome() {
        assertTrue(cadastro.getNome().equals("Jose Garcia"));
    }

    @Test
    public void deve_verificar_email() {
        assertTrue(cadastro.getEmail().equals("jose.garcia@gmail.com"));
    }

    @Test
    public void deve_verificar_senha() {
        assertTrue(cadastro.getSenha().equals("sapinho123"));
    }

    @Test
    public void deve_verificar_cpf() {
        assertTrue(cadastro.getCpf().equals("46720276539"));
    }

    @Test
    public void deve_verificar_rg() {
        assertTrue(cadastro.getRg().equals("657849875"));
    }

    @Test
    public void deve_verificar_endereco() {
        assertTrue(cadastro.getEndereco().equals("Rua Fada Selvagem 234"));
    }

    @Test
    public void deve_verificar_telefone() {
        assertTrue(cadastro.getTel().equals("20156787"));
    }
    
    @Test
    public void nao_deve_verificar_nome() throws Exception {
        cadastro2.setNome("Jose Paulo");
        String nome = cadastro2.getNome();
        assertNotEquals(cadastro.getNome(), nome);
    }

    @Test
    public void nao_deve_verificar_email() throws Exception {
        cadastro2.setEmail("jose.garcia@hotmail.com");
        String email = cadastro2.getEmail();
        assertNotEquals(cadastro.getEmail(), email);
    }

    @Test
    public void nao_deve_verificar_senha() {
        cadastro2.setSenha("2Unicornios");
        String senha = cadastro2.getSenha();
        assertNotEquals(cadastro.getSenha(), senha);
    }

    @Test
    public void nao_deve_verificar_cpf() throws Exception {
        cadastro2.setCpf("50740457896");
        String cpf = cadastro2.getCpf();
        assertNotEquals(cadastro.getCpf(), cpf);
    }

    @Test
    public void nao_deve_verificar_rg() {
        cadastro2.setRg("957849885");
        String rg = cadastro2.getRg();
        assertNotEquals(cadastro.getRg(), rg);
    }

    @Test
    public void nao_deve_verificar_endereco() throws Exception {
        cadastro2.setEndereco("Rua Para de Chover");
        String endereco = cadastro2.getEndereco();
        assertNotEquals(cadastro.getRg(), endereco);
    }

    @Test
    public void nao_deve_verificar_telefone() {
        cadastro2.setTel("44012901");
        String tel = cadastro2.getTel();
        assertNotEquals(cadastro.getTel(), tel);
    }
}
