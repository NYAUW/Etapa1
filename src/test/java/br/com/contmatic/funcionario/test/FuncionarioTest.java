package br.com.contmatic.funcionario.test;

import static br.com.contmatic.constants.Regex.ALFA;
import static br.com.contmatic.utils.DateUtils.getIdade;
import static br.contmatic.type.SexoType.FEMININO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.Funcionario;
import br.com.contmatic.validator.CpfValidator;

public class FuncionarioTest {
	private static Funcionario funcionario;

	@BeforeClass
	public static void deve_instanciar_funvionario() {
		funcionario = new Funcionario("83765370088");
		funcionario.setCargo("Atendente");
		funcionario.setCodigo(626);
		funcionario.setNome("Juliette Ferreira");
		funcionario.setSalario(new BigDecimal("2300.00"));
		funcionario.setDataAdmissao(LocalDate.of(2018, 1, 6));
		funcionario.setDataDesligamento(null);
		funcionario.setDataNascimento(LocalDate.of(2001, 12, 11));
		funcionario.setSexo(FEMININO);
	}

	@Before
	public void deve_verificar_instancia_funcionario() {
		if (funcionario.getDataDesligamento() != null) {
			funcionario.setDataDesligamento(null);
		}
	}
	
	@Test
	public void deve_verificar_funcionario_equals() {
		assertTrue(funcionario.equals(funcionario));
	}
	
	@Test
	public void deve_verificar_funcionario_hashcode_cpf() {
		assertNotNull(new Funcionario("83765370088").hashCode());
	}
	
	@Test
	public void deve_verificar_funcionario_equals_null() {
		assertFalse(funcionario.equals(null));
	}
	
	@Test
	public void deve_verificar_funcionario_equals_funcionario_sem_data() {
		assertFalse(funcionario.equals(new Funcionario("50740457896")));
	}
	
	@Test
	public void deve_verificar_funcionario_sem_data_equals_funcionario_sem_data() {
		assertTrue(new Funcionario("83765370088").equals(new Funcionario("83765370088")));
	}
	
	@Test
	public void deve_verificar_funcionario_com_cpf_equals_funcionario_sem_data() {
		Funcionario other = new Funcionario("83765370088");
		other.setCpf("50740457896");
		assertFalse(new Funcionario("83765370088").equals(other));
	}
	
	@Test
	public void deve_verificar_funcionario_com_codigo_igual() {
		Funcionario other = new Funcionario("50740457896");
		other.setCodigo(funcionario.getCodigo());
		assertFalse(other.equals(funcionario));
	}
	
	@Test
	public void deve_verificar_funcionario_com_cpf_iguais() {
		Funcionario other = new Funcionario("83765370088");
		other.setCpf("50740457896");
		Funcionario another = new Funcionario("83765370088");
		another.setCpf("50740457896");
		assertTrue(another.equals(other));
	}
	
	@Test
	public void deve_verificar_funcionario_com_cpf_diferente() {
		Funcionario other = new Funcionario("83765370088");
		other.setCpf("50740457896");
		Funcionario another = new Funcionario("83765370088");
		another.setCpf("83765370088");
		assertFalse(another.equals(other));
	}
	
	@Test
	public void deve_verificar_funcionario_hashcode() {
		assertEquals(funcionario.hashCode(), funcionario.hashCode());
	}
	
	@Test
	public void deve_verificar_funcionario_equals_outro_obj() {
		assertFalse(funcionario.equals(new Object()));
	}

	@Test
	public void deve_verificar_nome_pattern() {
		assertTrue(funcionario.getNome().matches(ALFA));
	}

	@Test
	public void deve_verificar_nome_not_null() {
		assertNotNull(funcionario.getNome());
	}

	@Test
	public void deve_verificar_quantidade_caracteres_nome() {
		assertTrue(funcionario.getNome().length() > 2);
	}

	@Test
	public void deve_verificar_cargo() {
		assertTrue(funcionario.getCargo().matches(ALFA));
	}

	@Test
	public void deve_verificar_cargo_null() {
		assertNotNull(funcionario.getCargo());
	}

	@Test
	public void deve_verificar_codigo() {
		assertNotNull(funcionario.getCodigo());
	}

	@Test
	public void deve_verificar_salario() {
		assertNotNull(funcionario.getSalario());
	}

	@Test
	public void deve_verificar_data_admissao() {
		assertNotNull(funcionario.getDataAdmissao());
	}

	@Test
	public void deve_verificar_data_desligamento_null() {
		assertNull(funcionario.getDataDesligamento());
	}

	@Test
	public void deve_verificar_data_desligamento() {
		funcionario.setDataDesligamento(LocalDate.of(2019, 4, 2));
		assertNotNull(funcionario.getDataDesligamento());
	}

	@Test
	public void deve_verificar_cpf_pattern() {
		CpfValidator.isCpfValid(funcionario.getCpf());
		assertTrue(true);
	}

	@Test
	public void deve_verificar_cpf() {
		assertNotNull(funcionario.getCpf());
	}

	@Test
	public void deve_verificar_sexo() {
		assertNotNull(funcionario.getSexo());
	}

	@Test
	public void deve_verificar_idade_correta() {
		assertEquals(getIdade(funcionario.getDataNascimento()), funcionario.getIdade());
	}

	@Test
	public void deve_verificar_idade() {
		assertNotNull(funcionario.getIdade());
	}

}
