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
    
    public Telefone() {
    }

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
        verificaEspeciaisNumero(numero);
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
        if (StringUtils.isAlpha(numero)) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }
    
    private void verificaSeTelefoneENull(String numero) {
        if (StringUtils.isEmpty(numero)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }
    
    public void verificaEspeciaisNumero(String numero) {
        if(numero.contains("!") || numero.contains("@") || numero.contains("#") || numero.contains("$") || numero.contains("%") || numero.contains("¨")
                || numero.contains("&") || numero.contains("*") || numero.contains("(") || numero.contains(")") || numero.contains("-") || numero.contains("+") || numero.contains("/") || 
                numero.contains(".") || numero.contains(",") || numero.contains("?") || numero.contains(";") || numero.contains(":") || numero.contains(">") || numero.contains("<") || numero.contains("\\") 
                || numero.contains("'")) {
                 throw new IllegalArgumentException(CARACTERE_INVALIDO);
             }
    }
    
    private void verificaSeRamalContemExatosTresDigitos(String ramal) {
        if (ramal.length() != 3) {
            throw new IllegalArgumentException(ENTRADA_INVALIDA);
        }
    }
    
    private void verificaSeRamalContemCaracteres(String ramal) {
        if (StringUtils.isAlpha(ramal)) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }
    
    private void verificaSeRamalENull(String ramal) {
        if (StringUtils.isEmpty(ramal)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }
    
    private void verificaSeTipoContemNumero(String tipo) {
        if (StringUtils.isNumeric(tipo)) {
            throw new IllegalArgumentException(NUMEROS);
        }
    }
    
    private void verificaSeTipoENUll(String tipo) {
        if (StringUtils.isEmpty(tipo)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        result = prime * result + ((ramal == null) ? 0 : ramal.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Telefone other = (Telefone) obj;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        if (ramal == null) {
            if (other.ramal != null)
                return false;
        } else if (!ramal.equals(other.ramal))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        return true;
    }
    
    
}
