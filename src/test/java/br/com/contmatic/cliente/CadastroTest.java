package br.com.contmatic.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class CadastroTest {
    Cadastro cadastro;

    ValidateAnnotations<Object> valid;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Test
    public void deve_verificar_igualdade_de_classes_com_hashcode() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");

        assertEquals(cadastro1.hashCode(), cadastro2.hashCode());
    }

    @Test
    public void deve_verificar_igualdade_de_classes_com_equals() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        assertEquals(cadastro1, cadastro2);
    }

    @Test
    public void deve_armazenar_nome() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Marcelo Celao");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));

    }

    @Test
    public void deve_verificar_nome_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.getNome();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_verificar_se_nome_contem_numerico() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertFalse(StringUtils.isNumeric(cadastroValidator.getNome()));
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_armazenar_email() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("jogos_digitais@gmail.com");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));

    }

    @Test
    public void deve_verificar_email_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getEmail());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_armazenar_senha() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setSenha("sapinho123");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));

    }

    @Test
    public void deve_verificar_senha_not_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getSenha());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_verificar_senha_alphanumerica() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertTrue(StringUtils.isAlphanumeric(cadastroValidator.getSenha()));
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_armazenar_cpf() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.getCpf();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));

    }

    @Test
    public void deve_verificar_cpf_not_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getCpf());
        cadastroValidator.setCpf("50740457896");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }

    @Test
    public void deve_armazenar_rg() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setRg("4.881.786-78");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));

    }

    @Test
    public void deve_verificar_rg_not_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getRg());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }
}
