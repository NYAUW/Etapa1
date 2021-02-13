package br.com.contmatic.validator;

import br.com.contmatic.constants.Messages;
import br.com.contmatic.constants.Regex;

public class StringValidator {
	
	/********************************************************
	 *                   CONSTRUTORES                       *
	 ********************************************************/

	private StringValidator() {
		throw new IllegalStateException(Messages.NAO_INSTANCIAVEL);
	}
	
	/********************************************************
	 *                VALIDADORES STRING                    *
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
}
