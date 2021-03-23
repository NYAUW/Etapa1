package br.com.contmatic.constants;

public class Regex {

	private Regex() {
		throw new IllegalStateException(Messages.NAO_INSTANCIAVEL);
	}
	
	public static final String ALFA = "[a-zA-Z a-zA-Z.áàâãéèêíïóôõöúçñ]*";
	
	public static final String ESPECIAIS = "[?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.]";
	
	public static final String ACENTOS = "[áàâãéèêíïóôõöúçñ]";
	
	public static final String PONTOS_TRACOS = "[.-]";
	
	public static final String NUMEROS = "^[\\d]{0,}";
	
	public static final String RG_PATTERN = "(\\d){9}";
	
	public static final String CPF = "(\\d){11}";
	
	public static final String CNPJ =  "[0-9]{14}";
	
	public static final String NUMERO_CELULAR = "(\\d{9})";
	
	public static final String DDD = "(^[\\d]{2}$*)";
	
	public static final String NUMERO_FIXO = "([0-9]{8})";
	
	public static final String EMAIL = "^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@[a-z]{2,}+(\\.[a-z]{1,5}+)*(\\.[a-z])$";

}
