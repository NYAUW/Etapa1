package br.com.contmatic.usuario.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.contmatic.model.Usuario;
import br.com.contmatic.utils.EnderecoUtil;
import br.com.contmatic.utils.TelefoneUtil;

public class UsuarioTest {
    Usuario usuario = new Usuario("Jose Garcia", "jose.garcia@gmail.com", "sapinho123", "46720276539", "657849875", EnderecoUtil.enderecoStatic(), TelefoneUtil.telefoneStatic());

    @Test
    public void deve_verificar_nome() {
        assertTrue(usuario.getNome().equals("Jose Garcia"));
    }

    @Test
    public void deve_verificar_email() {
        assertTrue(usuario.getEmail() == "jose.garcia@gmail.com");
    }

    @Test
    public void deve_verificar_senha() {
        assertTrue(usuario.getSenha().equals("sapinho123"));
    }

    @Test
    public void deve_verificar_cpf() {
        assertTrue(usuario.getCpf().equals("46720276539"));
    }

    @Test
    public void deve_verificar_rg() {
        assertTrue(usuario.getRg().equals("657849875"));
    }

    @Test
    public void deve_verificar_endereco() {
        assertTrue(usuario.getEndereco().equals("Rua Fada Selvagem 234"));
    }

    @Test
    public void deve_verificar_telefone() {
        assertTrue(usuario.getTelefone().equals(TelefoneUtil.telefoneStatic()));
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
