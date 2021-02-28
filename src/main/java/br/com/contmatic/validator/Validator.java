package br.com.contmatic.validator;

import static br.com.contmatic.constants.Messages.MENOR_IGUAL_ZERO;
import static br.com.contmatic.utils.FormatMessagesUtils.getBetweenNumberExceptionMessage;
import static br.com.contmatic.utils.FormatMessagesUtils.getNullExceptionMessage;

import br.com.contmatic.constants.Messages;
import br.contmatic.type.TelefoneType;

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
	public static Object isNotNull(Object value, String fieldName) {
		if (value == null) {
			throw new NullPointerException(getNullExceptionMessage(fieldName));
		}
		return value;
	}

	public static void isTipoTelefoneNotNull(TelefoneType value) {
		if (value == null) {
			throw new IllegalArgumentException("O tipo do telefone não foi informado");
		}
	}

	public static void isGreaterThanZero(Integer numero) {
		if (numero <= 0) {
			new IllegalArgumentException(MENOR_IGUAL_ZERO);
		}
	}

	public static void isNumberBetween(Integer numero, int numeroMinimo, int numeroMaximo, String fieldName) {
		if (numero < numeroMinimo && numero > numeroMaximo) {
			throw new IllegalArgumentException(getBetweenNumberExceptionMessage(fieldName, numeroMinimo, numeroMaximo));
		}
	}

}
