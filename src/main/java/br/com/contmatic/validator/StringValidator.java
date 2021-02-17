package br.com.contmatic.validator;

import static br.com.contmatic.constants.Messages.ENTRADA_INVALIDA;
import static br.contmatic.type.TelefoneType.CELULAR;

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

	public static boolean isSomenteCaractere(String value) {
		return value.matches(Regex.ALFA);
	}

	public static boolean isNumero(String value) {
		return value.matches(Regex.NUMEROS);
	}
	
	public static boolean isNomeValido(String value) {
		return value.matches(Regex.ALFA) && value.trim().length() > 5;
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
		value = CpfValidator.isCpfValido(value);
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

	public static boolean isEmail(String value) {
		return value.matches(Regex.EMAIL);
	}

	public static String validaCnpj(String value) {
		if (isCnpj(value)) {
			return value;
		} else if (value.length() != 14) {
			throw new IllegalArgumentException(Messages.QUANTIDADE_CARACTERES_INVALIDA + (" (" + value + ")"));
		} else {
			if (!isNumero(value)) {
				throw new IllegalArgumentException(Messages.CARACTERE_INVALIDO);
			}
		}
		String cnpj = value.substring(0, 2) + "." + value.substring(2, 5) + "." + value.substring(5, 8) + "/"
				+ value.substring(8, 12) + "." + value.substring(12, 14);
		if (isCnpj(cnpj)) {
			return cnpj;
		}
		throw new IllegalArgumentException(Messages.ENTRADA_INVALIDA);
	}

	public static String validaFormataCpf(String value) {
		value = CpfValidator.isCpfValido(value.replace(".", "").replace("-", ""));
		return value.substring(0, 3) + "." + value.substring(3, 6) + "." + value.substring(6, 9) + "-"
				+ value.substring(9, 11);
	}
	
	public static String validaFormataRG(String value) {
		if(isRG(value)) {
			return value;
		}
		value = value.replace(".", "").replace("-", "");
		if(!isNumero(value) || value.length() != 9) {
			throw new IllegalArgumentException(Messages.ENTRADA_INVALIDA);
		}
		return value.substring(0, 2) + "." + value.substring(2, 5) + "." + value.substring(5, 8) + "-"
		+ value.substring(8, 9);
			
	}

	public static String validaEmail(String value) {
		if (!isEmail(value) && value.trim().length() > 4) {
			throw new IllegalArgumentException(Messages.ENTRADA_INVALIDA);
		}
		return value;
	}

	public static String validaQuantidadeCaracteres(String value, int quantidadeMinima) {
		if (value == null) {
			throw new NullPointerException();
		}
		if (value.length() <= quantidadeMinima) {
			throw new IllegalArgumentException(
					Messages.QUANTIDADE_CARACTERES_INVALIDA + " A quantidade minima é de " + quantidadeMinima);
		}
		return value;
	}

	public static String validaNome(String value) {
		if (isSomenteCaractere(value) && value.trim().length() >= 5) {
			return value;
		} else {
			throw new IllegalArgumentException(ENTRADA_INVALIDA + " Insira um nome completo válido");
		}
	}

	public static String validaNumeroTelefone(String numero, TelefoneType type) {
		if (type == null) {
			throw new IllegalArgumentException("Não é possivel atribuir o numero sem um tipo de telefone");
		}
		if (type == CELULAR) {
			if(!numero.contains("-")) {
				numero = numero.substring(0, 5) + "-" +
						numero.substring(5);
			}
			if (!isCelular(numero)) {
				throw new IllegalArgumentException(ENTRADA_INVALIDA);
			}
			return numero;
		}
		if(!numero.contains("-")) {
			numero = numero.substring(0, 4) + "-" + 
					numero.substring(4);
		}
		if (!isFixo(numero)) {
			throw new IllegalArgumentException(ENTRADA_INVALIDA);
		}
		return numero;
	}

}
