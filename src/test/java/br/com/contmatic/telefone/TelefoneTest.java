package br.com.contmatic.telefone;

import static br.com.contmatic.telefone.DddsTelefone.SAO_PAULO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class TelefoneTest.
 */
public class TelefoneTest {

    /** The telefone. */
    Telefone telefone;

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
        Telefone telefone = new Telefone(SAO_PAULO, "20117414", "201", TipoTelefone.FIXO);
        Telefone telefone2 = new Telefone(SAO_PAULO, "20117414", "201", TipoTelefone.FIXO);
        assertEquals(telefone, telefone2);
        assertEquals(telefone.hashCode(), telefone2.hashCode());
    }

    /**
     * Deve armazenar ddd.
     */
    @Test
    public void deve_armazenar_ddd() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getDdd().getDdd();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar ddd nulo.
     */
    @Test
    public void deve_armazenar_ddd_nulo() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setDdd(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar numero gerado automaticamente com objetos fake.
     */
    @Test
    public void deve_armazenar_numero_gerado_automaticamente_com_objetos_fake() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getNumero();

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar numero null.
     */
    @Test
    public void deve_armazenar_numero_null() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar numero vazio.
     */
    @Test
    public void deve_armazenar_numero_vazio() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar numero invalido.
     */
    @Test
    public void deve_armazenar_numero_invalido() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("119315091677");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar numero com caractere.
     */
    @Test
    public void deve_armazenar_numero_com_caractere() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("djuffdd");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar numero com caractere e numeros.
     */
    @Test
    public void deve_armazenar_numero_com_caractere_e_numeros() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("djuffdd5897431");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar telefone manualmente simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_telefone_manualmente_simulando_entrada_de_dados_usuario() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("931509167");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar ramal gerado aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_ramal_gerado_aleatoriamente_com_objetos_fake() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getRamal();

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar ramal simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_ramal_simulando_entrada_de_dados_usuario() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal("456");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve verificar ramal nulo.
     */
    @Test
    public void deve_verificar_ramal_nulo() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve verificar ramal vazio.
     */
    @Test
    public void deve_verificar_ramal_vazio() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal("");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar tipo gerado aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_tipo_gerado_aleatoriamente_com_objetos_fake() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getTipo();

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar tipo manualmente simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_tipo_manualmente_simulando_entrada_de_dados_usuario() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setTipo(TipoTelefone.FIXO);

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve verificar tipo nulo.
     */
    @Test
    public void deve_verificar_tipo_nulo() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setTipo(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

}
