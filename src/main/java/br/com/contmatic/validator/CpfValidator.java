package br.com.contmatic.validator;

import br.com.contmatic.constants.Messages;

public class CpfValidator {
	
	private static final String INVALID = "Cpf Inválido";
	
	private CpfValidator() {
		throw new IllegalStateException(Messages.NAO_INSTANCIAVEL);
	}
	
	public static String isCpfValido(String value) {
		String bkpValue = value;
		value = value.replace(".", "").replace("-", "");
		if (value.equals("00000000000") || value.equals("11111111111") || value.equals("22222222222")
				|| value.equals("33333333333") || value.equals("44444444444") || value.equals("55555555555")
				|| value.equals("66666666666") || value.equals("77777777777") || value.equals("88888888888")
				|| value.equals("99999999999") || (value.length() != 11)) {
			throw new IllegalArgumentException(INVALID);
		}

		char dig10, dig11;
		int soma, r, num, peso;

		soma = 0;
		peso = 10;
		for (int i = 0; i < 9; i++) {
			num = (int) (value.charAt(i) - 48);
			soma = soma + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (soma % 11);
		if ((r == 10) || (r == 11))
			dig10 = '0';
		else
			dig10 = (char) (r + 48);

		soma = 0;
		peso = 11;
		for (int i = 0; i < 10; i++) {
			num = (int) (value.charAt(i) - 48);
			soma = soma + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (soma % 11);
		if ((r == 10) || (r == 11)) {
			dig11 = '0';
		} else {
			dig11 = (char) (r + 48);
		}

		if ((dig10 == value.charAt(9)) && (dig11 == value.charAt(10))) {
			return bkpValue;
		} else {
			throw new IllegalArgumentException(INVALID);
		}
		
	}

}
