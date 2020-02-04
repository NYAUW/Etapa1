package br.com.contmatic.endereco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EnderecoTest {

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Before
    public void deve_comparar_as_classes_com_hashcode() {
        Endereco endereco = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120");
        Endereco endereco2 = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120");

        assertEquals(endereco.hashCode(), endereco2.hashCode());
    }

    @Before
    public void deve_comparar_as_classes_com_equals() {
        Endereco endereco = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120");
        Endereco endereco2 = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120");

        assertEquals(endereco, endereco2);
    }

    @Test
    public void deve_verificar_rua_not_null() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        assertTrue(StringUtils.isNotBlank(endereco.getRua()));
        endereco.setRua(endereco.getRua());
    }

    @Test
    public void deve_verificar_rua_numerico() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        assertFalse(StringUtils.isNumeric(endereco.getRua()));
    }

    @Test
    public void deve_verificar_rua_somente_caracteres() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        assertFalse(StringUtils.isAlpha(endereco.getRua()));
    }

    @Test
    public void deve_verificar_bairro_not_null() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        assertTrue(StringUtils.isNotBlank(endereco.getBairro()));
        endereco.setBairro(endereco.getBairro());
    }

    @Test
    public void deve_verificar_bairro_numerico() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        assertFalse(StringUtils.isNumeric(endereco.getBairro()));
    }

    @Test
    public void deve_verificar_se_numero_e_0() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        assertTrue(endereco.getNumero() != 0);
        endereco.setNumero(endereco.getNumero());
    }

    @Test
    public void deve_verificar_regiao_not_null() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        assertTrue(StringUtils.isNotBlank(endereco.getRegiao()));
        endereco.setRegiao(endereco.getRegiao());
    }

    @Test
    public void deve_verificar_regiao_numerico() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        assertFalse(StringUtils.isNumeric(endereco.getRegiao()));
    }

    @Test
    public void deve_verificar_cep_not_null() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        assertTrue(StringUtils.isNotBlank(endereco.getCep()));
        endereco.setCep(endereco.getCep());
    }

    @Test
    public void deve_verificar_cep_numerico() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        assertFalse(StringUtils.isAlpha(endereco.getCep()));
    }

    @Test
    public void deve_verificar_cep_somente_caracteres() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        assertFalse(endereco.getCep().length() != 8);
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_rua_null() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setRua(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_rua_numerica() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setRua("90875");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_conter_especiais_rua() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setRua("Av-Brasil");
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_receber_zero_numero() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setNumero(0);
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_bairro_null() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setBairro(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_bairro_numerico() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setBairro("3478");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_bairro_especial() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setBairro("Vila-Matilde");
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_regiao_null() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setRegiao(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_regiao_numerico() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setRegiao("2345678");
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_cep_nulo() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setCep(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cep_diferente_de_oito_digitos() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setCep("03977");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cep_especials() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setCep("03977@10");
    }

}
