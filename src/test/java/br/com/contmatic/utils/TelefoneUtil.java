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
		Telefone telefone = new Telefone("965821475", CELULAR);
		telefone.setDdd(SAO_PAULO);
		telefone.setDominio(COMERCIAL);
		return telefone;
	}

	public static Telefone telefoneRandom() {
		Faker faker = new Faker();
		TelefoneType tipo =  (TelefoneType) EnumUtil.getRandomValue(TelefoneType.values());
		Telefone telefone = new Telefone(tipo != CELULAR ? faker.regexify("[0-9]{8}")
				: faker.regexify("9[0-9]{8}"), tipo);
		telefone.setDdd((DddType) EnumUtil.getRandomValue(DddType.values()));
		telefone.setDominio((DominioTelefoneType) EnumUtil.getRandomValue(DominioTelefoneType.values()));
		return telefone;
	}
	
	public static String getTelefoneRegex(Telefone telefone) {
		return telefone.getTipoTelefone() != CELULAR ? NUMERO_FIXO
				: NUMERO_CELULAR;
		
	}
}
