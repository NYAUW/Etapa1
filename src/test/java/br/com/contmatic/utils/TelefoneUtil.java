package br.com.contmatic.utils;

import static br.com.contmatic.constants.Messages.NAO_INSTANCIAVEL;
import static br.com.contmatic.constants.Regex.NUMERO_CELULAR;
import static br.com.contmatic.constants.Regex.NUMERO_FIXO;
import static br.contmatic.type.DddType.SAO_PAULO;
import static br.contmatic.type.DominioTelefoneType.COMERCIAL;
import static br.contmatic.type.TelefoneType.CELULAR;

import br.com.contmatic.model.Telefone;

public class TelefoneUtil {
	
	public TelefoneUtil() {
		throw new IllegalStateException(NAO_INSTANCIAVEL);
	}

	public static Telefone telefoneStatic() {
		Telefone telefone = new Telefone();
		telefone.setNumero("965821475");
		telefone.setTipoTelefone(CELULAR);
		telefone.setDdd(SAO_PAULO);
		telefone.setDominio(COMERCIAL);
		return telefone;
	}
	
	public static String getTelefoneRegex(Telefone telefone) {
		return telefone.getTipoTelefone() != CELULAR ? NUMERO_FIXO
				: NUMERO_CELULAR;
		
	}
}
