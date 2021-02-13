package br.com.contmatic.constants;

public final class Messages {
	
	/********************************************************
	 *                  CONSTRUTORES                        *
	 ********************************************************/

	private Messages() {
	  throw new IllegalStateException(NAO_INSTANCIAVEL);
	}
	
	/********************************************************
	 *                      ERROS                           *
	 ********************************************************/

	public static final String NUMEROS = "Numeros Encontrados";

	public static final String ENTRADA_INVALIDA = "Entrada inválida";

	public static final String ENTRADA_NULA = "A entrada não pode ficar nula";

	public static final String CARACTERE_INVALIDO = "Caracteres Inválidos";
	
	public static final String NAO_INSTANCIAVEL = "Classe utilitaria, não é possivel instanciar";
}
