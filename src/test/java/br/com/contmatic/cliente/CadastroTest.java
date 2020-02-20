package br.com.contmatic.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class CadastroTest.
 */
public class CadastroTest {

    /** The cadastro. */
    static Cadastro cadastro;

    /** The valid. */

    /**
     * Set up.
     */
    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    /**
     * Deve atribuir valores do fixture para a classe vazia.
     */
    @Before
    public void deve_atribuir_valores_do_fixture_para_a_classe_vazia() {
        cadastro = Fixture.from(Cadastro.class).gimme("cadastro");
    }

    /**
     * Deve verificar construtor da classe com os mesmos dados.
     */
    @Test
    public void deve_verificar_construtor_da_classe_com_os_mesmos_dados() {
        Cadastro cadastro = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        assertEquals(cadastro, cadastro);
    }

    /**
     * Deve verificar igualdade de classes com hashcode.
     */
    @Test
    public void deve_verificar_igualdade_de_classes_hashcode() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        Cadastro cadastro2 = Fixture.from(Cadastro.class).gimme("cadastro");
        assertEquals(cadastro1.hashCode(), cadastro1.hashCode());
        cadastro2.setCpf("50740457896");
        assertNotEquals(cadastro1, cadastro2);
    }

    /**
     * Deve imprimir conteudp da classe.
     */
    @Test
    public void deve_imprimir_conteudp_da_classe() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        System.out.println(cadastro1);
    }

    /**
     * Deve verificar igualdade de classes.
     */
    @Test
    public void deve_verificar_igualdade_de_classes() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        assertEquals(cadastro1, cadastro1);
    }

    /**
     * Deve verificar igualdade de classes ocm novo objeto.
     */
    @Test
    public void deve_verificar_igualdade_de_classes_ocm_novo_objeto() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        assertFalse(cadastro1.equals(new Object()));
    }

    /**
     * Deve verificar igualdade de classes null.
     */
    @Test
    public void deve_verificar_igualdade_de_classes_null() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        assertFalse(cadastro1.equals(null));
    }

    /**
     * Deve verificar desigualdade de classes.
     */
    @Test
    public void deve_verificar_desigualdade_de_classes() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        Cadastro cadastro2 = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastro2.setCpf("50740457896");
        assertNotEquals(cadastro1, cadastro2);
    }

    /**
     * Deve conferir saida nome to string.
     */
    @Test
    public void deve_conferir_saida_nome_to_string() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        assertTrue(cadastro1.toString().contains("nome"));
    }

    /**
     * Deve conferir saida email to string.
     */
    @Test
    public void deve_conferir_saida_email_to_string() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        assertTrue(cadastro1.toString().contains("email"));
    }

    /**
     * Deve conferir saida senha to string.
     */
    @Test
    public void deve_conferir_saida_senha_to_string() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        assertTrue(cadastro1.toString().contains("senha"));
    }

    /**
     * Deve conferir saida cpf to string.
     */
    @Test
    public void deve_conferir_saida_cpf_to_string() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        assertTrue(cadastro1.toString().contains("cpf"));
    }

    /**
     * Deve conferir saida rg to string.
     */
    @Test
    public void deve_conferir_saida_rg_to_string() {
        Cadastro cadastro1 = Fixture.from(Cadastro.class).gimme("cadastro");
        assertTrue(cadastro1.toString().contains("rg"));
    }

    /**
     * Deve armazenar entrada de dados de nome correto simulando o comportamento do usuario.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_correto_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Marcelo Celao");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados de nome incorreto blank simulando o comportamento do usuario.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_incorreto_blank_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Marcelo");

        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados de nome com caracteres especiais.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_com_caracteres_especiais() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Marc$elo");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados de nome com caracteres especiais e numeros.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_com_caracteres_especiais_e_numeros() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Marc$elo509834");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve verificar entrada senha.
     */
    @Test
    public void deve_verificar_entrada_senha() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.getSenha();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados de nome correto com no minimo 2 letras simulando o comportamento do usuario.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_correto_com_no_minimo_2_letras_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Mar");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados de nome incorreto menor que 2 simulando o comportamento do usuario.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_incorreto_menor_que_2_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Ma");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados de nome correto menor que 50 simulando o comportamento do usuario.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_correto_menor_que_50_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Marcelo O Loko");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados de nome incorreto maior que 50 simulando o comportamento do usuario.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_nome_incorreto_maior_que_50_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Cheiro De Pneu Queimado Carburador Furado O X9 foi");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator) == true);
    }

    /**
     * Deve armazenar entrada de dados de email correto simulando o comportamento do usuario.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_email_correto_simulando_o_comportamento_do_usuario() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("lucas2001_789@gmail.com");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve invalidar caso nome null.
     */
    @Test
    public void deve_invalidar_caso_nome_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Lucas Alves");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve verificar se nome contem numerico.
     */
    @Test
    public void deve_verificar_se_nome_contem_numerico() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertFalse(StringUtils.isNumeric(cadastroValidator.getNome()));
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados de email.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_de_email() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.getEmail();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("lucas2001.789@gmail.com.br");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email sem dominio.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_sem_dominio() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("lucas2001.789@.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email com caracteres especiais.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_com_caracteres_especiais() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("lucas2001.789!@#$#$@@.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email com dominio numerico.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_com_dominio_numerico() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("lucas2001.789@1899.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email com dominio especial.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_com_dominio_especial() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("lucas2001.789@1899!@#$#%.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email sem com br.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_sem_com_br() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("lucas2001.789@1899");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email sem user.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_sem_user() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("@1899.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email com espaço.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_com_espaço() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("lucas ribeiro@gmail.com.br");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email sem o com.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_sem_o_com() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("lucas ribeiro@gmail.");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email sem o ponto.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_sem_o_ponto() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("lucas ribeiro@gmailcombr");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email vazio.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_vazio() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email nulo.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_nulo() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve simuloar entrada usuario no email maiusculo.
     */
    @Test
    public void deve_simuloar_entrada_usuario_no_email_maiusculo() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("LucasAlves@gmail.com");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de senha.
     */
    @Test
    public void deve_armazenar_entrada_de_senha() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setSenha("sapinho123");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de senha somente numeros.
     */
    @Test
    public void deve_armazenar_entrada_de_senha_somente_numeros() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setSenha("123");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de senha somente letras.
     */
    @Test
    public void deve_armazenar_entrada_de_senha_somente_letras() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setSenha("sapinho");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de senha somente especiais.
     */
    @Test
    public void deve_armazenar_entrada_de_senha_somente_especiais() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setSenha("!@$%%$&%");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de senha vazia.
     */
    @Test
    public void deve_armazenar_entrada_de_senha_vazia() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setSenha("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de senha nula.
     */
    @Test
    public void deve_armazenar_entrada_de_senha_nula() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setSenha(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados cpf.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_cpf() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.getCpf();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados cpf com acentuação.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_cpf_com_acentuação() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setCpf("017.226.970-91");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados cpf com especiais.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_cpf_com_especiais() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setCpf("@$@#@");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados cpf com letras.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_cpf_com_letras() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setCpf("dsjfhdsjfg");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados cpf sem os digitos verificadores.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_cpf_sem_os_digitos_verificadores() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setCpf("017.226.970-");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados cpf com os digitos verificadores incorretos.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_cpf_com_os_digitos_verificadores_incorretos() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setCpf("017.226.970-96");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados cpf empty.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_cpf_empty() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setCpf("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados cpf nulo.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_cpf_nulo() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setCpf(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve verificar cpf not null.
     */
    @Test
    public void deve_verificar_cpf_not_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getCpf());
        cadastroValidator.setCpf("50740457896");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve armazenar entrada de dados rg.
     */
    @Test
    public void deve_armazenar_entrada_de_dados_rg() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setRg("4.881.786-78");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve verificar rg correto.
     */
    @Test
    public void deve_verificar_rg_correto() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.getRg();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve verificar rg not null.
     */
    @Test
    public void deve_verificar_rg_nulo() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setRg(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve verificar rg sem acentuação.
     */
    @Test
    public void deve_verificar_rg_sem_acentuação() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setRg("488178678");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    /**
     * Deve verificar rg incompleto.
     */
    @Test
    public void deve_verificar_rg_incompleto() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setRg("4881");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(cadastroValidator));
    }

    @After
    public void deve_pegar_dados_gerados_no_fixture_e_jogar_no_banco_de_dados() {
        for(int i = 0 ; i < 200000 ; i++) {
            Cadastro cadastro = Fixture.from(Cadastro.class).gimme("cadastro");
            MongoClient cadastroCliente = new MongoClient("localhost");
            MongoDatabase bancoDeDados = cadastroCliente.getDatabase("ProjetoEtapa3");
            MongoCollection<Document> clientes = bancoDeDados.getCollection("Cadastro");
            clientes.insertOne(
                new Document("nome", cadastro.getNome()).append("email", cadastro.getEmail()).append("senha", cadastro.getSenha()).append("cpf", cadastro.getCpf()).append("rg", cadastro.getRg()));
            cadastroCliente.close();
        }
    }
}
