package br.com.contmatic.empresa.test;

import static br.com.contmatic.constants.Regex.ALFA;
import static br.com.contmatic.constants.Regex.NUMEROS;
import static br.com.contmatic.utils.EnderecoUtil.enderecoStatic;
import static br.com.contmatic.utils.TelefoneUtil.getTelefoneRegex;
import static br.com.contmatic.utils.TelefoneUtil.telefoneStatic;
import static br.contmatic.type.RamoAtividadeType.SERVICOS_ASSISTENCIA_TECNICA_INSTALACOES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.Empresa;
import br.com.contmatic.model.Endereco;
import br.com.contmatic.model.Usuario;
import br.com.contmatic.validate.ValidateAnnotations;

public class EmpresaTest {

	private static Endereco enderecoStatic = enderecoStatic();

	private static Empresa empresa;

	private ValidateAnnotations<Object> valid = new ValidateAnnotations<>();

//	@BeforeClass
//    public static void setUp() {
//        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
//    }
//
	@Before
	public void deve_atribuir_valores_do_fixture_para_a_classe_vazia() {
		valid.setClasse(Empresa.class);
		empresa.setCnpj("38739416000107");
		empresa.setEndereco(enderecoStatic);
		empresa.setNomeFantasia("Sim Tv Assistencia");
		empresa.setProprietario("Proprietario EmpresaTest");
		empresa.setRamoAtividade(SERVICOS_ASSISTENCIA_TECNICA_INSTALACOES);
		empresa.setRazaoSocial("Trabalhar pelo bem comum");
		empresa.setTelefone(telefoneStatic());
		empresa.setCreatedDate(new Date());
		empresa.setLastModifiedDate(new Date());
	}

	@BeforeClass
	public static void deve_instanciar_empresa() {
		empresa = new Empresa();
		Usuario usuario = new Usuario();
		usuario.setCpf("89111745053");
		empresa.setCnpj("38739416000107");
		empresa.setEndereco(enderecoStatic);
		empresa.setNomeFantasia("Sim Tv Assistencia");
		empresa.setProprietario("Proprietario EmpresaTest");
		empresa.setRamoAtividade(SERVICOS_ASSISTENCIA_TECNICA_INSTALACOES);
		empresa.setRazaoSocial("Trabalhar pelo bem comum");
		empresa.setTelefone(telefoneStatic());
		empresa.setCreatedBy(usuario);
		empresa.setCreatedDate(new Date());
		empresa.setLastModifiedBy(usuario);
		empresa.setLastModifiedDate(new Date());
	}

	@Test
	public void deve_verificar_cnpj_invalido() {
		empresa.setCnpj("11111111111111");
		assertTrue(valid.isFieldInvalid(empresa, "CNPJ inválido"));
	}

	@Test
	public void deve_verificar_cnpj_vazio() {
		empresa.setCnpj("");
		assertTrue(valid.isFieldInvalid(empresa, "O CNPJ não pode ser vazio"));
	}

	@Test
	public void deve_verificar_nome_fantasia_vazio() {
		empresa.setNomeFantasia("");
		assertTrue(valid.isFieldInvalid(empresa, "O nome fantasia não pode estar vazio"));
	}

	@Test
	public void deve_verificar_nome_fantasia_invalido_2_caracteres() {
		empresa.setNomeFantasia("a");
		assertTrue(valid.isFieldInvalid(empresa, "O nome fantasia deve ter entre 2 e 60 caracteres"));
	}

	@Test
	public void deve_verificar_nome_fantasia_invalido_60_caracteres() {
		empresa.setNomeFantasia(
				"Aqui sera necessario conter mais de 60 caracteres para que o teste possa passar com êxito");
		assertTrue(valid.isFieldInvalid(empresa, "O nome fantasia deve ter entre 2 e 60 caracteres"));
	}

	@Test
	public void deve_verificar_telefone_null_invalido() {
		empresa.setTelefone(null);
		assertTrue(valid.isFieldInvalid(empresa, "O telefone não foi definido"));
	}

	@Test
	public void deve_verificar_endereco_null_invalido() {
		empresa.setEndereco(null);
		assertTrue(valid.isFieldInvalid(empresa, "O endereço não foi defnido"));
	}

	@Test
	public void deve_verificar_razao_social_vaizo() {
		empresa.setRazaoSocial("");
		assertTrue(valid.isFieldInvalid(empresa, "A razão social não pode ficar vazia"));
	}

	@Test
	public void deve_verificar_razao_social_invalido_2_caracteres() {
		empresa.setRazaoSocial("a");
		assertTrue(valid.isFieldInvalid(empresa, "A razão social deve ter entre 2 e 80 caracteres"));
	}

	@Test
	public void deve_verificar_razao_social_invalido_80_caracteres() {
		empresa.setRazaoSocial(
				"a razao social deve conter mair de 80 caracteres para esse teste em especifico conseguir ser concluido com êxito");
		assertTrue(valid.isFieldInvalid(empresa, "A razão social deve ter entre 2 e 80 caracteres"));
	}

	@Test
	public void deve_verificar_ramo_atividade_null() {
		empresa.setRamoAtividade(null);
		assertTrue(valid.isFieldInvalid(empresa, "O ramo de atividade não foi deifinido"));
	}

	@Test
	public void deve_verificar_nome_proprietario_vazio() {
		empresa.setProprietario("");
		assertTrue(valid.isFieldInvalid(empresa, "O nome do proprietario não pode ser vazio"));
	}

	@Test
	public void deve_verificar_nome_proprietario_null() {
		empresa.setProprietario(null);
		assertTrue(valid.isFieldInvalid(empresa, "O nome do proprietario não pode ser vazio"));
	}

	@Test
	public void deve_verificar_nome_proprietario_numerico() {
		empresa.setProprietario("1233 445");
		assertTrue(valid.isFieldInvalid(empresa, "O nome do proprietário está inválido"));
	}

	@Test
	public void deve_verificar_nome_proprietario_especial() {
		empresa.setProprietario("Mar$elo");
		assertTrue(valid.isFieldInvalid(empresa, "O nome do proprietário está inválido"));
	}

	@Test
	public void deve_verificar_nome_proprietario_invalido_2_caracteres() {
		empresa.setProprietario("M");
		assertTrue(valid.isFieldInvalid(empresa, "O nome do proprietario deve estar entre 2 e 120 caracteres"));
	}

	@Test
	public void deve_verificar_nome_proprietario_invalido_120_caracteres() {
		empresa.setProprietario(
				"Nome do proprietario com mais de cento e vinte caracteres para ter certeza de que a validação @Size esta funcionando como deveria, a meta é que essa mensagem seja exibida no front como um erro");
		assertTrue(valid.isFieldInvalid(empresa, "O nome do proprietario deve estar entre 2 e 120 caracteres"));
	}

	@Test
	public void deve_verificar_cnpj_null() {
		assertNotNull(empresa.getCnpj());
	}

	@Test
	public void deve_verificar_created_by_null() {
		assertNotNull(empresa.getCreatedBy());
	}

	@Test
	public void deve_verificar_created_date_not_null() {
		assertNotNull(empresa.getCreatedDate());
	}

	@Test
	public void deve_verificar_last_modified_not_null() {
		assertNotNull(empresa.getLastModifiedBy());
	}

	@Test
	public void deve_verificar_last_modified_date_not_null() {
		assertNotNull(empresa.getLastModifiedDate());
	}

	@Test
	public void deve_aceitar_um_cnpj_valido() {
		assertTrue(empresa.getCnpj().equals("38739416000107"));
	}

	@Test
	public void deve_aceitar_um_cnpj_invalido() {
		empresa.setCnpj("3841600410");
		assertNotNull(empresa.getCnpj());
	}

	@Test
	public void deve_verificar_empresa_equals_null() {
		assertFalse(empresa.equals(null));
	}

	@Test
	public void deve_verificar_empresa_equals_outra_empresa() {
		assertFalse(empresa.equals(new Empresa()));
	}

	@Test
	public void deve_verificar_empresa_sem_data_equals_empresa() {
		assertFalse(new Empresa().equals(empresa));
	}

	@Test
	public void deve_verificar_empresa_com_cnpj_iguais() {
		Empresa other = new Empresa();
		other.setCnpj("38739416000107");
		Empresa another = new Empresa();
		another.setCnpj("38739416000107");
		assertTrue(another.equals(other));
	}

	@Test
	public void deve_verificar_empresa_hashcode() {
		assertNotEquals(empresa.hashCode(), new Empresa().hashCode());
	}

	@Test
	public void deve_verificar_ramo_atividade_not_null() {
		assertNotNull(empresa.getRamoAtividade());
	}

	@Test
	public void deve_verificar_duas_empresas_sem_data() {
		assertFalse(new Empresa().equals(empresa));
	}

	@Test
	public void deve_verificar_empresa_equals_outro_obj() {
		assertFalse(empresa.equals(new Object()));
	}

	@Test
	public void deve_verificar_chave_primaria() {
		assertTrue(empresa.equals(empresa));
	}

	@Test
	public void deve_verificar_nome_empresa_null() {
		assertTrue(empresa.getNomeFantasia() != null);
	}

	@Test
	public void deve_verificar_nome_empresa() {
		assertTrue(empresa.getNomeFantasia().equals("Sim Tv Assistencia"));
	}

	@Test
	public void deve_verificar_nome_empresa_valido() {
		assertTrue(empresa.getNomeFantasia().matches(ALFA));
	}

	@Test
	public void deve_verificar_igualdade_telefone() {
		assertEquals(telefoneStatic().getNumero(), empresa.getTelefone().getNumero());
	}

	@Test
	public void deve_verificar_telefone_ddd_not_null() {
		assertNotNull(empresa.getTelefone().getDdd().getDdd());
	}

	@Test
	public void deve_verificar_telefone_numero_not_null() {
		assertNotNull(empresa.getTelefone().getNumero());
	}

	@Test
	public void deve_verificar_telefone_dominio_not_null() {
		assertNotNull(empresa.getTelefone().getDominio());
	}

	@Test
	public void deve_verificar_annotations_empresa_valido() {
		assertFalse(valid.isInvalid(empresa));
	}

	@Test
	public void deve_verificar_igualdade_telefone_padrao() {
		assertTrue(empresa.getTelefone().getNumero().matches(getTelefoneRegex(empresa.getTelefone())));
	}

	@Test
	public void deve_verificar_endereco_null() {
		assertTrue(empresa.getEndereco() != null);
	}

	@Test
	public void deve_verificar_endereco() {
		assertTrue(empresa.getEndereco().equals(enderecoStatic));
	}

	@Test
	public void deve_verificar_endereco_rua_padrao() {
		assertTrue(empresa.getEndereco().getLogradouro().matches(ALFA));
	}

	@Test
	public void deve_verificar_endereco_bairro_padrao() {
		assertTrue(empresa.getEndereco().getBairro().matches(ALFA));
	}

	@Test
	public void deve_verificar_razao_social_null() {
		assertTrue(empresa.getRazaoSocial() != null);
	}

	@Test
	public void deve_verificar_razao_social() {
		assertTrue(empresa.getRazaoSocial().equals("Trabalhar pelo bem comum"));
	}

	@Test
	public void deve_verificar_proprietario() {
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
		assertNotEquals(empresa.getNomeFantasia(), "Pastel Do Marcelão");
	}

	@Test
	public void nao_deve_validar_nome_empresa_null() {
		assertFalse(empresa.getNomeFantasia() == null);
	}

//	@Test
//	public void nao_deve_verificar_igualdade_tel() throws Exception {
//		assertNotEquals(empresa.getTelefone(), telefoneRandom());
//	}
//	
	@Test
	public void nao_deve_verificar_numero_tel_null() throws Exception {
		assertFalse(empresa.getTelefone().getNumero() == null);
	}

	@Test
	public void nao_deve_verificar_endereco_logradouro_padrao() {
		assertFalse(empresa.getEndereco().getLogradouro().matches(NUMEROS));
	}

	@Test
	public void deve_verificar_ramo_atividade_descricao_not_null() {
		assertNotNull(empresa.getRamoAtividade().getDescricao());
	}

	@Test
	public void nao_deve_verificar_endereco_bairro_padrao() throws Exception {
		assertFalse(empresa.getEndereco().getBairro().matches(NUMEROS));
	}

	@Test
//	public void nao_deve_verificar_endereco() throws Exception {
//		assertNotEquals(empresa.getEndereco(), enderecoRandom());
//	}

	@After
	public void nao_deve_verificar_razao_social() throws Exception {
		assertNotNull(empresa.getRazaoSocial());
	}

	@AfterClass
	public static void nao_deve_verificar_proprietario() throws Exception {
		empresa = null;
	}
}
