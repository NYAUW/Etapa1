package br.com.contmatic.usuario.test;

import static br.com.contmatic.constants.Regex.ALFA;
import static br.com.contmatic.utils.EnderecoUtil.enderecoStatic;
import static br.com.contmatic.utils.TelefoneUtil.getTelefoneRegex;
import static br.com.contmatic.utils.TelefoneUtil.telefoneStatic;
import static br.com.contmatic.validator.StringValidator.isCpf;
import static br.com.contmatic.validator.StringValidator.isEmailValido;
import static br.com.contmatic.validator.StringValidator.isNomeValido;
import static br.com.contmatic.validator.StringValidator.isRG;
import static br.com.contmatic.validator.StringValidator.isSenhaValida;
import static br.com.contmatic.validator.StringValidator.validaFormataCpf;
import static br.com.contmatic.validator.StringValidator.validaSenha;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.Usuario;
import br.com.contmatic.utils.EnderecoUtil;
import br.com.contmatic.utils.TelefoneUtil;

public class UsuarioTest {
    private static Usuario usuario;
    
    @BeforeClass
    public static void deve_instanciar() {
    	usuario = new Usuario();
    	usuario.setCpf("53064982052");
    	usuario.setEmail("jose.garcia@gmail.com");
    	usuario.setNome("Jose Garcia");
    	usuario.setEndereco(enderecoStatic());
    	usuario.setRg("657849875");
    	usuario.setSenha("sapinho123");
    	usuario.setTelefone(telefoneStatic());
    }
    
    
    @Test
    public void deve_verificar_nome() {
        assertNotNull(usuario.getNome());
    }
    
    @Test
    public void deve_verificar_nome_valido() {
        assertNotNull(isNomeValido(usuario.getNome()));
    }
    
    @Test
    public void deve_verificar_email() {
        assertNotNull(usuario.getEmail());
    }

    @Test
    public void deve_verificar_email_valido() {
        assertTrue(isEmailValido(usuario.getEmail()));
    }
    
    @Test
    public void deve_verificar_senha() {
        assertNotNull(validaSenha(usuario.getSenha()));
    }

    @Test
    public void deve_verificar_senha_valida() {
        assertTrue(isSenhaValida(usuario.getSenha()));
    }

    @Test
    public void deve_verificar_cpf() {
        assertTrue(isCpf(usuario.getCpf()));
    }
    
    @Test
    public void deve_verificar_cpf_formatado() {
        assertNotNull(validaFormataCpf(usuario.getCpf()));
    }

    @Test
    public void deve_verificar_rg_valido() {
        assertTrue(isRG(usuario.getRg()));
    }
    
    @Test
    public void deve_verificar_rg() {
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

    @Test
    public void nao_deve_verificar_endereco() throws Exception {
        assertNotEquals(usuario.getEndereco(), EnderecoUtil.enderecoRandom());
    }

    @Test
    public void nao_deve_verificar_telefone() {
        assertNotEquals(usuario.getTelefone(), TelefoneUtil.telefoneRandom());
    }
}
