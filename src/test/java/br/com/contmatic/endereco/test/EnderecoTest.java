package br.com.contmatic.endereco.test;

import static br.contmatic.type.EstadosType.SP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.Endereco;
import br.com.contmatic.validate.ValidateAnnotations;

public class EnderecoTest {
	
	private static Endereco endereco;
	
	private ValidateAnnotations<Object> valid = new ValidateAnnotations<>();
	
	@BeforeClass
	public static void deve_instanciar_endereco() {
		endereco = new Endereco();
		endereco.setCep("03977120");
		endereco.setNumero(2738);
		endereco.setBairro("Mascarenhas de Morais");
		endereco.setComplemento(null);
		endereco.setEstado(SP);
		endereco.setLogradouro("Rua soldado Luis manoel Ferreira");
	}
	
	@Before
	public void deve_resetar_objeto_endereco() {
		endereco.setCep("03977120");
		endereco.setNumero(2738);
		endereco.setBairro("Mascarenhas de Morais");
		endereco.setComplemento(null);
		endereco.setEstado(SP);
		endereco.setLogradouro("Rua soldado Luis manoel Ferreira");
		assertNull(endereco.getComplemento());
	}
	
	@Test
	public void deve_verificar_digitos_cep() {
		endereco.setCep("abc");
		assertTrue(valid.isFieldInvalid(endereco, "O CEP está inválido"));
	}
	
	@Test
	public void deve_verificar_endereco_equals() {
		assertTrue(endereco.equals(endereco));
	}
	
	@Test
	public void deve_verificar_endereco_hashcode_cep() {
		assertNotNull(new Endereco().hashCode());
	}
	
	@Test
	public void deve_verificar_endereco_equals_null() {
		assertFalse(endereco.equals(null));
	}
	
	@Test
	public void deve_verificar_endereco_equals_endereco_sem_data() {
		assertFalse(endereco.equals(new Endereco()));
	}
	
	@Test
	public void deve_verificar_endereco_sem_data_equals_endereco() {
		Endereco other = new Endereco();
		other.setCep("03977120");
		other.setNumero(2738);
		Endereco another = new Endereco();
		another.setCep("03977120");
		another.setNumero(2738);
		assertTrue(other.equals(another));
	}
	
	@Test
	public void deve_verificar_endereco_com_cep_equals_endereco_sem_data() {
		assertTrue(new Endereco().equals(new Endereco()));
	}
	
	@Test
	public void deve_verificar_endereco_com_numero_igual() {
		Endereco other = new Endereco();
		other.setCep("03977120");
		other.setNumero(2738);
		assertTrue(other.equals(endereco));
	}
	
	@Test
	public void deve_verificar_endereco_com_numero_diferente() {
		Endereco other = new Endereco();
		other.setCep("03977120");
		other.setNumero(6666);
		assertFalse(other.equals(endereco));
	}
	
	@Test
	public void deve_verificar_endereco_com_cep_diferente() {
		Endereco other = new Endereco();
		other.setCep("08977120");
		other.setNumero(2738);
		Endereco another = new Endereco();
		another.setCep("03977120");
		another.setNumero(2738);
		assertFalse(another.equals(other));
	}
	
	@Test
	public void deve_verificar_endereco_hashcode() {
		assertEquals(endereco.hashCode(), endereco.hashCode());
	}
	
	@Test
	public void deve_verificar_endereco_equals_outro_obj() {
		assertFalse(endereco.equals(new Object()));
	}

	@Test
	public void deve_verificar_bairro_not_null( ) {
		assertNotNull(endereco.getBairro());
	}
	
	@Test
	public void deve_verificar_cep_not_null( ) {
		assertNotNull(endereco.getCep());
	}
	
	@Test
	public void deve_verificar_logradouro_not_null( ) {
		assertNotNull(endereco.getLogradouro());
	}
	
	@Test
	public void deve_verificar_estado_not_null( ) {
		assertNotNull(endereco.getEstado());
	}
	
	@Test
	public void deve_verificar_estado_nome_not_null( ) {
		assertNotNull(endereco.getEstado().getNome());
	}
	
	@Test
	public void deve_verificar_pais_not_null( ) {
		assertNotNull(endereco.getEstado().getPais());
	}
	
	@Test
	public void deve_verificar_estado_codigo_not_null( ) {
		assertNotNull(endereco.getEstado().getCodigoIbge());
	}
	
	@Test
	public void deve_verificar_setar_complemento( ) {
		endereco.setComplemento("Casa 2");
		assertNotNull(endereco.getComplemento());
	}
}
