package br.com.contmatic.telefone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class TelefoneTest {
    
    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }
    
    @Before
    public void deve_verificar_igualdade_de_classes_hashcode() {
        Telefone telefone = new Telefone("20117414", "201", "Domestico");
        Telefone telefone2 = new Telefone("20117414", "201", "Domestico");
        
        assertEquals(telefone.hashCode(), telefone2.hashCode());
    }
    
    @Before
    public void deve_verificar_igualdade_de_classes_equals() {
        Telefone telefone = new Telefone("20117414", "201", "Domestico");
        Telefone telefone2 = new Telefone("20117414", "201", "Domestico");
        
        assertEquals(telefone, telefone2);
    }

    @Test
    public void deve_verficar_numero_numerico() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        assertTrue(StringUtils.isNumeric(telefone.getNumero()));
    }

    @Test
    public void deve_verificar_se_numero_e_null() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        assertNotNull(telefone.getNumero());
    }

    @Test
    public void deve_verificar_ramal_numerico() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        assertTrue(StringUtils.isNumeric(telefone.getRamal()));
    }
    
    @Test public void deve_verificar_ramal_null(){
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        assertNotNull(telefone.getRamal());
    }
    
    @Test public void deve_verificar_tipo_null() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        assertNotNull(telefone.getTipo());
    }
    
    @Test
    public void deve_armazenar_ramal() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal("201");
    }
    
    @Test
    public void deve_armazenar_numero() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("44012901");
    }
    
    @Test
    public void deve_armazenar_tipo() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setTipo("Empresarial");
    }
    
    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_telefone_null() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_telefone_alfanumerico() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("abc");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_telefone_com_caracteres() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("2011'7414");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ramal_com_caracteres() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal("bca");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ramal_com_menos_de_tres_caracteres() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal("12");
    }
    
    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_ramal_com_menos_ou_mais_de_tres_digitos() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_tipo_com_numeros() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setTipo("489458334");
    }
    
    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_tipo_null() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setTipo(null);
    }
    
    @After
    public void nao_deve_verificar_igualdade_de_classes_hashcode() {
        Telefone telefone = new Telefone("20117414", null, "Domestico");
        Telefone telefone2 = new Telefone("20317414", "201", "Domestico");
        
        assertNotEquals(telefone.hashCode(), telefone2.hashCode());
    }
    
    @After
    public void nao_deve_verificar_igualdade_de_classes_equals() {
        Telefone telefone = new Telefone("20117414", "201", "Domestico");
        Telefone telefone2 = new Telefone("20317414", null, "Domestico");
        
        assertNotEquals(telefone, telefone2);
    }

}
