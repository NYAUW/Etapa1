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

/**
 * The Class CadastroTest.
 */
public class CadastroTest {

    /** The cadastro. */
    Cadastro cadastro;

    /** The valid. */
    ValidateAnnotations<Object> valid;

    /**
     * Set up.
     */
    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    /**
     * Deve verificar igualdade de classes com hashcode.
     */
    @Test
    public void deve_verificar_igualdade_de_classes_com_hashcode() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        assertEquals(cadastro1.hashCode(), cadastro2.hashCode());
    }

    /**
     * Deve verificar igualdade de classes com equals.
     */
    @Test
    public void deve_verificar_igualdade_de_classes_com_equals() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        assertEquals(cadastro1, cadastro2);
    }

    /**
     * Deve armazenar entrada de dados de nome correto simulando o comportamento do usuario.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_correto_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Marcelo Celao");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));

    }

    /**
     * Deve invalidar caso nome null.
     */
    @Test
    public void deve_invalidar_caso_nome_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Lucas Alves");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve verificar se nome contem numerico.
     */
    @Test
    public void deve_verificar_se_nome_contem_numerico() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertFalse(StringUtils.isNumeric(cadastroValidator.getNome()));
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados de email.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_email() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.getEmail();
        System.out.println(cadastroValidator.getEmail());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));

    }

    /**
     * Deve invalidar caso email seja null.
     */
    @Test
    public void deve_invalidar_caso_email_seja_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getEmail());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de senha.
     */
    @Test
    public void deve_armazenar_entrada_de_senha() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setSenha("sapinho123");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));

    }

    /**
     * Deve verificar senha alphanumerica.
     */
    @Test
    public void deve_verificar_senha_alphanumerica() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertTrue(StringUtils.isAlphanumeric(cadastroValidator.getSenha()));
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados cpf.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_cpf() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.getCpf();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));

    }

    /**
     * Deve verificar cpf not null.
     */
    @Test
    public void deve_verificar_cpf_not_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getCpf());
        cadastroValidator.setCpf("50740457896");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados rg.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_rg() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setRg("4.881.786-78");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));

    }

    /**
     * Deve verificar rg not null.
     */
    @Test
    public void deve_verificar_rg_not_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getRg());
        valid = new ValidateAnnotations<>();
    }
}
