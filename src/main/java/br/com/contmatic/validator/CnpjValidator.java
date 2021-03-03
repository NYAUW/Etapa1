package br.com.contmatic.validator;

public class CnpjValidator {

	private static final String CNPJ_INVALIDO = "Cnpj Inválido";

	public static void isCnpjValid(String cnpj) {
		if (cnpj.length() != 14) {
			throw new IllegalArgumentException(CNPJ_INVALIDO);
		}
		String cnpjValido = cnpj.substring(0, 12);
		char[] chrCnpj = cnpj.toCharArray();
		cnpjValido = getFirstStep(cnpjValido, chrCnpj);
		cnpjValido = getSecondStepValid(cnpjValido, chrCnpj);
		if (!cnpj.equals(cnpjValido)) {
			throw new IllegalArgumentException(CNPJ_INVALIDO);
		}
	}

	private static String getSecondStepValid(String cnpjValido, char[] chrCnpj) {
		int soma = 0;
		for (int i = 0; i < 5; i++) {
			if (chrCnpj[i] - 48 >= 0 && chrCnpj[i] - 48 <= 9) {
				soma += (chrCnpj[i] - 48) * (7 - (i + 1));
			}
		}
		for (int i = 0; i < 8; i++) {
			if (chrCnpj[i + 5] - 48 >= 0 && chrCnpj[i + 5] - 48 <= 9) {
				soma += (chrCnpj[i + 5] - 48) * (10 - (i + 1));
			}
		}
		int digit = 11 - (soma % 11);
		cnpjValido += (digit == 10 || digit == 11) ? "0" : Integer.toString(digit);
		return cnpjValido;
	}

	private static String getFirstStep(String cnpjValido, char[] chrCnpj) {
		int soma = 0;
		for (int i = 0; i < 4; i++) {
			if (chrCnpj[i] - 48 >= 0 && chrCnpj[i] - 48 <= 9) {
				soma += (chrCnpj[i] - 48) * (6 - (i + 1));
			}
		}
		for (int i = 0; i < 8; i++) {
			if (chrCnpj[i + 4] - 48 >= 0 && chrCnpj[i + 4] - 48 <= 9) {
				soma += (chrCnpj[i + 4] - 48) * (10 - (i + 1));
			}
		}
		int digit = 11 - (soma % 11);
		cnpjValido += (digit == 10 || digit == 11) ? "0" : Integer.toString(digit);
		return cnpjValido;
	}
}
