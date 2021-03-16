package br.com.contmatic.utils;

import static br.com.contmatic.constants.Messages.NAO_INSTANCIAVEL;
import static br.contmatic.type.EstadosType.SP;

import br.com.contmatic.model.Endereco;

public class EnderecoUtil {

	public EnderecoUtil() {
		throw new IllegalStateException(NAO_INSTANCIAVEL);
	}

	public static Endereco enderecoStatic() {
		Endereco endereco = new Endereco("03977120", 123);
		endereco.setBairro("Bairro teste");
		endereco.setComplemento("Complemento 2");
		endereco.setLogradouro("Rua Teste");
		endereco.setEstado(SP);
		return endereco;
	}
}
