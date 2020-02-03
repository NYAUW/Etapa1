package br.com.contmatic.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class OrcamentoTest {
    
    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Before
    public void deve_verificar_igualdade_classes_hashcode() {
        Orcamento orcamento = new Orcamento("Sony", "HYT367", "Nao Liga");
        Orcamento orcamento2 = new Orcamento("Sony", "HYT367", "Nao Liga");

        assertEquals(orcamento.hashCode(), orcamento2.hashCode());
    }

    @Before
    public void deve_verificar_igualdade_classes_equals() {
        Orcamento orcamento = new Orcamento("Sony", "HYT367", "Nao Liga");
        Orcamento orcamento2 = new Orcamento("Sony", "HYT367", "Nao Liga");

        assertEquals(orcamento, orcamento2);
    }

    @Test
    public void deve_verificvar_marca_not_null() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertNotNull(orcamento.getMarca());
    }

    @Test
    public void deve_verificar_marca_numerica() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertTrue(StringUtils.isAlpha(orcamento.getMarca()));
    }

    @Test
    public void deve_verificar_serial_nulo() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertNotNull(orcamento.getSerial());
    }

    @Test
    public void deve_verificar_defeito_null() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertNotNull(orcamento.getDefeito());
    }

    @Test
    public void deve_setar_marca() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamento.setMarca("Sony");
    }
    
    @Test
    public void deve_setar_serial() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamento.setSerial("JDK789");
    }
    
    @Test
    public void deve_setar_defeito() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamento.setDefeito("Nao Liga");
    }
    
    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_marca_nula() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamento.setMarca(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_marca_numerica() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamento.setMarca("2003");
    }
    
    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_serial_nula() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamento.setSerial(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_defeito_incompleto() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamento.setDefeito("NaoConEcta");
    }
    
    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_defeito_nulo() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamento.setDefeito(null);
    }

}
