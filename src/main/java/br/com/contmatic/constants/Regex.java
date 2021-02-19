package br.com.contmatic.constants;

public class Regex {

	private Regex() {
		throw new IllegalStateException(Messages.NAO_INSTANCIAVEL);
	}
	
	public static final String ALFA = "[a-zA-Z a-zA-Z.áàâãéèêíïóôõöúçñ]*";
	
	public static final String NOME = "[[A-Za-zÀ-ú\\'\\.]?((\\s([A-Za-zÀ-ú\\'\\.])))*]{2,60}";
	
	public static final String ESPECIAIS = "[?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.]";
	
	public static final String ACENTOS = "[áàâãéèêíïóôõöúçñ]";
	
	public static final String PONTOS_TRACOS = "[.-]";
	
	public static final String NUMEROS = "^[0-9]{0,}";
	
	public static final String RG_PATTERN = "^[0-9]{2}.[0-9]{3}.[0-9]{3}-[0-9]{1}$*";
	
	public static final String CPF = "(\\d{3}).(\\d{3}).(\\d{3})-(\\d{2})";
	
	public static final String CNPJ =  "(\\d{2}).(\\d{3}).(\\d{3})/(\\d{4}).(\\d{2})";
	
	public static final String NUMERO_CELULAR = "(\\d{5})-(\\d{4})";
	
	public static final String DDD = "(^[0-9]{2}$*)";
	
	public static final String NUMERO_FIXO = "(\\d{4})-(\\d{4})";
	
	public static final String EMAIL = "^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@[a-z]{2,}+(\\.[a-z]{1,5}+)*(\\.[a-z]{2,})$";

}
