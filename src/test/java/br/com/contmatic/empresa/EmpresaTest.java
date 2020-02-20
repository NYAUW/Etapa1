package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.bson.Document;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class EmpresaTest.
 */
public class EmpresaTest {

    /** The empresa. */
    static Empresa empresa;

    /**
     * Set up.
     */
    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    /**
     * Deve atribuir valor é model empresa a partir do fixture.
     */
    @Before
    public void deve_atribuir_valor_é_model_empresa_a_partir_do_fixture() {
        empresa = Fixture.from(Empresa.class).gimme("empresa");
    }

    /**
     * Deve verificar construtor com dados iguais.
     */
    @Test
    public void deve_verificar_construtor_com_dados_iguais() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Empresa empresa = new Empresa("44268730000143", "Sim Tv Assistencia", "Servir nossos clientes de forma excepcional", "Luis Carlos Ribeiro", empresa1.getTelefones(), empresa1.getEndereco());
        assertNotEquals(empresa1, empresa);
    }

    /**
     * Deve comparar as classes diferentes.
     */
    @Test
    public void deve_comparar_as_classes_diferentes() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Empresa empresa2 = Fixture.from(Empresa.class).gimme("empresa");
        assertNotEquals(empresa1.hashCode(), empresa2.hashCode());
        assertNotEquals(empresa1, empresa2);
    }

    /**
     * Deve verificar construtor da classe com os mesmos dados.
     */
    @Test
    public void deve_verificar_construtor_da_classe_com_os_mesmos_dados() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        Endereco endereco = Fixture.from(Endereco.class).gimme("endereco");
        Empresa empresa = new Empresa("29685787000154", "Games Developer", "Razao Social Inserida Aqui", "Christian Schneider", telefone, endereco);
        assertEquals(empresa, empresa);
    }

    /**
     * Deve verificar igualdade de classes null.
     */
    @Test
    public void deve_verificar_igualdade_de_classes_null() {
        assertFalse(empresa.equals(null));
    }

    /**
     * Deve comparar as classes e construtores.
     */
    @Test
    public void deve_mostrar_as_classes_e_construtores_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        Set<Telefone> telefone = new HashSet<>();
        Set<Endereco> endereco = new HashSet<>();
        telefone.add(Fixture.from(Telefone.class).gimme("telefone"));
        endereco.add(Fixture.from(Endereco.class).gimme("endereco"));
        empresa.setTelefones(telefone);
        empresa.setEndereco(endereco);
        System.out.println(empresa);

    }

    /**
     * Deve conferir saida cnpj to string.
     */
    @Test
    public void deve_conferir_saida_cnpj_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("cnpj"));
    }

    /**
     * Deve conferir saida nome to string.
     */
    @Test
    public void deve_conferir_saida_nome_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("nome"));
    }

    /**
     * Deve conferir saida razao social to string.
     */
    @Test
    public void deve_conferir_saida_razao_social_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("razaoSocial"));
    }

    /**
     * Deve conferir saida proprietarios to string.
     */
    @Test
    public void deve_conferir_saida_proprietarios_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("proprietarios"));
    }

    /**
     * Deve conferir saida telefone to string.
     */
    @Test
    public void deve_conferir_saida_telefone_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("telefones"));
    }

    /**
     * Deve conferir saida endereco to string.
     */
    @Test
    public void deve_conferir_saida_endereco_to_string() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        assertTrue(empresa.toString().contains("endereco"));
    }

    /**
     * Deve validar cnpj iguais.
     */
    @Test
    public void deve_validar_cnpj_iguais() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa.setCnpj(empresa1.getCnpj());
        assertTrue(empresa1.equals(empresa1));
    }

    /**
     * Deve verificar cnpj com acentuação.
     */
    @Test
    public void deve_verificar_cnpj_com_acentuação() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa.setCnpj("34.776.170/0001-84");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar cnpj empty.
     */
    @Test
    public void deve_verificar_cnpj_empty() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa.setCnpj("");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa1.getCnpj()));
    }

    /**
     * Deve verificar cnpj nulo.
     */
    @Test
    public void deve_verificar_cnpj_nulo() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa.setCnpj(null);

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar classes iguais com novo objeto.
     */
    @Test
    public void deve_verificar_classes_iguais_com_novo_objeto() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.equals(new Object());

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar nome somente letras.
     */
    @Test
    public void deve_verificar_nome_somente_letras() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setNome("GamesTorrent");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar nome com numeros.
     */
    @Test
    public void deve_verificar_nome_com_numeros() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setNome("GamesT0rrent");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar nome null.
     */
    @Test
    public void deve_verificar_nome_null() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setNome(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar nome blank.
     */
    @Test
    public void deve_verificar_nome_blank() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setNome("");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar razao social completa.
     */
    @Test
    public void deve_verificar_razao_social_completa() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("Trabalhar Pelo Bem Comum");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar razao social com especiais.
     */
    @Test
    public void deve_verificar_razao_social_com_especiais() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("@!#@%#@$");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar razao social com especiais e numeros.
     */
    @Test
    public void deve_verificar_razao_social_com_especiais_e_numeros() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("@!#@%#@$8475869754");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar razao social com numeros.
     */
    @Test
    public void deve_verificar_razao_social_com_numeros() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("sdjksd2903839042");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar razao social com sem espaco.
     */
    @Test
    public void deve_verificar_razao_social_com_sem_espaco() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("Razaosocialsemespaco");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar razao social incompleta.
     */
    @Test
    public void deve_verificar_razao_social_incompleta() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("Trabalhar");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar razao social vazia.
     */
    @Test
    public void deve_verificar_razao_social_vazia() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial("");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar razao social nula.
     */
    @Test
    public void deve_verificar_razao_social_nula() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setRazaoSocial(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar proprietarios com entrada valida.
     */
    @Test
    public void deve_verificar_proprietarios_com_entrada_valida() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setProprietarios("Marcela Alvares Estebao");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar proprietarios vazioa.
     */
    @Test
    public void deve_verificar_proprietarios_vazioa() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setProprietarios("");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar proprietarios nulo.
     */
    @Test
    public void deve_verificar_proprietarios_nulo() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setProprietarios(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar proprietarios com entrada numerica.
     */
    @Test
    public void deve_verificar_proprietarios_com_entrada_numerica() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setProprietarios("Marc3la Estebao");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar proprietarios incompleto.
     */
    @Test
    public void deve_verificar_proprietarios_incompleto() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setProprietarios("M");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar telefone correto.
     */
    @Test
    public void deve_verificar_telefone_correto() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Set<Telefone> telefone = new HashSet<>();
        telefone.add(Fixture.from(Telefone.class).gimme("telefone"));
        empresa1.setTelefones(telefone);
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa1.getTelefones()));
    }

    /**
     * Deve verificar telefone nulo.
     */
    @Test
    public void deve_verificar_telefone_nulo() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setTelefones(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar endereco correto.
     */
    @Test
    public void deve_verificar_endereco_correto() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Set<Endereco> endereco = new HashSet<>();
        endereco.add(Fixture.from(Endereco.class).gimme("endereco"));
        empresa1.setEndereco(endereco);

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve verificar endereco nulo.
     */
    @Test
    public void deve_verificar_endereco_nulo() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        empresa1.setEndereco(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresa1));
    }

    /**
     * Deve armazenar entrada de dados telefones.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_telefones() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setTelefones(empresaValidator.getTelefones());
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaValidator.getTelefones()));
    }

    /**
     * Deve verificar cnpj valido gerado pelo objeto fake.
     */
    @Test
    public void deve_verificar_cnpj_valido_gerado_pelo_objeto_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getCnpj();

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar cnpj invalido com especiais.
     */
    @Test
    public void deve_verificar_cnpj_invalido_com_especiais() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj("#@$¨&&(!##%");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar cnpj invalido com letras e numeros.
     */
    @Test
    public void deve_verificar_cnpj_invalido_com_letras_e_numeros() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj("875853dsjfhjsg");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar cnpj invalido com numeros incompletos.
     */
    @Test
    public void deve_verificar_cnpj_invalido_com_numeros_incompletos() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj("875853");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar cnpj valido simulado com entrada de dados.
     */
    @Test
    public void deve_verificar_cnpj_valido_simulado_com_entrada_de_dados() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj("56243436000166");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar entrada nome empresa com objeto fake.
     */
    @Test
    public void deve_armazenar_entrada_nome_empresa_com_objeto_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getNome();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve setar entrada nome empresa simulando entrada do usuario.
     */
    @Test
    public void deve_setar_entrada_nome_empresa_simulando_entrada_do_usuario() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setNome("Jogos HD Gratis Torrent");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar entrada de dados razao social.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_razao_social() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setRazaoSocial("TRABALHAR PELO BEM COMUM DA SOCIEDADE");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaValidator.getRazaoSocial()));
    }

    /**
     * Deve armazenar entrada de dados razao social com especiais.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_especiais() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setRazaoSocial("TRA@$#¨&@!$");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar entrada de dados razao social com numeros letras.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_numeros_letras() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setRazaoSocial("TRA723675256745");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar entrada de dados razao social com especos apenas.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_razao_social_com_especos_apenas() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setRazaoSocial("                ");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
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

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar nome completo proprietario com numeros.
     */
    @Test
    public void deve_armazenar_nome_completo_proprietario_com_numeros() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setProprietarios("Luis Carl3os Ribeiro");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar nome completo proprietario com especiais.
     */
    @Test
    public void deve_armazenar_nome_completo_proprietario_com_especiais() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setProprietarios("Luis Carl#os Ribeiro");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar nome completo proprietario nulo.
     */
    @Test
    public void deve_armazenar_nome_completo_proprietario_nulo() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setProprietarios(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar nome completo proprietario vazio.
     */
    @Test
    public void deve_armazenar_nome_completo_proprietario_vazio() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setProprietarios("");

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar dados gerados razao social com objetos fake.
     */
    @Test
    public void deve_verificar_dados_gerados_razao_social_com_objetos_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getRazaoSocial();

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve verificar endereco gerados com objetos fake.
     */
    @Test
    public void deve_verificar_endereco_gerados_com_objetos_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaValidator.getEndereco()));
    }

    /**
     * Deve setar endereco simulando entrada de dados com objetos fake.
     */
    @Test
    public void deve_setar_endereco_simulando_entrada_de_dados_com_objetos_fake() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setEndereco(empresaValidator.getEndereco());
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    /**
     * Deve armazenar endereco nulo.
     */
    @Test
    public void deve_armazenar_endereco_nulo() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setEndereco(null);

        assertTrue(ValidateAnnotations.returnAnnotationMsgError(empresaValidator));
    }

    @AfterClass
    public static void deve_pegar_dados_gerados_no_fixture_e_jogar_no_banco_de_dados() {
        Empresa empresa = Fixture.from(Empresa.class).gimme("empresa");
        MongoClient dadosEmpresa = new MongoClient("localhost");
        MongoDatabase bancoDeDados = dadosEmpresa.getDatabase("ProjetoEtapa3");
        MongoCollection<Document> empresas = bancoDeDados.getCollection("Empresa");
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        empresas.insertOne(new Document("cnpj", empresa.getCnpj()).append("Nome da Empresa", empresa.getNome()).append("Razao Social", empresa.getRazaoSocial())
                .append("Proprietarios", empresa.getProprietarios()).append("ddd", telefone.getDdd().getDdd()).append("Numero", telefone.getNumero()));
        empresas.deleteOne()
        dadosEmpresa.close();
    }
}
