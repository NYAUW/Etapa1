package br.com.contmatic.endereco;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class EnderecoTest.
 */
public class EnderecoTest {

    /** The endereco. */
    Endereco endereco;

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
     * Deve comparar as classes com hashcode.
     */
    @Before
    public void deve_comparar_as_classes_com_hashcode() {
        Endereco endereco = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120", TipoEndereco.APARTAMENTO);
        Endereco endereco2 = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120", TipoEndereco.APARTAMENTO);

        assertEquals(endereco.hashCode(), endereco2.hashCode());
    }

    /**
     * Deve comparar as classes com equals.
     */
    @Before
    public void deve_comparar_as_classes_com_equals() {
        Endereco endereco = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120", TipoEndereco.CASA);
        Endereco endereco2 = new Endereco("Rua Fada Magica", 289, "Vila Ema", "Grande ABC", "03977120", TipoEndereco.CASA);

        assertEquals(endereco, endereco2);
    }

    /**
     * Deve armazenar rua gerada aleatoriamente com os objetos fake.
     */
    @Test
    public void deve_armazenar_rua_gerada_aleatoriamente_com_os_objetos_fake() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.getRua();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar rua simulando entrada de dados do usuario.
     */
    @Test
    public void deve_armazenar_rua_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setRua("Rua Padre Estebao");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar bairro gerado com objetos fake.
     */
    @Test
    public void deve_armazenar_bairro_gerado_com_objetos_fake() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.getBairro();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar bairro simulando entrada de dados do usuario.
     */
    @Test
    public void deve_armazenar_bairro_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setBairro("Vila Ema");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve setar numero simulando entrada de dados do usuario.
     */
    @Test
    public void deve_setar_numero_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setNumero(666);
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar numero gerado aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_numero_gerado_aleatoriamente_com_objetos_fake() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.getNumero();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve verificar regiao simulando entrada de dados usuario.
     */
    @Test
    public void deve_verificar_regiao_simulando_entrada_de_dados_usuario() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setRegiao("Zona Leste");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar regiao gerado com objetos fake.
     */
    @Test
    public void deve_armazenar_regiao_gerado_com_objetos_fake() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.getRegiao();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar cep gerado automaricamente com objetos fake.
     */
    @Test
    public void deve_armazenar_cep_gerado_automaricamente_com_objetos_fake() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.getCep();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve setar cep simulando entrada de dados do usuario.
     */
    @Test
    public void deve_setar_cep_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setCep("03977120");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar tipo gerado sorteado com objetos fake.
     */
    @Test
    public void deve_armazenar_tipo_gerado_sorteado_com_objetos_fake() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.getTipo();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar tipo setado diretamente simulando entrada de dados do usuario.
     */
    @Test
    public void deve_armazenar_tipo_setado_diretamente_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        endereco.setTipo(TipoEndereco.CASA);
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(endereco));
    }
}
