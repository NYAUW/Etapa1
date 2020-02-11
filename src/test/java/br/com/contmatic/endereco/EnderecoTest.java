package br.com.contmatic.endereco;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EnderecoTest {

    Endereco endereco;

    ValidateAnnotations<Object> valid;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Before
    public void deve_comparar_as_classes_com_hashcode() {
        Endereco endereco = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120", TipoEndereco.APARTAMENTO);
        Endereco endereco2 = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120", TipoEndereco.APARTAMENTO);

        assertEquals(endereco.hashCode(), endereco2.hashCode());
    }

    @Before
    public void deve_comparar_as_classes_com_equals() {
        Endereco endereco = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120", TipoEndereco.CASA);
        Endereco endereco2 = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120", TipoEndereco.CASA);

        assertEquals(endereco, endereco2);
    }

    @Test
    public void deve_armazenar_rua() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.getRua();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_setar_rua() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setRua("Rua Padre Estebao");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_armazenar_bairro() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setBairro(endereco.getBairro());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_setar_numero() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setNumero(666);
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_armazenar_numero() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.getNumero();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_regiao_not_null() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setRegiao(endereco.getRegiao());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_regiao_numerico() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setRegiao(endereco.getRegiao());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_armazenar_cep() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.getCep();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_setar_cep() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setCep("03977120");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_armazenar_tipo() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setTipo(endereco.getTipo());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }
}
