package br.com.contmatic.utils;

import static br.com.contmatic.constants.Messages.NAO_INSTANCIAVEL;
import static br.contmatic.type.EstadosType.SP;

import com.github.javafaker.Faker;

import br.com.contmatic.model.Endereco;
import br.contmatic.type.EstadosType;

public class EnderecoUtil {

	public EnderecoUtil() {
		throw new IllegalStateException(NAO_INSTANCIAVEL);
	}

	public static Endereco enderecoStatic() {
		Endereco endereco = new Endereco("03977120", 123);
		endereco.setBairro("Bairro teste");
		endereco.setComplemento("Complemento 2");
		endereco.setEstado(SP);
		endereco.setLogradouro("Rua Teste");
		return endereco;
	}

	public static Endereco enderecoRandom() {
		Faker faker = new Faker();
		Endereco endereco = new Endereco(faker.regexify("[0-9]{8}"), faker.number().numberBetween(200, 9999));
		endereco.setBairro(faker.address().cityName());
		endereco.setComplemento(faker.address().streetAddress());
		endereco.setEstado((EstadosType) EnumUtil.getRandomValue(EstadosType.values()));
		endereco.setLogradouro(faker.address().streetName());
		return endereco;
	}

}
