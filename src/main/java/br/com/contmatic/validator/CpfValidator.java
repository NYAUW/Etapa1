package br.com.contmatic.validator;

import static br.com.contmatic.constants.Messages.NAO_INSTANCIAVEL;

public class CpfValidator {
	
	private static final String INVALID = "CPF Inválido";
	
	private CpfValidator() {
		throw new IllegalStateException(NAO_INSTANCIAVEL);
	}
	
	public static void isCpfValid(String value) {
		if(!isFirstDigitValid(value) || !isSecondDigitValid(value)) {
			throw new IllegalArgumentException(INVALID);
		}
	}
	
	private static boolean isFirstDigitValid(String value) {
		int result = 0;
		int count = 10;
		for (int i = 0; i <= 8; i++) {
			result += Integer.parseInt(value.substring(i, i + 1)) * count;
			count--;
		}
		result = result * 10 % 11;
		return result == Integer.parseInt(value.substring(9, 10));
	}
	
	private static boolean isSecondDigitValid(String value) {
		int result = 0;
		int count = 11;
		for (int i = 0; i <= 9; i++) {
			result += Integer.parseInt(value.substring(i, i + 1)) * count;
			count--;
		}
		result = result * 10 % 11;
		return result == Integer.parseInt(value.substring(10, 11));
	}
	
}
