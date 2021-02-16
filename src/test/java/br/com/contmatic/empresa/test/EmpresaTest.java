package br.com.contmatic.empresa.test;

import static br.com.contmatic.constants.Regex.ALFA;
import static br.com.contmatic.constants.Regex.CNPJ;
import static br.com.contmatic.constants.Regex.NUMEROS;
import static br.com.contmatic.utils.EnderecoUtil.enderecoRandom;
import static br.com.contmatic.utils.EnderecoUtil.enderecoStatic;
import static br.com.contmatic.utils.TelefoneUtil.getTelefoneRegex;
import static br.com.contmatic.utils.TelefoneUtil.telefoneRandom;
import static br.com.contmatic.utils.TelefoneUtil.telefoneStatic;
import static br.contmatic.type.RamoAtividadeType.SERVICOS_ASSISTENCIA_TECNICA_INSTALACOES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.Empresa;
import br.com.contmatic.model.Endereco;

public class EmpresaTest {

	private static Endereco enderecoStatic = enderecoStatic();

	private static Empresa empresa;
	
	@BeforeClass
	public static void deve_instanciar_empresa() {
		empresa = new Empresa();
		empresa.setCnpj("38739416000107");
		empresa.setEndereco(enderecoStatic);
		empresa.setNome("Sim Tv Assistencia");
		empresa.setProprietario("Proprietario EmpresaTest");
		empresa.setRamoAtividade(SERVICOS_ASSISTENCIA_TECNICA_INSTALACOES);
		empresa.setRazaoSocial("Trabalhar pelo bem comum");
		empresa.setTelefone(telefoneStatic());
	}
	
	@Test
	public void devera_verificar_cnpj_null() {
		assertTrue(empresa.getCnpj() != null);
	}
	
	@Test
	public void devera_verificar_cnpj() {
		assertTrue(empresa.getCnpj().equals("38.739.416/0001.07"));
	}
	
	@Test
	public void devera_verificar_padrao_cnpj() {
		assertTrue(empresa.getCnpj().matches(CNPJ));
	}
	
	@Test
	public void devera_verificar_nome_empresa_null() {
		assertTrue(empresa.getNome() != null);
	}

	@Test
	public void devera_verificar_nome_empresa() {
		assertTrue(empresa.getNome() == "Sim Tv Assistencia");
	}
	
	@Test
	public void devera_verificar_nome_empresa_valido() {
		assertTrue(empresa.getNome().matches(ALFA));
	}

	@Test
	public void devera_verificar_igualdade_telefone() {
		assertEquals(telefoneStatic().getNumero(), empresa.getTelefone().getNumero());
	}
	
	@Test
	public void devera_verificar_igualdade_telefone_padrao() {
		assertTrue(empresa.getTelefone().getNumero()
				.matches(getTelefoneRegex(empresa.getTelefone())));
	}
	
	@Test
	public void devera_verificar_endereco_null() {
		assertTrue(empresa.getEndereco() != null);
	}


	@Test
	public void devera_verificar_endereco() {
		assertTrue(empresa.getEndereco().equals(enderecoStatic));
	}
	
	@Test
	public void devera_verificar_endereco_rua_padrao() {
		assertTrue(empresa.getEndereco().getLogradouro().matches(ALFA));
	}
	
	@Test
	public void devera_verificar_endereco_bairro_padrao() {
		assertTrue(empresa.getEndereco().getBairro().matches(ALFA));
	}
	
	@Test
	public void devera_verificar_razao_social_null() {
		assertTrue(empresa.getRazaoSocial() != null);
	}

	@Test
	public void devera_verificar_razao_social() {
		assertTrue(empresa.getRazaoSocial().equals("Trabalhar pelo bem comum"));
	}

	@Test
	public void devera_verificar_proprietario() {
		assertTrue(empresa.getProprietario().equals("Proprietario EmpresaTest"));
	}

	@Test
	public void nao_deve_verificar_cnpj() throws Exception {
		assertNotEquals(empresa.getCnpj(), "95128290000170");
	}
	
	@Test
	public void nao_deve_verificar_cnpj_padrao() throws Exception {
		assertFalse(empresa.getCnpj().matches(ALFA));
	}

	@Test
	public void nao_deve_validar_igualdade_nome_empresa() {
		assertNotEquals(empresa.getNome(), "Pastel Do Marcelão");
	}
	
	@Test
	public void nao_deve_validar_nome_empresa_null() {
		assertFalse(empresa.getNome() == null);
	}

	@Test
	public void nao_deve_verificar_igualdade_tel() throws Exception {
		assertNotEquals(empresa.getTelefone(), telefoneRandom());
	}
	
	@Test
	public void nao_deve_verificar_numero_tel_null() throws Exception {
		assertFalse(empresa.getTelefone().getNumero() == null);
	}

	@Test
	public void nao_deve_verificar_endereco_logradouro_padrao() throws Exception {
		assertFalse(empresa.getEndereco().getLogradouro().matches(NUMEROS));
	}
	
	@Test
	public void nao_deve_verificar_endereco_bairro_padrao() throws Exception {
		assertFalse(empresa.getEndereco().getBairro().matches(NUMEROS));
	}
	
	@Test
	public void nao_deve_verificar_endereco() throws Exception {
		assertNotEquals(empresa.getEndereco(), enderecoRandom());
	}

	@After
	public void nao_deve_verificar_razao_social() throws Exception {
		assertTrue(empresa != null);
	}

	@AfterClass
	public static void nao_deve_verificar_proprietario() throws Exception {
		empresa = null;
	}
}
