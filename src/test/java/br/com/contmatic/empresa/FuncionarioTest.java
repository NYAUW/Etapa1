package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class FuncionarioTest.
 */
public class FuncionarioTest {

    /** The funcionario. */
    Funcionario funcionario;

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
     * Verifica classes iguais hashcode.
     */
    @Before
    public void verifica_classes_iguais_hashcode() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        System.out.println(funcionario);
        assertEquals(funcionario.hashCode(), funcionario.hashCode());

    }

    @Before
    public void deve_comparar_dados_do_construtor() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals(funcionario, funcionario);
    }

    @Before
    public void deve_verificar_se_a_classe_contem_dados_nulos() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertFalse(funcionario.equals(null));
    }

    @Before
    public void deve_comparar_objetos_da_classe() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertFalse(funcionario.equals(new Object()));
    }

    @Before
    public void deve_verificar_classes_iguais() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertEquals(funcionario, funcionario);
    }

    @Before
    public void deve_verificar_classes_iguais_com_equals() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        Funcionario funcionario2 = Fixture.from(Funcionario.class).gimme("funcionario");

        assertNotEquals(funcionario, funcionario2);
    }

    @Before
    public void deve_verificar_objeto_das_classes() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        Funcionario funcionario2 = Fixture.from(Funcionario.class).gimme("funcionario");
        assertNotEquals(funcionario, funcionario2);
    }

    /**
     * Deve verificar nome simulando entrada de dados do usuario.
     */
    @Test
    public void deve_verificar_nome_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("Marcelao Alves");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar nome gerado com objetos fake.
     */
    @Test
    public void deve_verificar_nome_gerado_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getNome();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar cargo gerados com objetos fake.
     */
    @Test
    public void deve_verificar_cargo_gerados_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getCargo();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar cargo simulando entrada de dados do usuario.
     */
    @Test
    public void deve_verificar_cargo_tecnico_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Tecnico");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_atendente_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Atendente");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_verificar_cargo_auxiliar_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Auxiliar");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve armazenar codigo simulado com entrada de dados.
     */
    @Test
    public void deve_armazenar_codigo_simulado_com_entrada_de_dados() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCodigo(234);
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve armazenar codigo gerados aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_codigo_gerados_aleatoriamente_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getCodigo();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve armazenar salario gerado com objetos fake.
     */
    @Test
    public void deve_armazenar_salario_gerado_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getSalario();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve setar salario simulando entrada de dados.
     */
    @Test
    public void deve_setar_salario_simulando_entrada_de_dados() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setSalario(new BigDecimal("5000.00"));
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }
}
