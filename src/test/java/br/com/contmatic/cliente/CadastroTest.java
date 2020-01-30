package br.com.contmatic.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class CadastroTest {
    Cadastro cadastro = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875", "Rua Fada Selvagem 234");

    @Test
    public void deve_verificar_igualdade_de_classes_com_hashcode() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875", "Rua Fada Selvagem 234");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875", "Rua Fada Selvagem 234");

        assertEquals(cadastro1.hashCode(), cadastro2.hashCode());
    }
    
    @Test
    public void deve_verificar_igualdade_de_classes_com_equals() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875", "Rua Fada Selvagem 234");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875", "Rua Fada Selvagem 234");

        assertEquals(cadastro1, cadastro2);
    }

    @Test
    public void deve_armazenar_nome_cliente() {
        cadastro.setNome("Jose Garcia");
    }

    @Test
    public void deve_verificar_nome_null() {
        assertNotNull(cadastro.getNome());
    }

    @Test
    public void deve_verificar_se_nome_contem_numerico() {
        assertFalse(StringUtils.isNumeric(cadastro.getNome()));
    }

    @Test
    public void deve_armazenar_email() {
        cadastro.setEmail("jose.garcia@gmail.com");
    }
    
    @Test
    public void deve_verificar_email_null() {
        assertNotNull(cadastro.getEmail());
    }
    
    @Test
    public void deve_armazenar_senha() {
        cadastro.setSenha("sapinho123");
    }
    
    @Test
    public void deve_verificar_senha_not_null() {
        assertNotNull(cadastro.getSenha());
    }
    
    @Test
    public void deve_verificar_senha_alphanumerica() {
        assertTrue(StringUtils.isAlphanumeric(cadastro.getSenha()));
    }

    @Test
    public void deve_armazenar_cpf() {
        cadastro.setCpf("50740457896");
    }
    
    @Test
    public void deve_verificar_cpf_not_null() {
        assertNotNull(cadastro.getCpf());
    }
    
    @Test
    public void deve_verificar_cpf_somente_numerico() {
        assertTrue(StringUtils.isNumeric(cadastro.getCpf()));
    }

    @Test
    public void deve_armazenar_rg() {
        cadastro.setRg("488178678");
    }
    
    @Test
    public void deve_verificar_rg_not_null() {
        assertNotNull(cadastro.getRg());
    }
    
    @Test
    public void dece_verificar_se_rg_contem_apenas_numericos() {
        assertTrue(StringUtils.isNumeric(cadastro.getRg()));
    }

    @Test
    public void deve_armazenar_endereco() {
        cadastro.setEndereco("Rua Highway To Hell 666");
    }
    
    @Test
    public void deve_verificar_endereco_not_null() {
        assertNotNull(cadastro.getEndereco());
    }
    
    @Test(expected = AssertionError.class)
    public void nao_deve_verificar_igualdade_de_classes_com_hashcode() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875", "Rua Fada Selvagem 234");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@hotmail.com", "sapinho123", "46720276539", "657849875", "Rua Fada Selvagem 234");

        assertEquals(cadastro1.hashCode(), cadastro2.hashCode());
    }
    
    @Test(expected = AssertionError.class)
    public void nao_deve_verificar_igualdade_de_classes_com_equals() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875", "Rua Fada Selvagem 234");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@hotmail.com", "sapinho123", "46720276539", "657849875", "Rua Fada Selvagem 234");

        assertEquals(cadastro1, cadastro2);
    }
    
    @Test(expected = NullPointerException.class)
    public void nao_deve_validar_nome_null() {
        cadastro.setNome(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_nome_numerico() {
        cadastro.setNome("J0se Bonif4cio");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_nome_com_especiais() {
        cadastro.setNome("J@se Bon!facio");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_nome_sem_espaco() {
        cadastro.setNome("JoseBonifacio");
    }
    
    @Test(expected = NullPointerException.class)
    public void neo_deve_validar_email_nulo() {
        cadastro.setEmail(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_email_sem_dominio() {
        cadastro.setEmail("jose.bonifacio@.com");
    }
    
    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_cpf_null() {
        cadastro.setCpf(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_menos_de_quatorze_caracteres() {
        cadastro.setCpf("507404");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_caracteres() {
        cadastro.setCpf("507.404.578");
    }
    
    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_rg_nulo() {
        cadastro.setRg(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_rg_caractere() {
        cadastro.setRg("488.8678");
    }
   
    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_endereco_nulo() {
        cadastro.setEndereco(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_endereco_caractere() {
        cadastro.setEndereco("Rua H!ghway to Hell 666");
    }
    
    @Test(expected = NullPointerException.class)
    public void  nao_deve_aceitar_senha_nula() {
        cadastro.setSenha(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_senha_pequena() {
        cadastro.setSenha("123");
    }
}
