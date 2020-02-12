package br.com.contmatic.telefone;

import static org.junit.Assert.assertEquals;

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
    public void deve_verificar_igualdade_de_classes_equals() {
        Telefone telefone = new Telefone("1120117414", "201", TipoTelefone.FIXO);
        Telefone telefone2 = new Telefone("1120117414", "201", TipoTelefone.FIXO);

        assertEquals(telefone, telefone2);
        assertEquals(telefone.hashCode(), telefone2.hashCode());
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
        telefone.setNumero("11931509167");
        ;
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
        telefone.setRamal("456");
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
        telefone.setTipo(TipoTelefone.FIXO);
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

}
