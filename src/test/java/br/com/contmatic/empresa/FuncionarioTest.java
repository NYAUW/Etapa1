package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class FuncionarioTest.
 */
public class FuncionarioTest {

    /** The funcionario. */
    Funcionario funcionario;

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
    @Test
    public void verifica_classes_iguais_hashcode() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        System.out.println(funcionario);
        assertEquals(funcionario.hashCode(), funcionario.hashCode());
    }

    /**
     * Deve mostrar conteudo da classe.
     */
    @Test
    public void deve_mostrar_conteudo_da_classe() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        System.out.println(funcionario);
    }

    /**
     * Deve verificar nome to string.
     */
    @Test
    public void deve_verificar_nome_to_string() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertTrue(funcionario.toString().contains("nome"));
    }

    /**
     * Deve verificar cargo to string.
     */
    @Test
    public void deve_verificar_cargo_to_string() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertTrue(funcionario.toString().contains("cargo"));
    }

    /**
     * Deve verificar codigo to string.
     */
    @Test
    public void deve_verificar_codigo_to_string() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertTrue(funcionario.toString().contains("codigo"));
    }

    /**
     * Deve verificar salario to string.
     */
    @Test
    public void deve_verificar_salario_to_string() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertTrue(funcionario.toString().contains("salario"));
    }

    /**
     * Deve comparar dados do construtor.
     */
    @Test
    public void deve_comparar_dados_do_construtor() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals(funcionario, funcionario);
    }

    /**
     * Deve verificar se a classe contem dados nulos.
     */
    @Test
    public void deve_verificar_se_a_classe_contem_dados_nulos() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertFalse(funcionario.equals(null));
    }

    /**
     * Deve comparar objetos da classe.
     */
    @Test
    public void deve_comparar_objetos_da_classe() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertFalse(funcionario.equals(new Object()));
    }

    /**
     * Deve verificar classes iguais.
     */
    @Test
    public void deve_verificar_classes_iguais() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertEquals(funcionario, funcionario);
    }

    /**
     * Deve verificar classes iguais com equals.
     */
    @Test
    public void deve_verificar_classes_iguais_com_equals() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        Funcionario funcionario2 = Fixture.from(Funcionario.class).gimme("funcionario");

        assertNotEquals(funcionario, funcionario2);
    }

    /**
     * Deve verificar objeto das classes.
     */
    @Test
    public void deve_verificar_objeto_das_classes() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Tecnico");
        Funcionario funcionario2 = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario2.setCargo("Auxiliar");
        assertNotEquals(funcionario, funcionario2);
    }

    /**
     * Deve conferir saida nome to string.
     */
    @Test
    public void deve_conferir_saida_nome_to_string() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals("Lucas Alves Ribeiro", funcionario.getNome());
    }

    /**
     * Deve conferir saida cargo to string.
     */
    @Test
    public void deve_conferir_saida_cargo_to_string() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals("Auxiliar", funcionario.getCargo());
    }

    /**
     * Deve conferir saida codigo to string.
     */
    @Test
    public void deve_conferir_saida_codigo_to_string() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals(234, funcionario.getCodigo());
    }

    /**
     * Deve conferir saida salario to string.
     */
    @Test
    public void deve_conferir_saida_salario_to_string() {
        Funcionario funcionario = new Funcionario("Lucas Alves Ribeiro", "Auxiliar", 234, new BigDecimal("3000.00"));
        assertEquals(new BigDecimal("3000.00"), funcionario.getSalario());
    }

    /**
     * Deve verificar nome simulando entrada de dados do usuario.
     */
    @Test
    public void deve_verificar_nome_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("Marcelao Alves");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar nome incompleto.
     */
    @Test
    public void deve_verificar_nome_incompleto() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("M");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar nome com entrada numerica.
     */
    @Test
    public void deve_verificar_nome_com_entrada_numerica() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("Marcel4o Alves");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar nome com entrada blank.
     */
    @Test
    public void deve_verificar_nome_com_entrada_blank() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar nome com entrada nula.
     */
    @Test
    public void deve_verificar_nome_com_entrada_nula() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar nome com entrada especial.
     */
    @Test
    public void deve_verificar_nome_com_entrada_especial() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("$#@&*%$#@");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar nome com entrada somente numeros.
     */
    @Test
    public void deve_verificar_nome_com_entrada_somente_numeros() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("39407894065");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar nome gerado com objetos fake.
     */
    @Test
    public void deve_verificar_nome_gerado_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getNome();

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar cargo gerados com objetos fake.
     */
    @Test
    public void deve_verificar_cargo_gerados_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getCargo();

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar cargo simulando entrada de dados do usuario.
     */
    @Test
    public void deve_verificar_cargo_tecnico_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Tecnico");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getCargo()));
    }

    /**
     * Deve verificar cargo atendente simulando entrada de dados do usuario.
     */
    @Test
    public void deve_verificar_cargo_atendente_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Atendente");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar cargo auxiliar simulando entrada de dados do usuario.
     */
    @Test
    public void deve_verificar_cargo_auxiliar_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Auxiliar");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar cargo nuloo.
     */
    @Test
    public void deve_verificar_cargo_nuloo() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar cargo vazio.
     */
    @Test
    public void deve_verificar_cargo_vazio() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar cargo numerico.
     */
    @Test
    public void deve_verificar_cargo_numerico() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("9043879");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar cargo especiais.
     */
    @Test
    public void deve_verificar_cargo_especiais() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("$#@!");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve armazenar codigo simulado com entrada de dados.
     */
    @Test
    public void deve_armazenar_codigo_simulado_com_entrada_de_dados() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCodigo(234);

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve verificar codigo 0.
     */
    @Test
    public void deve_verificar_codigo_0() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCodigo(0);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve armazenar codigo gerados aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_codigo_gerados_aleatoriamente_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getCodigo()));
    }

    /**
     * Deve armazenar salario gerado com objetos fake.
     */
    @Test
    public void deve_armazenar_salario_gerado_com_objetos_fake() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario.getSalario()));
    }

    /**
     * Deve setar salario simulando entrada de dados.
     */
    @Test
    public void deve_setar_salario_simulando_entrada_de_dados() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setSalario(new BigDecimal("3200.00"));

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }

    /**
     * Deve setar salario nulo.
     */
    @Test
    public void deve_setar_salario_nulo() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setSalario(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(funcionario));
    }
}
