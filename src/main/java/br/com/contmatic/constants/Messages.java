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

	public static final String NUMEROS = "Foram encontrados numeros em um campo que deveria ser apenas caracteres";

	public static final String ENTRADA_INVALIDA = "Entrada inválida, o formato em que o dado foi inserido não é válido";
	
	public static final String QUANTIDADE_CARACTERES_INVALIDA = "A quantidade de caracteres inseridos não é válida";
	
	public static final String QUANTIDADE_INVALIDA = "A quantidade inserida não é válida";
	
	public static final String MENOR_IGUAL_ZERO = "O valor inserido é menor que zero!";

	public static final String ENTRADA_NULA = "A entrada não pode ficar nula";
	
	public static final String CARACTERE_INVALIDO = "Foram encontrados caracteres em um campo que deveria ser apenas numeros";
	
	public static final String NAO_INSTANCIAVEL = "Classe utilitaria, não é possivel instanciar";

}
