package br.com.contmatic.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

public class CadastroTest {
    Cadastro cadastro;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    @Test
    public void deve_verificar_igualdade_de_classes_com_hashcode() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");

        assertEquals(cadastro1.hashCode(), cadastro2.hashCode());
    }

    @Test
    public void deve_verificar_igualdade_de_classes_com_equals() {
        Cadastro cadastro1 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        Cadastro cadastro2 = new Cadastro("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "467.202.765-39", "6.578.498-75");
        assertEquals(cadastro1, cadastro2);
    }

    @Test
    public void deve_armazenar_nome() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("Jose Garia");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getNome());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test
    public void deve_verificar_nome_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getNome());
    }

    @Test
    public void deve_verificar_se_nome_contem_numerico() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertFalse(StringUtils.isNumeric(cadastroValidator.getNome()));
    }

    @Test
    public void deve_armazenar_email() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("joaodasda@hotmail.com");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getEmail());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test
    public void deve_verificar_email_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getEmail());
    }

    @Test
    public void deve_armazenar_senha() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setSenha("sapinho123");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getSenha());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test
    public void deve_verificar_senha_not_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getSenha());
    }

    @Test
    public void deve_verificar_senha_alphanumerica() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertTrue(StringUtils.isAlphanumeric(cadastroValidator.getSenha()));
    }

    @Test
    public void deve_armazenar_cpf() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setCpf("507.404.578-967");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getCpf());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test
    public void deve_verificar_cpf_not_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getCpf());
    }

    @Test
    public void deve_armazenar_rg() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setRg("4.881.786-78");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getRg());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test
    public void deve_verificar_rg_not_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        assertNotNull(cadastroValidator.getRg());
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_validar_nome_null() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome(null);
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getNome());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_nome_numerico() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("J0se Bonif4cio");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getNome());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_nome_com_especiais() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("J@se Bon!facio");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getNome());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_nome_sem_espaco() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setNome("JoseBonifacio");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getNome());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test(expected = NullPointerException.class)
    public void neo_deve_validar_email_nulo() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail(null);
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getEmail());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void neo_deve_validar_email_sem_dominio() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setEmail("jose.bonifacio@.com");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getEmail());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_menos_de_quatorze_caracteres() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setCpf("507404");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getCpf());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_rg_nulo() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setRg(null);
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getRg());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_rg_caractere() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setRg("488867889-96");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getRg());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_senha_nula() {
        Cadastro cadastroValidator = Fixture.from(Cadastro.class).gimme("cadastro");
        cadastroValidator.setSenha(null);
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<String>> erros = validador.validate(cadastroValidator.getSenha());
        List<String> armazenaLogErro = new ArrayList<String>();
        erros.stream().forEach(log -> armazenaLogErro.add(log.getMessage()));

    }
}
