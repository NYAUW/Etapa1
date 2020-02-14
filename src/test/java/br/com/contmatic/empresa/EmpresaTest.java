package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class EmpresaTest.
 */
public class EmpresaTest {

    /** The empresa. */
    static Empresa empresa;

    /** The valid. */
    ValidateAnnotations<Object> valid;

    /**
     * Set up.
     */
    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Before
    public void deve_verificar_construtor_com_dados_iguais() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Empresa empresa = new Empresa("44268730000143", "Sim Tv Assistencia", "Servir nossos clientes de forma excepcional", "Luis Carlos Ribeiro", empresa1.getTelefones(), empresa1.getEndereco());
        assertEquals(empresa, empresa);
    }

    /**
     * Deve comparar as classes diferentes.
     */
    @Before
    public void deve_comparar_as_classes_diferentes() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Empresa empresa2 = Fixture.from(Empresa.class).gimme("empresa");
        assertNotEquals(empresa1.hashCode(), empresa2.hashCode());
        assertNotEquals(empresa1, empresa2);
    }

    @Before
    public void deve_verificar_construtor_da_classe_com_os_mesmos_dados() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        Empresa empresa = new Empresa("29685787000154", "Games Developer", "Razao Social Inserida Aqui", "Christian Schneider", telefone, endereco);
        assertEquals(empresa, empresa);
    }

    @BeforeClass
    public static void deve_atribuir_valor_é_model_empresa_a_partir_do_fixture() {
        empresa = Fixture.from(Empresa.class).gimme("empresa");
    }

    /**
     * Deve comparar as classes iguais.
     */

    @Before
    public void tetsteToString() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        Set<Telefone> telefone = new HashSet<>();
        telefone.add(Fixture.from(Telefone.class).gimme("telefone"));
        empresaValidator.setTelefones(telefone);
    }

    /**
     * Deve comparar as classes e construtores.
     */
    @After
    public void deve_comparar_as_classes_e_construtores() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        Set<Telefone> telefone = new HashSet<>();
        Set<Endereco> endereco = new HashSet<>();
        telefone.add(Fixture.from(Telefone.class).gimme("telefone"));
        endereco.add(Fixture.from(Endereco.class).gimme("endereco"));
        empresa.setTelefones(telefone);
        empresa.setEndereco(endereco);
        System.out.println(empresa);

    }

    @Test
    public void deve_validar_cnpj_iguais() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa.setCnpj(empresa1.getCnpj());

        assertTrue(empresa1.equals(empresa1));
    }

    @Test
    public void deve_verificar_se_empresa_contem_dados_nulos() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertFalse(empresa.equals(null));
    }

    @Test
    public void deve_verificar_classes_igua() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        assertFalse(empresa1.equals(new Object()));
    }

    /**
     * Deve armazenar entrada de dados telefones.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_telefones() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setTelefones(empresaValidator.getTelefones());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar cnpj valido gerado pelo objeto fake.
     */
    @Test
    public void deve_verificar_cnpj_valido_gerado_pelo_objeto_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getCnpj();
        System.out.println(empresaValidator.getTelefones());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));

    }

    /**
     * Deve verificar cnpj valido simulado com entrada de dados.
     */
    @Test
    public void deve_verificar_cnpj_valido_simulado_com_entrada_de_dados() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj("56243436000166");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));

    }

    /**
     * Deve armazenar entrada nome empresa com objeto fake.
     */
    @Test
    public void deve_armazenar_entrada_nome_empresa_com_objeto_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getNome();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_setar_entrada_nome_empresa_simulando_entrada_do_usuario() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setNome("Jogos HD Gratis Torrent");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar entrada de dados razao social.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_razao_social() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setRazaoSocial("TRABALHAR PELO BEM COMUM DA SOCIEDADE");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve aceitar entrada proprietario not null gerado com objeto fake.
     */
    @Test
    public void deve_aceitar_entrada_proprietario_not_null_gerado_com_objeto_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        assertNotNull(empresaValidator.getProprietarios());
    }

    /**
     * Deve armazenar nome completo proprietario simulado com entrada de dados.
     */
    @Test
    public void deve_armazenar_nome_completo_proprietario_simulado_com_entrada_de_dados() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setProprietarios("Luis Carlos Ribeiro");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar dados gerados razao social com objetos fake.
     */
    @Test
    public void deve_verificar_dados_gerados_razao_social_com_objetos_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getRazaoSocial();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar endereco gerados com objetos fake.
     */
    @Test
    public void deve_verificar_endereco_gerados_com_objetos_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getEndereco();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve setar endereco simulando entrada de dados com objetos fake.
     */
    @Test
    public void deve_setar_endereco_simulando_entrada_de_dados_com_objetos_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setEndereco(empresaValidator.getEndereco());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }
}
