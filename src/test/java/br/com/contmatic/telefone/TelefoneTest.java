package br.com.contmatic.telefone;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class TelefoneTest.
 */
public class TelefoneTest {

    /** The telefone. */
    Telefone telefone;

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
     * Deve verificar igualdade de classes equals.
     */
    @Before
    public void deve_verificar_igualdade_de_classes_equals() {
        Telefone telefone = new Telefone("1120117414", "201", TipoTelefone.FIXO);
        Telefone telefone2 = new Telefone("1120117414", "201", TipoTelefone.FIXO);

        assertEquals(telefone, telefone2);
        assertEquals(telefone.hashCode(), telefone2.hashCode());
    }

    /**
     * Deve armazenar numero gerado automaticamente com objetos fake.
     */
    @Test
    public void deve_armazenar_numero_gerado_automaticamente_com_objetos_fake() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getNumero();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar telefone manualmente simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_telefone_manualmente_simulando_entrada_de_dados_usuario() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("22931509167");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar ramal gerado aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_ramal_gerado_aleatoriamente_com_objetos_fake() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getRamal();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar ramal simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_ramal_simulando_entrada_de_dados_usuario() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal("456");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar tipo gerado aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_tipo_gerado_aleatoriamente_com_objetos_fake() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getTipo();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar tipo manualmente simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_tipo_manualmente_simulando_entrada_de_dados_usuario() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setTipo(TipoTelefone.FIXO);
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(telefone));
    }

}
