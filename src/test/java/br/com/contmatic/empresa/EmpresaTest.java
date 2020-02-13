package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.telefone.Telefone;
import br.com.contmatic.telefone.TipoTelefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class EmpresaTest.
 */
public class EmpresaTest {

    /** The empresa. */
    Empresa empresa;

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
     * Deve comparar as classes diferentes.
     */
    @Before
    public void deve_comparar_as_classes_diferentes() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Empresa empresa2 = Fixture.from(Empresa.class).gimme("empresa");
        assertNotEquals(empresa1.hashCode(), empresa2.hashCode());
        assertNotEquals(empresa1, empresa2);
    }

    /**
     * Deve comparar as classes iguais.
     */
    @Before
    public void deve_comparar_as_classes_iguais() {
        Empresa empresa1 = new Empresa();
        Empresa empresa2 = new Empresa();
        assertEquals(empresa1.hashCode(), empresa2.hashCode());
        assertEquals(empresa1, empresa2);
    }

    /**
     * Deve comparar as classes e construtores.
     */
    @After
    public void deve_comparar_as_classes_e_construtores() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        Empresa empresa1 = new Empresa("44268730000143", "Sim Tv Assistencia", "Servir nossos clientes de forma excepcional", "Luis Carlos Ribeiro", empresa.getTelefones(), empresa.getEndereco());
        Empresa empresa2 = new Empresa("44268730000143", "Sim Tv Assistencia", "Servir nossos clientes de forma excepcional", "Luis Carlos Ribeiro", empresa.getTelefones(), empresa.getEndereco());
        Empresa empresa3 = new Empresa("44268730000143", "Sim Tv Assistencia", "Servir nossos clientes de forma excepcional", "Luis Carlos Ribeiro",
            new Telefone("1144012901", "837", TipoTelefone.FIXO), endereco);
        Empresa empresa4 = new Empresa("44268730000143", "Sim Tv Assistencia", "Servir nossos clientes de forma excepcional", "Luis Carlos Ribeiro",
            new Telefone("1144012901", "837", TipoTelefone.FIXO), endereco);

        assertEquals(empresa1, empresa2);
        assertEquals(empresa4, empresa3);

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
