package br.com.contmatic.telefone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class TelefoneTest {

    Telefone telefone;

    ValidateAnnotations<Object> valid;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Before
    public void deve_verificar_igualdade_de_classes_hashcode() {
        Telefone telefone = new Telefone("1120117414", "201", TipoTelefone.DOMESTICO);
        Telefone telefone2 = new Telefone("1120117414", "201", TipoTelefone.DOMESTICO);

        assertEquals(telefone.hashCode(), telefone2.hashCode());
    }

    @Before
    public void deve_verificar_igualdade_de_classes_equals() {
        Telefone telefone = new Telefone("1120117414", "201", TipoTelefone.EMPRESARIAL);
        Telefone telefone2 = new Telefone("1120117414", "201", TipoTelefone.EMPRESARIAL);

        assertEquals(telefone, telefone2);
    }

    @Test
    public void deve_armazenar_numero() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getNumero();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_setar_telefone() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("11931509160");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_ramal() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getRamal();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_setar_ramal() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal("678");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_tipo() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getTipo();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_setar_tipo() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setTipo(TipoTelefone.DOMESTICO);
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

    @After
    public void nao_deve_verificar_igualdade_de_classes_hashcode() {
        Telefone telefone = new Telefone("20117414", null, TipoTelefone.DOMESTICO);
        Telefone telefone2 = new Telefone("20317414", "201", TipoTelefone.EMPRESARIAL);

        assertNotEquals(telefone.hashCode(), telefone2.hashCode());
    }

    @After
    public void nao_deve_verificar_igualdade_de_classes_equals() {
        Telefone telefone = new Telefone("20117414", "201", TipoTelefone.DOMESTICO);
        Telefone telefone2 = new Telefone("20317414", null, TipoTelefone.DOMESTICO);

        assertNotEquals(telefone, telefone2);
    }

}
