package br.com.contmatic.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class CadastroTest {
    Cadastro cadastro;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Test
    public void deve_verificar_igualdade_de_classes_com_hashcode() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875");

        assertEquals(cadastro1.hashCode(), cadastro2.hashCode());
    }

    @Test
    public void deve_verificar_igualdade_de_classes_com_equals() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875");
        assertEquals(cadastro1, cadastro2);
    }

    @Test
    public void deve_armazenar_nome() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setNome("Marcio Jose");
    }

    @Test
    public void deve_verificar_nome_null() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(user.getNome());
    }

    @Test
    public void deve_verificar_se_nome_contem_numerico() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        assertFalse(StringUtils.isNumeric(user.getNome()));
    }

    @Test
    public void deve_armazenar_email() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setEmail("jose.garcia@gmail.com");
    }

    @Test
    public void deve_verificar_email_null() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(user.getEmail());
    }

    @Test
    public void deve_armazenar_senha() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setSenha("sapinho123");
    }

    @Test
    public void deve_verificar_senha_not_null() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(user.getSenha());
    }

    @Test
    public void deve_verificar_senha_alphanumerica() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        assertTrue(StringUtils.isAlphanumeric(user.getSenha()));
    }

    @Test
    public void deve_armazenar_cpf() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setCpf("50740457896");
    }

    @Test
    public void deve_verificar_cpf_not_null() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(user.getCpf());
    }

    @Test
    public void deve_verificar_cpf_somente_numerico() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        assertTrue(StringUtils.isNumeric(user.getCpf()));
    }

    @Test
    public void deve_armazenar_rg() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setRg("488178678");
    }

    @Test
    public void deve_verificar_rg_not_null() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(user.getRg());
    }

    @Test
    public void dece_verificar_se_rg_contem_apenas_numericos() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        assertTrue(StringUtils.isNumeric(user.getRg()));
    }

    @Test(expected = AssertionError.class)
    public void nao_deve_verificar_igualdade_de_classes_com_hashcode() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@hotmail.com", "sapinho123", "46720276539", "657849875");

        assertEquals(cadastro1.hashCode(), cadastro2.hashCode());
    }

    @Test(expected = AssertionError.class)
    public void nao_deve_verificar_igualdade_de_classes_com_equals() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@hotmail.com", "sapinho123", "46720276539", "657849875");

        assertEquals(cadastro1, cadastro2);
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_validar_nome_null() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setNome(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_nome_numerico() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setNome("J0se Bonif4cio");
    }

    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_nome_com_especiais() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setNome("J@se Bon!facio");
    }

    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_nome_sem_espaco() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setNome("JoseBonifacio");
    }

    @Test(expected = NullPointerException.class)
    public void neo_deve_validar_email_nulo() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setEmail(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_email_sem_dominio() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setEmail("jose.bonifacio@.com");
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_cpf_null() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setCpf(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_menos_de_quatorze_caracteres() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setCpf("507404");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_caracteres() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setCpf("507.404.578");
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_rg_nulo() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setRg(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_rg_caractere() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setRg("488.8678");
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_senha_nula() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setSenha(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_senha_pequena() {
        Cadastro user = Fixture.from(Cadastro.class).gimme("cadastro");
        user.setSenha("123");
    }
}
