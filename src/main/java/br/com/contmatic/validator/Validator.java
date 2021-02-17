package br.com.contmatic.validator;

import static br.com.contmatic.constants.Messages.QUANTIDADE_INVALIDA;

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
		if (value == null) {
			throw new NullPointerException();
		}
		return value;
	}

	public static Integer isNumeroMaiorQueZero(Integer numero) {
		return (Integer) (numero > 0 ? numero
				: throwException(new IllegalArgumentException(Messages.ENTRADA_INVALIDA)));
	}

	public static Integer isNumeroMaiorQue(Integer numero, int valor) {
		return (Integer) (numero > valor ? numero
				: throwException(new IllegalArgumentException(
						"O número informado não corresponde a quantidade mínima de " + valor + " caracteres")));
	}

	public static Integer isNumeroEntre(Integer numero, int numeroMinimo, int numeroMaximo) {
		return (Integer) ((Integer) isNotNull(numero) > numeroMinimo && numero < numeroMaximo ? numero
				: throwException(new IllegalAccessException(QUANTIDADE_INVALIDA)));
	}

	public static Object throwException(Exception e) {
		try {
			throw e;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
