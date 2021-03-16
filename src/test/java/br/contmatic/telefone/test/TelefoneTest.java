package br.contmatic.telefone.test;

import static br.contmatic.type.DddType.SAO_PAULO;
import static br.contmatic.type.DominioTelefoneType.PESSOAL;
import static br.contmatic.type.TelefoneType.CELULAR;
import static br.contmatic.type.TelefoneType.FIXO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.Telefone;

public class TelefoneTest {
	
	private static Telefone telefone;
	
	@BeforeClass
	public static void deve_instanciar_telefone() {
		telefone = new Telefone("983062164", CELULAR);
		telefone.setDdd(SAO_PAULO);
		telefone.setDominio(PESSOAL);
	}
	
	@Test
	public void deve_verificar_telefone_equals() {
		assertTrue(telefone.equals(telefone));
	}
	
	@Test
	public void deve_verificar_telefone_hashcode_cep() {
		assertNotNull(new Telefone("983062164", CELULAR).hashCode());
	}
	
	@Test
	public void deve_verificar_telefone_equals_null() {
		assertFalse(telefone.equals(null));
	}
	
	@Test
	public void deve_verificar_telefone_equals_telefone_sem_data() {
		assertFalse(telefone.equals(new Telefone("20117414", FIXO)));
	}
	
	@Test
	public void deve_verificar_telefone_sem_data_equals_telefone_sem_data() {
		assertTrue(new Telefone("983062164", CELULAR).equals(new Telefone("983062164", CELULAR)));
	}
	
	@Test
	public void deve_verificar_telefone_com_cep_equals_telefone_sem_data() {
		Telefone other = new Telefone("20117414", FIXO);
		assertFalse(new Telefone("983062164", CELULAR).equals(other));
	}
	
	@Test
	public void deve_verificar_telefone_com_numero_igual() {
		Telefone other = new Telefone("983062164", CELULAR);
		other.setTipoTelefone(CELULAR);
		other.setNumero(telefone.getNumero());
		assertTrue(other.equals(telefone));
	}

	@Test
	public void deve_verificar_telefone_com_cep_iguais() {
		Telefone other = new Telefone("983062164", CELULAR);
		other.setTipoTelefone(FIXO);
		other.setNumero("44012901");
		Telefone another = new Telefone("983062164", CELULAR);
		another.setTipoTelefone(FIXO);
		another.setNumero("44012901");
		assertTrue(another.equals(other));
	}
	
	@Test
	public void deve_verificar_telefone_com_cep_diferente() {
		Telefone other = new Telefone("983062164", CELULAR);
		other.setTipoTelefone(FIXO);
		other.setNumero("03977120");
		Telefone another = new Telefone("983062164", CELULAR);
		another.setTipoTelefone(FIXO);
		another.setNumero("08977120");
		assertFalse(another.equals(other));
	}
	
	@Test
	public void deve_verificar_telefone_hashcode() {
		assertEquals(telefone.hashCode(), telefone.hashCode());
	}
	
	@Test
	public void deve_verificar_telefone_equals_outro_obj() {
		assertFalse(telefone.equals(new Object()));
	}	
			
	@Test
	public void deve_verificar_tipo_telefone_not_null() {
		assertNotNull(telefone.getTipoTelefone());
	}
	
	@Test
	public void deve_verificar_tipo_telefone_telefone_not_null() {
		assertNotNull(telefone.getTipoTelefone().getTelefone());
	}
	
	@Test
	public void deve_verificar_tipo_telefone_quantidade_not_null() {
		assertNotNull(telefone.getTipoTelefone().getQuantidadeNumeros());
	}
	
	@Test
	public void deve_verificar_ddd_not_null() {
		assertNotNull(telefone.getDdd());
	}
	
	@Test
	public void deve_verificar_dominio_not_null() {
		assertNotNull(telefone.getDominio());
	}
	
	@Test
	public void deve_verificar_dominio_dominio_not_null() {
		assertNotNull(telefone.getDominio().getDominio());
	}
}
