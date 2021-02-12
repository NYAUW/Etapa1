package br.com.contmatic.utils;

import com.github.javafaker.Faker;

import br.com.contmatic.constants.Messages;
import br.com.contmatic.model.Telefone;
import br.contmatic.type.DddType;
import br.contmatic.type.DominioTelefoneType;
import br.contmatic.type.TelefoneType;

public class TelefoneUtil {
	
	public TelefoneUtil() {
		throw new IllegalStateException(Messages.NAO_INSTANCIAVEL);
	}

	public static Telefone telefoneStatic() {
		Telefone telefone = new Telefone();
		telefone.setDdd(DddType.SAO_PAULO);
		telefone.setDominio(DominioTelefoneType.COMERCIAL);
		telefone.setTipoTelefone(TelefoneType.CELULAR);
		telefone.setNumero("965821475");
		return telefone;
	}

	public static Telefone telefoneRandom() {
		Faker faker = new Faker();
		Telefone telefone = new Telefone();
		telefone.setDdd((DddType.values()[Double.valueOf(Math.random() * DddType.values().length).intValue()]));
		telefone.setDominio((DominioTelefoneType.values()[Double
				.valueOf(Math.random() * DominioTelefoneType.values().length).intValue()]));
		telefone.setTipoTelefone(
				(TelefoneType.values()[Double.valueOf(Math.random() * TelefoneType.values().length).intValue()]));
		telefone.setNumero(telefone.getTipoTelefone() == TelefoneType.CELULAR ? faker.regexify("[0-9]{8}")
				: faker.regexify("9[0-9]{8}"));
		return telefone;
	}
}
