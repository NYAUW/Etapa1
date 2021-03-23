package br.com.contmatic.utils;

import static br.com.contmatic.constants.Messages.NAO_INSTANCIAVEL;

import java.util.Random;

public class CpfUtil {
	
	public CpfUtil() {
		throw new IllegalArgumentException(NAO_INSTANCIAVEL);
	}
	
	public static String geraCpf() {
		int primeiroDigito;
		int segundoDigito;
		Random random = new Random();
		int numeros[] = new int[9];
		primeiroDigito = calculaPrimeiroDigito(random, numeros);
		segundoDigito = calculaSegundoDigito(primeiroDigito, numeros);
		return formatCpf(primeiroDigito, segundoDigito, numeros);
	}

	private static String formatCpf(int primeiroDigito, int segundoDigito, int[] numeros) {
		StringBuilder cpf = new StringBuilder();
		for (int i : numeros) {
			cpf.append(i);
		}
		cpf.append(primeiroDigito);
		cpf.append(segundoDigito);
		return cpf.toString();
		
	}

	private static int calculaSegundoDigito(int primeiroDigito, int[] numeros) {
		int segundoDigito;
		int calculoDigito2 = (numeros[0] * 11) + (numeros[1] * 10) + (numeros[2] * 9) + (numeros[3] * 8)
				+ (numeros[4] * 7) + (numeros[5] * 6) + (numeros[6] * 5) + (numeros[7] * 4) + (numeros[8] * 3)
				+ (primeiroDigito * 2);
		int divisaoDigito2 = calculoDigito2 / 11;
		int multiplicacaoDigito2 = 11 * divisaoDigito2;
		int subtracaoDigito2 = calculoDigito2 - multiplicacaoDigito2;
		segundoDigito = 11 - subtracaoDigito2;
		segundoDigito = verificaValorDigito(segundoDigito, segundoDigito);
		return segundoDigito;
	}

	private static int verificaValorDigito(int digito, int aux) {
		if (digito >= 11) {
			digito += -digito;
		} else if (String.valueOf(aux).length() >= 2) {
			digito += -10;
		}
		return digito;
	}

	private static int calculaPrimeiroDigito(Random random, int[] numeros) {
		int primeiroDigito;
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = random.nextInt(9);
		}
		int calculoDigito1 = (numeros[0] * 10) + (numeros[1] * 9) + (numeros[2] * 8) + (numeros[3] * 7)
				+ (numeros[4] * 6) + (numeros[5] * 5) + (numeros[6] * 4) + (numeros[7] * 3) + (numeros[8] * 2);
		int divisaoDigito1 = calculoDigito1 / 11;
		int multiplicacaoDigito1 = 11 * divisaoDigito1;
		int subtracaoDigito1 = calculoDigito1 - multiplicacaoDigito1;
		primeiroDigito = 11 - subtracaoDigito1;
		primeiroDigito = verificaValorDigito(primeiroDigito, primeiroDigito);
		return primeiroDigito;
	}
	
}
