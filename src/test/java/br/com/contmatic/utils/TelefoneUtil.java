package br.com.contmatic.utils;

import static br.com.contmatic.constants.Messages.NAO_INSTANCIAVEL;
import static br.com.contmatic.constants.Regex.NUMERO_CELULAR;
import static br.com.contmatic.constants.Regex.NUMERO_FIXO;
import static br.contmatic.type.DddType.SAO_PAULO;
import static br.contmatic.type.DominioTelefoneType.COMERCIAL;
import static br.contmatic.type.TelefoneType.CELULAR;

import com.github.javafaker.Faker;

import br.com.contmatic.model.Telefone;
import br.contmatic.type.DddType;
import br.contmatic.type.DominioTelefoneType;
import br.contmatic.type.TelefoneType;

public class TelefoneUtil {
	
	public TelefoneUtil() {
		throw new IllegalStateException(NAO_INSTANCIAVEL);
	}

	public static Telefone telefoneStatic() {
		Telefone telefone = new Telefone();
		telefone.setDdd(SAO_PAULO);
		telefone.setDominio(COMERCIAL);
		telefone.setTipoTelefone(CELULAR);
		telefone.setNumero("965821475");
		return telefone;
	}

	public static Telefone telefoneRandom() {
		Faker faker = new Faker();
		Telefone telefone = new Telefone();
		telefone.setDdd((DddType) EnumUtil.getRandomValue(DddType.values()));
		telefone.setDominio((DominioTelefoneType) EnumUtil.getRandomValue(DominioTelefoneType.values()));
		telefone.setTipoTelefone((TelefoneType) EnumUtil.getRandomValue(TelefoneType.values()));
		telefone.setNumero(telefone.getTipoTelefone() != CELULAR ? faker.regexify("[0-9]{8}")
				: faker.regexify("9[0-9]{8}"));
		return telefone;
	}
	
	public static String getTelefoneRegex(Telefone telefone) {
		return telefone.getTipoTelefone() != CELULAR ? NUMERO_FIXO
				: NUMERO_CELULAR;
		
	}
}
