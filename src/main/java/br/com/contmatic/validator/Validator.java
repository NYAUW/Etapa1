package br.com.contmatic.validator;

import br.com.contmatic.constants.Messages;

public class Validator {
	
	/********************************************************
	 * CONSTRUTORES *
	 ********************************************************/

	private Validator() {
		throw new IllegalStateException(Messages.NAO_INSTANCIAVEL);
	}

	/********************************************************
	 * VALIDADORES *
	 ********************************************************/
	public static Object isNotNull(Object value) {
		if(value == null) {
			throw new NullPointerException();
		}
		return value;
	}
	
	public static Integer isNumeroMaiorQueZero(Integer numero) {
		if(numero <= 0) {
			throw new IllegalArgumentException(Messages.ENTRADA_INVALIDA);
		}
		return numero;
	}

}
