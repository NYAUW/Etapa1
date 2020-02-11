package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class FuncionarioTest {
    Funcionario funcionario;

    ValidateAnnotations<Object> valid;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Test
    public void verifica_classes_iguais_hashcode() {
        Funcionario funcionario1 = new Funcionario("Marcela Oliveira", "Atendente", 0, 1500);
        Funcionario funcionario2 = new Funcionario("Marcela Oliveira", "Atendente", 0, 1500);

        assertEquals(funcionario1.hashCode(), funcionario2.hashCode());
    }

    @Test
    public void verifica_classes_iguais_equals() {
        Funcionario funcionario1 = new Funcionario("Marcela Oliveira", "Atendente", 0, 1500);
        Funcionario funcionario2 = new Funcionario("Marcela Oliveira", "Atendente", 0, 1500);

        assertEquals(funcionario1, funcionario2);
    }

    @Test
    public void deve_setar_nome() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setNome("Marcelao Alves");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_armazenar_nome() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getNome();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_armazenar_cargo() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getCargo();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_setar_cargo() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCargo("Tecnico");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_setar_codigo() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setCodigo(234);
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_armazenar_codigo() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getCodigo();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_armazenar_salario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.getSalario();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }

    @Test
    public void deve_setar_salario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("funcionario");
        funcionario.setSalario(2500);
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(funcionario));
    }
}
