package br.com.contmatic.constante;

/**
 * The Class Constante.
 */
public final class Constante {

    /** The Constant NUMEROS. */
    public static final String NUMEROS = "Numeros Encontrados";

    /** The Constant ENTRADA_INVALIDA. */
    public static final String ENTRADA_INVALIDA = "Entrada inválida";

    /** The Constant CARACTERE_INVALIDO. */
    public static final String CARACTERE_INVALIDO = "Caracteres Inválidos";

    /** The Constant ENTRADA_NULA. */
    public static final String ENTRADA_NULA = "A entrada não pode ficar nula";

    /** The Constant SOMENTE_ALFA. */
    public static final String SOMENTE_ALFA = "^[a-z A-Z.áàâãéèêíïóôõöúçñ]*$";

    /** The Constant SOMENTE_NUMEROS. */
    public static final String SOMENTE_NUMEROS = "^[0-9]$*";

    /** The Constant RG. */
    public static final String RG = "[0-9]{1}.[0-9]{3}.[0-9]{3}-[0-9]{2}";

    /** The Constant SERIAL. */
    public static final String SERIAL = "[A-Z]{3}[0-9]{3}";

    /** The Constant NUMERO_TEEFONE. */
    public static final String NUMERO_TELEFONE = "(([1][1-9])|([2][1-2])|([2][4-8])|([3][1-5])|([3][7-8])|([4][1-9])|([5][1])|([5][3-5])|([6][1-9])|([7][1])|([7][3-5])|([7][7])|([7][9])|([8][1-9]))(([0-9]{8})|([0-9]{9}))";

    /** The Constant RAMAL. */
    public static final String RAMAL = ("[0-9]{3}");

    private Constante() {

    }

}
