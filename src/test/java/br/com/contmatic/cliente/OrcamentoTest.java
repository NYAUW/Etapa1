package br.com.contmatic.cliente;

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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class OrcamentoTest {

    Orcamento orcamento;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Before
    public void deve_verificar_igualdade_classes_hashcode() {
        Orcamento orcamento = new Orcamento("Sony", "HYT367", "Nao Liga");
        Orcamento orcamento2 = new Orcamento("Sony", "HYT367", "Nao Liga");

        assertEquals(orcamento.hashCode(), orcamento2.hashCode());
    }

    @Before
    public void deve_verificar_igualdade_classes_equals() {
        Orcamento orcamento = new Orcamento("Sony", "HYT367", "Nao Liga");
        Orcamento orcamento2 = new Orcamento("Sony", "HYT367", "Nao Liga");

        assertEquals(orcamento, orcamento2);
    }

    @Test
    public void deve_verificvar_marca_not_null() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertNotNull(orcamento.getMarca());
    }

    @Test
    public void deve_verificar_marca_numerica() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertTrue(StringUtils.isAlpha(orcamento.getMarca()));
    }

    @Test
    public void deve_verificar_serial_nulo() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertNotNull(orcamento.getSerial());
    }

    @Test
    public void deve_verificar_defeito_null() {
        Orcamento orcamento = Fixture.from(Orcamento.class).gimme("orcamento");
        assertNotNull(orcamento.getDefeito());
    }

    @Test
    public void deve_setar_marca() {
        Orcamento orcamentoValidator = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamentoValidator.setMarca("Sony");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(orcamentoValidator.getMarca());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
    }

    @Test
    public void deve_setar_serial() {
        Orcamento orcamentoValidator = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamentoValidator.setSerial("JDK456");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(orcamentoValidator.getSerial());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
    }

    @Test
    public void deve_setar_defeito() {
        Orcamento orcamentoValidator = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamentoValidator.setDefeito("Aparelho não liga");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(orcamentoValidator.getDefeito());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_marca_nula() {
        Orcamento orcamentoValidator = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamentoValidator.setMarca(null);
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(orcamentoValidator.getMarca());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_serial_nula() {
        Orcamento orcamentoValidator = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamentoValidator.setSerial(null);
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(orcamentoValidator.getSerial());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_defeito_incompleto() {
        Orcamento orcamentoValidator = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamentoValidator.setDefeito("NaoConecta");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(orcamentoValidator.getDefeito());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_defeito_nulo() {
        Orcamento orcamentoValidator = Fixture.from(Orcamento.class).gimme("orcamento");
        orcamentoValidator.setDefeito(null);
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(orcamentoValidator.getDefeito());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));
    }

}
