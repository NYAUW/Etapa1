package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EmpresaTest {
    Empresa empresa;

    ValidateAnnotations<Object> valid;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Test
    public void deve_comparar_as_classes_com_hashcode() {
        Empresa empresa1 = new Empresa("95128290000160", "Sim Tv Assistencia", "Trabalhar pelo bem comum", "Luis Carlos Ribeiro");
        Empresa empresa2 = new Empresa("95128290000160", "Sim Tv Assistencia", "Trabalhar pelo bem comum", "Luis Carlos Ribeiro");
        assertEquals(empresa1.hashCode(), empresa2.hashCode());

    }

    @Test
    public void deve_comparar_as_classes_com_equals() {
        Empresa empresa1 = new Empresa("95128290000160", "Sim Tv Assistencia", "Trabalhar pelo bem comum", "Luis Carlos Ribeiro");
        Empresa empresa2 = new Empresa("95128290000160", "Sim Tv Assistencia", "Trabalhar pelo bem comum", "Luis Carlos Ribeiro");
        assertEquals(empresa1, empresa2);
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
}
