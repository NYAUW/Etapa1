package br.com.contmatic.validator;

import br.com.contmatic.constants.Messages;
import br.com.contmatic.constants.Regex;

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

	public static boolean isSomenteCaractere(String value) {
		return value.matches(Regex.ALFA);
	}

	public static boolean isNumero(String value) {
		return value.matches(Regex.NUMEROS);
	}

	public static boolean isRG(String value) {
		return value.matches(Regex.RG_PATTERN);
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

	public static boolean isCpf(String value) {
		return value.matches(Regex.CPF);
	}

	public static boolean isCnpj(String value) {
		return value.matches(Regex.CNPJ);
	}

	public static boolean contemEspecial(String value) {
		return value.matches(Regex.ESPECIAIS);
	}

	public static boolean contemAcento(String value) {
		return value.matches(Regex.ACENTOS);
	}

	public static String validaCnpj(String value) {
		if (isCnpj(value)) {
			return value;
		}else if(value.length() != 14) {
			throw new IllegalArgumentException(Messages.QUANTIDADE_CARACTERES_INVALIDA + (" (" + value + ")"));
		} else {
			if(!isNumero(value)) {
				throw new IllegalArgumentException(Messages.CARACTERE_INVALIDO);
			}
		}
		return value.substring(0, 2) + "." + 
				value.substring(2, 5) + "." + 
				value.substring(5, 8) + "/" +
				value.substring(8, 12) + "." + 
				value.substring(12, 14);
	}
	
	public static String validaNome(String value) {
		if(isSomenteCaractere(value) && value.length() >= 5) {
			return value;
		} else {
			throw new IllegalArgumentException(Messages.ENTRADA_INVALIDA + " Insira um nome completo válido");
		}
	}
}
