package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

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
    @Test
    public void verifica_classes_iguais_hashcode() {
        Funcionario funcionario1 = new Funcionario("Marcela Oliveira", "Atendente", 0, new BigDecimal("5000.00"));
        Funcionario funcionario2 = new Funcionario("Marcela Oliveira", "Atendente", 0, new BigDecimal("5000.00"));

        assertEquals(funcionario1.hashCode(), funcionario2.hashCode());
    }

    /**
     * Verifica classes iguais equals.
     */
    @Test
    public void verifica_classes_iguais_equals() {
        Funcionario funcionario1 = new Funcionario("Marcela Oliveira", "Atendente", 0, new BigDecimal("5000.00"));
        Funcionario funcionario2 = new Funcionario("Marcela Oliveira", "Atendente", 0, new BigDecimal("5000.00"));

        assertEquals(funcionario1, funcionario2);
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
    public void deve_verificar_cargo_simulando_entrada_de_dados_do_usuario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Tecnico");
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
        System.out.println(funcionario.getSalario());
        funcionario.setSalario(new BigDecimal("5000.00"));
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }
}
