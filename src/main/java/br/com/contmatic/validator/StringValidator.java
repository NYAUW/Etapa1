package br.com.contmatic.validator;

import static br.com.contmatic.constants.Messages.ENTRADA_INVALIDA;
import static br.com.contmatic.constants.Regex.NOME;
import static br.com.contmatic.utils.FormatMessagesUtils.getInvalidExceptionMessage;
import static br.com.contmatic.utils.FormatMessagesUtils.getMaxCharacterExceptionMessage;
import static br.com.contmatic.utils.FormatMessagesUtils.getMinCharacterExceptionMessage;
import static br.com.contmatic.utils.FormatMessagesUtils.getNumberExceptionMessage;
import static br.com.contmatic.utils.FormatMessagesUtils.getThisExactCharacterExceptionMessage;
import static br.contmatic.type.TelefoneType.CELULAR;
import static br.contmatic.type.TelefoneType.FIXO;

import org.apache.commons.lang3.StringUtils;

import br.com.contmatic.constants.Messages;
import br.com.contmatic.constants.Regex;
import br.contmatic.type.TelefoneType;

public class StringValidator {

	/********************************************************
	 * CONSTRUTORES *
	 ********************************************************/

	private StringValidator() {
		throw new IllegalStateException(Messages.NAO_INSTANCIAVEL);
	}

	/********************************************************
	 * VALIDADORES STRING *
	 ********************************************************/

	public static void isRGPattern(String value) {
		if(!value.matches(Regex.RG_PATTERN)) {
			throw new IllegalArgumentException(getInvalidExceptionMessage("rg"));
		}
	}
	
	public static void isNotBlank(String value, String fieldName) {
		if(StringUtils.isBlank(value)) {
			throw new IllegalArgumentException(getInvalidExceptionMessage(fieldName));
		}
	}

	public static boolean isCelular(String value) {
		return value.matches(Regex.NUMERO_CELULAR);
	}

	public static boolean isCelularComDdd(String value) {
		return value.matches(Regex.DDD + " " + Regex.NUMERO_CELULAR);
	}

	public static boolean isFixo(String value) {
		return value.matches(Regex.NUMERO_FIXO);
	}

	public static boolean isFixoComDdd(String value) {
		return value.matches(Regex.DDD + " " + Regex.NUMERO_FIXO);
	}

	public static void isCpfPattern(String value) {
		if(!value.matches(Regex.CPF)) {
			throw new IllegalArgumentException(getInvalidExceptionMessage("cpf"));
		}
	}

	public static void isCnpjPattern(String value) {
		if(!value.matches(Regex.CNPJ)) {
			throw new IllegalArgumentException(getInvalidExceptionMessage("cnpj"));
		}
	}

	public static void hasEspecialCharacter(String value, String fieldname) {
		if(value.matches(Regex.ESPECIAIS)) {
			throw new IllegalArgumentException(getInvalidExceptionMessage(fieldname));
		}
	}

	public static void isEmailPattern(String value) {
		if(!value.matches(Regex.EMAIL)) {
			throw new IllegalArgumentException(getInvalidExceptionMessage("email"));
		}
	}

	public static void isOnlyNumber(String value, String fieldName) {
		if (!value.matches(Regex.NUMEROS)) {
			throw new IllegalArgumentException(getNumberExceptionMessage(fieldName));
		}
	}
	
	public static void isNumberTelPattern(String value, TelefoneType type) {
		if(type == CELULAR && !value.matches(Regex.NUMERO_CELULAR)) {
			throw new IllegalArgumentException("O numero de celular não está válido");
		}
		if(type == FIXO && !value.matches(Regex.NUMERO_FIXO)) {
			throw new IllegalArgumentException("O numero fixo não está válido");
		}
	}

	public static void isMinChararacters(String value, int quantidadeMinima) {
		if (value.length() < quantidadeMinima) {
			throw new IllegalArgumentException(getMinCharacterExceptionMessage(quantidadeMinima));
		}
	}
	
	public static void isMaxChararacters(String value, int quantidadeMaxima) {
		if (value.length() > quantidadeMaxima) {
			throw new IllegalArgumentException(getMaxCharacterExceptionMessage(quantidadeMaxima));
		}
	}
	
	public static void isThisExactChararacters(String value, int quantidadeExata) {
		if (value.length() != quantidadeExata) {
			throw new IllegalArgumentException(getThisExactCharacterExceptionMessage(quantidadeExata));
		}
	}


	public static void isNomePattern(String value) {
		if (!value.matches(NOME)) {
			throw new IllegalArgumentException(ENTRADA_INVALIDA + " Insira um nome completo válido");
		}
	}
}
