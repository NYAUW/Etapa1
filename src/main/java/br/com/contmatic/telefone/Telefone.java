package br.com.contmatic.telefone;

import org.apache.commons.lang3.StringUtils;

public class Telefone {
    
    private static final String NUMEROS = "Numeros Encontrados";

    private static final String ENTRADA_INVALIDA = "Entrada inválida";

    private static final String ENTRADA_NULA = "A entrada não pode ficar nula";

    private static final String CARACTERE_INVALIDO = "Caracteres Inválidos";
    
    String numero;
    
    String ramal;
    
    String tipo;

    public Telefone(String numero, String ramal, String tipo) {
        super();
        this.numero = numero;
        this.ramal = ramal;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public String getRamal() {
        return ramal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNumero(String numero) {
        verificaSeTelefoneENull(numero);
        verificaTelefoneCaracteres(numero);
        verificaSeTelefoneContemApenasNumeros(numero);
        verificaTelefoneTemDezDigitos(numero);
        this.numero = numero;
    }

    public void setRamal(String ramal) {
        verificaSeRamalENull(ramal);
        verificaSeRamalContemExatosTresDigitos(ramal);
        verificaSeRamalContemCaracteres(ramal);
        this.ramal = ramal;
    }

    public void setTipo(String tipo) {
        verificaSeTipoENUll(tipo);
        verificaSeTipoContemNumero(tipo); 
        this.tipo = tipo;
    }
    
    private void verificaTelefoneCaracteres(String numero) {
        if (StringUtils.isAlphanumeric(numero)) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }
    
    private void verificaTelefoneTemDezDigitos(String numero) {
        if (numero.length() != 10) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }
    
    private void verificaSeTelefoneContemApenasNumeros(String numero) {
        if (!StringUtils.isNumeric(numero)) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }
    
    private void verificaSeTelefoneENull(String numero) {
        if (StringUtils.isEmpty(numero)) {
            throw new IllegalArgumentException(ENTRADA_NULA);
        }
    }
    
    private void verificaSeRamalContemExatosTresDigitos(String ramal) {
        if (ramal.length() != 3) {
            throw new IllegalArgumentException(ENTRADA_INVALIDA);
        }
    }
    
    private void verificaSeRamalContemCaracteres(String ramal) {
        if (StringUtils.isAlphanumeric(ramal)) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }
    
    private void verificaSeRamalENull(String ramal) {
        if (StringUtils.isEmpty(ramal)) {
            throw new IllegalArgumentException(ENTRADA_NULA);
        }
    }
    
    private void verificaSeTipoContemNumero(String tipo) {
        if (StringUtils.isNumeric(tipo)) {
            throw new IllegalArgumentException(NUMEROS);
        }
    }
    
    private void verificaSeTipoENUll(String tipo) {
        if (StringUtils.isEmpty(tipo)) {
            throw new IllegalArgumentException(ENTRADA_NULA);
        }
    }
}
