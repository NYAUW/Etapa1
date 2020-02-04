package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EmpresaTest {
    Empresa empresa;

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
        empresaValidator.setCnpj("03.319.214/1679-30");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(empresaValidator.getCnpj());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
        System.out.println(armazenaLogErro);
    }

    @Test
    public void deve_verificar_cnpj_nulo() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        assertNotNull(empresaValidator.getCnpj());
    }

    @Test
    public void deve_armazenar_nome_empresa() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setNome("SIM TV ASSISTENCIA");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(empresaValidator.getNome()());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
        System.out.println(armazenaLogErro);
    }

    @Test
    public void deve_aceitar_razao_social_com_espacos() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setRazaoSocial("TRABALHAR PELO BEM COMUM DA SOCIEDADE");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(empresaValidator.getCnpj());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
        System.out.println(armazenaLogErro);
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
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(empresaValidator.getProprietarios());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
        System.out.println(armazenaLogErro);
    }

    @Test(expected = NullPointerException.class)
    public void neo_deve_retornar_cnpj_null() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_retornar_cnpj_valido() {
        Empresa empresaValidator = Fixture.from(Empresa.class).gimme("empresa");
        empresaValidator.setCnpj("03319214167930");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(empresaValidator.getCnpj());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
        System.out.println(armazenaLogErro);
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_proprietario_null() {
        empresa.setProprietarios(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_aceitar_razao_social_sem_espaco() {
        empresa.setRazaoSocial("Nenhuma");
    }
}
