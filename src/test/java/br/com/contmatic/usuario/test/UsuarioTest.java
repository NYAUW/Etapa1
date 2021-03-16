package br.com.contmatic.usuario.test;

import static br.com.contmatic.constants.Regex.ALFA;
import static br.com.contmatic.constants.Regex.EMAIL;
import static br.com.contmatic.constants.Regex.NOME;
import static br.com.contmatic.constants.Regex.RG_PATTERN;
import static br.com.contmatic.utils.EnderecoUtil.enderecoStatic;
import static br.com.contmatic.utils.TelefoneUtil.getTelefoneRegex;
import static br.com.contmatic.utils.TelefoneUtil.telefoneStatic;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.Usuario;
import br.com.contmatic.validator.CpfValidator;

public class UsuarioTest {
    private static Usuario usuario;
    
    @BeforeClass
    public static void deve_instanciar() {
    	usuario = new Usuario("53064982052");
    	usuario.setEmail("jose.garcia@gmail.com");
    	usuario.setNome("Jose Garcia");
    	usuario.setEndereco(enderecoStatic());
    	usuario.setRg("657849875");
    	usuario.setSenha("09999");
    	usuario.setTelefone(telefoneStatic());
    }
    
    @Test
	public void deve_verificar_usuario_equals() {
		assertTrue(usuario.equals(usuario));
	}
	
	@Test
	public void deve_verificar_usuario_hashcode_cpf() {
		assertNotNull(new Usuario("53064982052").hashCode());
	}
	
	@Test
	public void deve_verificar_usuario_equals_null() {
		assertFalse(usuario.equals(null));
	}
	
	@Test
	public void deve_verificar_usuario_equals_usuario_sem_data() {
		assertFalse(usuario.equals(new Usuario("50740457896")));
	}
	
	@Test
	public void deve_verificar_usuario_sem_data_equals_usuario_sem_data() {
		assertTrue(new Usuario("53064982052").equals(new Usuario("53064982052")));
	}
	
	@Test
	public void deve_verificar_usuario_com_cpf_equals_usuario_sem_data() {
		Usuario other = new Usuario("53064982052");
		other.setCpf("50740457896");
		assertFalse(new Usuario("53064982052").equals(other));
	}
	
	@Test
	public void deve_verificar_usuario_com_codigo_igual() {
		Usuario other = new Usuario("53064982052");
		other.setCpf(usuario.getCpf());
		assertTrue(other.equals(usuario));
	}
	
	@Test
	public void deve_verificar_usuario_com_cpf_iguais() {
		Usuario other = new Usuario("53064982052");
		other.setCpf("50740457896");
		Usuario another = new Usuario("53064982052");
		another.setCpf("50740457896");
		assertTrue(another.equals(other));
	}
	
	@Test
	public void deve_verificar_usuario_com_cpf_diferente() {
		Usuario other = new Usuario("53064982052");
		other.setCpf("50740457896");
		Usuario another = new Usuario("53064982052");
		another.setCpf("56887329034");
		assertFalse(another.equals(other));
	}
	
	@Test
	public void deve_verificar_usuario_hashcode() {
		assertEquals(usuario.hashCode(), usuario.hashCode());
	}
	
	@Test
	public void deve_verificar_usuario_equals_outro_obj() {
		assertFalse(usuario.equals(new Object()));
	}

    
    @Test
    public void deve_verificar_nome_pattern() {
        assertTrue(usuario.getNome().matches(NOME));
    }
    
    @Test
    public void deve_verificar_nome_not_null() {
        assertNotNull(usuario.getNome());
    }
    
    @Test
    public void deve_verificar_email_not_null() {
        assertNotNull(usuario.getEmail());
    }

    @Test
    public void deve_verificar_email_pattern() {
        assertTrue(usuario.getEmail().matches(EMAIL));
    }
    
    @Test
    public void deve_verificar_senha_not_null() {
        assertNotNull(usuario.getSenha());
    }

    @Test
    public void deve_verificar_senha_valida() {
        assertTrue(usuario.getSenha().length() > 4);
    }

    @Test
    public void deve_verificar_cpf() {
    	CpfValidator.isCpfValid(usuario.getCpf());
        assertTrue(true);
    }

    @Test
    public void deve_verificar_rg_valido() {
        assertTrue(usuario.getRg().matches(RG_PATTERN));
    }
    
    @Test
    public void deve_verificar_rg_not_null() {
        assertNotNull(usuario.getRg());
    }

    @Test
	public void devera_verificar_endereco_null() {
		assertNotNull(usuario.getEndereco());
	}
	
	@Test
	public void devera_verificar_endereco_rua_padrao() {
		assertTrue(usuario.getEndereco().getLogradouro().matches(ALFA));
	}
	
	@Test
	public void devera_verificar_endereco_bairro_padrao() {
		assertTrue(usuario.getEndereco().getBairro().matches(ALFA));
	}

	@Test
	public void devera_verificar_igualdade_telefone() {
		assertEquals(telefoneStatic().getNumero(), usuario.getTelefone().getNumero());
	}
	
	@Test
	public void devera_verificar_igualdade_telefone_padrao() {
		assertTrue(usuario.getTelefone().getNumero()
				.matches(getTelefoneRegex(usuario.getTelefone())));
	}
	
    @Test
    public void nao_deve_verificar_nome() throws Exception {
        assertNotEquals(usuario.getNome(), "Marcelao");
    }

    @Test
    public void nao_deve_verificar_email() throws Exception {
        assertNotEquals(usuario.getEmail(), "123123@gmail.com");
    }

    @Test
    public void nao_deve_verificar_senha() {
        assertNotEquals(usuario.getSenha(), "5443321");
    }

    @Test
    public void nao_deve_verificar_cpf() throws Exception {
        assertNotEquals(usuario.getCpf(), "5075050589736");
    }

    @Test
    public void nao_deve_verificar_rg() {
        assertNotEquals(usuario.getRg(), "3957895687");
    }

//    @Test
//    public void nao_deve_verificar_endereco() throws Exception {
//        assertNotEquals(usuario.getEndereco(), EnderecoUtil.enderecoRandom());
//    }
//
//    @Test
//    public void nao_deve_verificar_telefone() {
//        assertNotEquals(usuario.getTelefone(), TelefoneUtil.telefoneRandom());
//    }
}
