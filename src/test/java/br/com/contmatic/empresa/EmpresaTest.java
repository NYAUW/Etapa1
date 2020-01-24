package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmpresaTest {
    private Empresa empresa = new Empresa("95128290000160", "Sim Tv Assistencia", "44012901", "Av Eduardo Prado 385", "Trabalhar pelo bem comum", "Luis Carlos Ribeiro");
    private Empresa empresa2 = new Empresa("95128290000160", "Sim Tv Assistencia", "44012901", "Av Eduardo Prado 385", "Trabalhar pelo bem comum", "Luis Carlos Ribeiro");

    @Test
    public void devera_verificar_cnpj() throws Exception {
        String cnpj = "95128290000160";
        empresa.setCnpj(cnpj);
        assertTrue(empresa.getCnpj().equals(cnpj));
    }

    @Test
    public void devera_verificar_nome_empresa() {
        assertTrue(empresa.getNome().equals("Sim Tv Assistencia"));
    }

    @Test
    public void devera_verificar_tel() {
        assertEquals("44012901", empresa.getTelefone());
    }

    @Test
    public void devera_verificar_endereco() {
        assertTrue(empresa.getEndereco().equals("Av Eduardo Prado 385"));
    }

    @Test
    public void devera_verificar_razao_social() {
        assertTrue(empresa.getRazaoSocial().equals("Trabalhar pelo bem comum"));
    }

    @Test
    public void devera_verificar_proprietario() {
        assertTrue(empresa.getProprietarios().equals("Luis Carlos Ribeiro"));
    }

    @Test
    public void nao_deve_verificar_cnpj() throws Exception {
        empresa2.setCnpj("95128290000170");
        assertNotEquals(empresa2.getCnpj(), empresa.getCnpj());
    }

    @Test
    public void nao_deve_verificar_nome_empresa() {
        empresa2.setNome("Pastel Do Marcelão");
        assertNotEquals(empresa2.getNome(), empresa.getNome());
    }

    @Test
    public void nao_deve_verificar_tel() throws Exception {
        empresa2.setTelefone("20117414");
        assertNotEquals(empresa2.getTelefone(), empresa.getTelefone());
    }

    @Test
    public void nao_deve_verificar_endereco() throws Exception {
        empresa2.setEndereco("Av Itamarati 345");
        assertNotEquals(empresa2.getEndereco(), empresa.getEndereco());
    }

    @Test
    public void nao_deve_verificar_razao_social() throws Exception {
        empresa2.setRazaoSocial("Deixar nossos clientes satisfeitos com nossos serviços");
        ;
        assertNotEquals(empresa2.getRazaoSocial(), empresa.getRazaoSocial());
    }
    
    @Test
    public void nao_deve_verificar_proprietario() throws Exception {
        empresa2.setProprietarios("Luis Carlos");
        assertNotEquals(empresa2.getProprietarios(), empresa.getProprietarios());
    }
}
