package br.com.contmatic.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class OrcamentoTest.
 */
public class OrcamentoTest {

    /** The orcamento. */
    Orcamento orcamento;

    /** The date time. */
    DateTime dateTime = DateTime.now();

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
     * Deve verificar igualdade classes hashcode.
     */
    @Before
    public void deve_verificar_igualdade_classes_hashcode() {
        Orcamento orcamento = new Orcamento("Sony", "HYT367", "Nao Liga", dateTime);
        Orcamento orcamento2 = new Orcamento("Sony", "HYT367", "Nao Liga", dateTime);

        assertEquals(orcamento.hashCode(), orcamento2.hashCode());
    }

    /**
     * Deve verificar igualdade classes equals.
     */
    @Before
    public void deve_verificar_igualdade_classes_equals() {
        Orcamento orcamento = new Orcamento("Sony", "HYT367", "Nao Liga", dateTime);
        Orcamento orcamento2 = new Orcamento("Sony", "HYT367", "Nao Liga", dateTime);

        assertEquals(orcamento, orcamento2);
    }

    /**
     * Deve verificvar marca not null.
     */
    @Test
    public void deve_verificvar_marca_not_null() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertNotNull(orcamento.getMarca());
        orcamento.setMarca(orcamento.getMarca());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(orcamento));
    }

    /**
     * Deve verificar marca numerica.
     */
    @Test
    public void deve_verificar_marca_numerica() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertTrue(StringUtils.isAlpha(orcamento.getMarca()));
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(orcamento));
    }

    /**
     * Deve verificar serial nulo.
     */
    @Test
    public void deve_verificar_serial_nulo() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertNotNull(orcamento.getSerial());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(orcamento));
    }

    /**
     * Deve verificar defeito null.
     */
    @Test
    public void deve_verificar_defeito_null() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertNotNull(orcamento.getDefeito());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(orcamento));
    }

    /**
     * Deve setar marca.
     */
    @Test
    public void deve_setar_marca() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamento.setMarca("Sony");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(orcamento));
    }

    /**
     * Deve setar serial.
     */
    @Test
    public void deve_setar_serial() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamento.setSerial("ABC973");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(orcamento));
    }

    /**
     * Deve setar defeito.
     */
    @Test
    public void deve_setar_defeito() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamento.setDefeito("Aparelho Nao Liga");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(orcamento));
    }

}
