package br.com.contmatic.utils;

import br.com.contmatic.constants.Messages;

public class FormatMessagesUtils {

	public FormatMessagesUtils() {
		throw new IllegalArgumentException(Messages.NAO_INSTANCIAVEL);
	}

	public static String getNullExceptionMessage(String value) {
		return "O(A) " + value + " não pode ser vazio!";
	}

	public static String getInvalidExceptionMessage(String value) {
		return "O(A) " + value + " está inválido!";
	}

	public static String getNumberExceptionMessage(String value) {
		return "O(A) " + value + " deve conter apenas números";
	}

	public static String getMinCharacterExceptionMessage(int value) {
		return "A quantidade minima é de " + value;
	}
	
	public static String getMaxCharacterExceptionMessage(int value) {
		return "A quantidade maxima é de " + value;
	}
	
	public static String getThisExactCharacterExceptionMessage(int value) {
		return "A o campo nao corresponde a quantidade de " + value + " caracteres";
	}

	public static String getBetweenNumberExceptionMessage(String fieldName, int min, int max) {
		return "O(A) " + fieldName + " deve estar entre o numero " + min + " e " + max;
	}
}
