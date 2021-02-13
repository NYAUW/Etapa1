package br.com.contmatic.empresa.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.Empresa;
import br.com.contmatic.model.Endereco;
import br.com.contmatic.utils.EnderecoUtil;
import br.com.contmatic.utils.TelefoneUtil;
import br.contmatic.type.RamoAtividadeType;

public class EmpresaTest {

	private static final Endereco ENDERECO = EnderecoUtil.enderecoStatic();

	private static Empresa empresa = new Empresa("95128290000160", "Sim Tv Assistencia", TelefoneUtil.telefoneStatic(),
			ENDERECO, "Trabalhar pelo bem comum", RamoAtividadeType.SERVICOS_ASSISTENCIA_TECNICA_INSTALACOES, "Luis Carlos Ribeiro");

	@BeforeClass
	public static void devera_verificar_cnpj() throws Exception {
		assertTrue(empresa.getCnpj().equals("95128290000160"));
	}

	@Before
	public void devera_verificar_nome_empresa() {
		assertTrue(empresa.getNome().equals("Sim Tv Assistencia"));
	}

	@Test
	public void devera_verificar_tel() {
		assertEquals(TelefoneUtil.telefoneStatic(), empresa.getTelefone());
	}

	@Test
	public void devera_verificar_endereco() {
		assertTrue(empresa.getEndereco().equals(ENDERECO));
	}

	@Test
	public void devera_verificar_razao_social() {
		assertTrue(empresa.getRazaoSocial().equals("Trabalhar pelo bem comum"));
	}

	@Test
	public void devera_verificar_proprietario() {
		assertTrue(empresa.getProprietario().equals("Luis Carlos Ribeiro"));
	}

	@Test
	public void nao_deve_verificar_cnpj() throws Exception {
		assertNotEquals(empresa.getCnpj(), "95128290000170");
	}

	@Test
	public void nao_deve_verificar_nome_empresa() {
		assertNotEquals(empresa.getNome(), "Pastel Do Marcelão");
	}

	@Test
	public void nao_deve_verificar_tel() throws Exception {
		assertNotEquals(empresa.getTelefone(), TelefoneUtil.telefoneRandom());
	}

	@Test
	public void nao_deve_verificar_endereco() throws Exception {
		assertNotEquals(empresa.getEndereco(), EnderecoUtil.enderecoRandom());
	}

	@After
	public void nao_deve_verificar_razao_social() throws Exception {
		assertNotEquals(empresa.getRazaoSocial(), "Deixar nossos clientes satisfeitos com nossos serviços");
	}

	@AfterClass
	public static void nao_deve_verificar_proprietario() throws Exception {
		assertNotEquals(empresa.getProprietario(), "Teste Proprietario");
	}
}
