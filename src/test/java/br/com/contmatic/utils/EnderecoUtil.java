package br.com.contmatic.utils;

import com.github.javafaker.Faker;

import br.com.contmatic.model.Endereco;
import br.contmatic.type.EstadosType;
import br.contmatic.type.PaisType;

public class EnderecoUtil {
	
	public static Endereco enderecoStatic() {
		Endereco endereco = new Endereco();
		endereco.setBairro("Bairro teste");
		endereco.setComplemento("Complemento 2");
		endereco.setEstado(EstadosType.SP);
		endereco.setLogradouro("Rua Teste");
		endereco.setNumero(123);
		endereco.setPais(PaisType.BRASIL);
		return endereco;
	}
	
	public static Endereco enderecoRandom() {
		Endereco endereco = new Endereco();
		Faker faker = new Faker();
		endereco.setBairro(faker.address().cityName());
		endereco.setComplemento(faker.address().streetAddress());
		endereco.setEstado((EstadosType.values()[Double.valueOf(Math.random() * EstadosType.values().length).intValue()]));
		endereco.setLogradouro(faker.address().streetName());
		endereco.setNumero(faker.number().numberBetween(1, 9999));
		endereco.setPais(PaisType.BRASIL);
		return endereco;
	}

}
