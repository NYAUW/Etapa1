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

public class EmpresaTest {
    Empresa empresa;

    ValidateAnnotations<Object> valid;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Before
    public void deve_comparar_as_classes_diferentes() {
        Empresa empresa1 = Fixture.from(Empresa.class).gimme("empresa");
        Empresa empresa2 = Fixture.from(Empresa.class).gimme("empresa");
        assertNotEquals(empresa1.hashCode(), empresa2.hashCode());
        assertNotEquals(empresa1, empresa2);
    }

    @Before
    public void deve_comparar_as_classes_iguais() {
        Empresa empresa1 = new Empresa();
        Empresa empresa2 = new Empresa();
        assertEquals(empresa1.hashCode(), empresa2.hashCode());
        assertEquals(empresa1, empresa2);
    }

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

    @Test
    public void deve_setar_telefones() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setTelefones(empresaValidator.getTelefones());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_verificar_cnpj_valido() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj(empresaValidator.getCnpj());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));

    }

    @Test
    public void deve_armazenar_nome_empresa() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setNome(empresaValidator.getNome());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_setar_razao_social() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setRazaoSocial("TRABALHAR PELO BEM COMUM DA SOCIEDADE");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_aceitar_nulo_proprietario() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        assertNotNull(empresaValidator.getProprietarios());
    }

    @Test
    public void deve_armazenar_nome_completo_proprietario() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setProprietarios("Luis Carlos Ribeiro");
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_armazenar_razao_social() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getRazaoSocial();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_armazenar_endereco() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.getEndereco();
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }

    @Test
    public void deve_setar_endereco() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setEndereco(empresaValidator.getEndereco());
        valid = new ValidateAnnotations<>();
        System.out.println(valid.returnAnnotationMsgError(empresaValidator));
    }
}
