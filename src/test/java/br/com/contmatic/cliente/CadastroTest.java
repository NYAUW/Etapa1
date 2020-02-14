package br.com.contmatic.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.Before;
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
    static Cadastro cadastro;

    /** The valid. */
    ValidateAnnotations<Object> valid;

    /**
     * Set up.
     */
    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Before
    public void deve_atribuir_valores_do_fixture_para_a_classe_vazia() {
        cadastro = Fixture.from(Cadastro.class).gimme("cadastro");
    }

    @Before
    public void deve_verificar_construtor_da_classe_com_os_mesmos_dados() {
        Cadastro cadastro = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        assertEquals(cadastro, cadastro);
    }

    /**
     * Deve verificar igualdade de classes com hashcode.
     */
    @AfterClass
    public static void deve_verificar_igualdade_de_classes_e_objetos() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        Cadastro cadastro2 = Fixture.from(Cadastro.class).gimme("cadastro");
        System.out.println(cadastro1);
        System.out.println(cadastro2);
        assertEquals(cadastro1.hashCode(), cadastro1.hashCode());
        assertEquals(cadastro1, cadastro1);
        assertFalse(cadastro1.equals(new Object()));
        assertFalse(cadastro1.equals(null));
        cadastro2.setCpf("50740457896");
        assertNotEquals(cadastro1, cadastro2);
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
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(cadastroValidator));

    }

    @Test
    public void deve_simuloar_entrada_usuario_no_email() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("lucas2001.789@gmail.com");
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
