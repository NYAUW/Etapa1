package br.com.contmatic.utils;

import static br.com.contmatic.constants.Messages.NAO_INSTANCIAVEL;
import static br.contmatic.type.EstadosType.SP;
import static br.contmatic.type.PaisType.BRASIL;

import com.github.javafaker.Faker;

import br.com.contmatic.model.Endereco;
import br.contmatic.type.EstadosType;

public class EnderecoUtil {
	
	public EnderecoUtil() {
		throw new IllegalStateException(NAO_INSTANCIAVEL);
	}

	public static Endereco enderecoStatic() {
		Endereco endereco = new Endereco();
		endereco.setBairro("Bairro teste");
		endereco.setComplemento("Complemento 2");
		endereco.setEstado(SP);
		endereco.setLogradouro("Rua Teste");
		endereco.setNumero(123);
		endereco.setPais(BRASIL);
		return endereco;
	}
	
	public static Endereco enderecoRandom() {
		Endereco endereco = new Endereco();
		Faker faker = new Faker();
		endereco.setBairro(faker.address().cityName());
		endereco.setComplemento(faker.address().streetAddress());
		endereco.setEstado((EstadosType) EnumUtil.getRandomValue(EstadosType.values()));
		endereco.setLogradouro(faker.address().streetName());
		endereco.setNumero(faker.number().numberBetween(1, 9999));
		endereco.setPais(BRASIL);
		return endereco;
	}

}
