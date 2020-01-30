package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

public class EmpresaTest {
    private static Empresa empresa = new Empresa("95128290000160", "Sim Tv Assistencia", "Trabalhar pelo bem comum", Arrays.asList("Luis Carlos Ribeiro"));
    
    @Test
    public void deve_comparar_as_classes_com_hashcode() {
        Empresa empresa1 = new Empresa("95128290000160", "Sim Tv Assistencia", "Trabalhar pelo bem comum", Arrays.asList("Luis Carlos Ribeiro"));
        Empresa empresa2 = new Empresa("95128290000160", "Sim Tv Assistencia", "Trabalhar pelo bem comum", Arrays.asList("Luis Carlos Ribeiro"));
        assertEquals(empresa1.hashCode(), empresa2.hashCode());
    }
    
    @Test
    public void deve_comparar_as_classes_com_equals() {
        Empresa empresa1 = new Empresa("95128290000160", "Sim Tv Assistencia", "Trabalhar pelo bem comum", Arrays.asList("Luis Carlos Ribeiro"));
        Empresa empresa2 = new Empresa("95128290000160", "Sim Tv Assistencia", "Trabalhar pelo bem comum", Arrays.asList("Luis Carlos Ribeiro"));
        assertEquals(empresa1, empresa2);
    }
    
    @Test
    public void deve_verificar_caracteres_cnpj() {
        assertEquals("00000000000000".length(), empresa.getCnpj().length());
    }
    
    @Test
    public void deve_verificar_cnpj_valido() {
        empresa.setCnpj("95128290000160");
    }

    @Test
    public void deve_verificar_cnpj_nulo() {
        assertNotNull(empresa.getCnpj());
    }

    @Before
    public void deve_verificar_nome_empresa() {
        assertTrue(StringUtils.equals("Sim Tv Assistencia", empresa.getNome()));
    }

    @Test
    public void deve_verificar_razao_social() {
        assertTrue(StringUtils.equals("Trabalhar Pelo Bem Comum", empresa.getRazaoSocial()));
    }
    
    @Test
    public void deve_armazenar_nome_empresa() {
        empresa.setNome("Sim Tv Assistencia");
    }
    
    @Test
    public void deve_aceitar_razao_social_com_espacos() {
        empresa.setRazaoSocial("Trabalhar Pelo Bem Comum");
    }

    @Test
    public void deve_aceitar_nulo_proprietario() {
        assertNotNull(empresa.getProprietarios());
    }
    
    @Test
    public void deve_armazenar_nome_completo_proprietario() {
        empresa.setProprietarios(Arrays.asList("Luis Carlos Ribeiro"));
    }
   

    @Test(expected = NullPointerException.class)
    public void neo_deve_retornar_cnpj_null() {
        empresa.setCnpj(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_retornar_cnpj_valido() {
        empresa.setCnpj("38098467729");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_validar_cnpj_com_especiais() {
        empresa.setCnpj("9512@290000160");
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_proprietario_null() {
        empresa.setProprietarios(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_aceitar_razao_social_sem_espaco() {
        empresa.setRazaoSocial("Nenhuma");
    }
}
