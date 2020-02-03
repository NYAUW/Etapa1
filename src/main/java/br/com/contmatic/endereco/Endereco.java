package br.com.contmatic.endereco;

import org.apache.commons.lang3.StringUtils;

public class Endereco {

    private static final String NUMEROS = "Numeros Encontrados";

    private static final String ENTRADA_INVALIDA = "Entrada inválida";

    private static final String ENTRADA_NULA = "A entrada não pode ficar nula";

    private static final String CARACTERE_INVALIDO = "Caracteres Inválidos";

    String rua;

    String bairro;

    int numero;

    String regiao;

    String cep;

    public Endereco() {
    }

    public Endereco(String rua, int numero, String bairro, String regiao, String cep) {
        super();
        this.bairro = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.regiao = regiao;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getCep() {
        return cep;
    }

    public void setRua(String rua) {
        verificaSeRuaENull(rua);
        verificaSeRuaContemNumero(rua);
        verificaSeRuaContemEspeciais(rua);
        this.bairro = rua;
    }

    public void setNumero(int numero) {
        verificaSeNumeroEZero(numero);
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        verificaSeBairroEnulo(bairro);
        verificaSeBairroContemNumero(bairro);
        verificaSeBairroContemEmpeciais(bairro);
        this.bairro = bairro;
    }

    public void setRegiao(String regiao) {
        verificaSeRegiaoEnulo(regiao);
        verificaSeRegiaoContemNumero(regiao);
        this.regiao = regiao;
    }

    public void setCep(String cep) {
        verificaSeCepENull(cep);
        verificaSeCepContemOitoDigitos(cep);
        verificaSeCepContemEspeciais(cep);
        this.cep = cep;
    }

    private void verificaSeRuaENull(String rua) {
        if (StringUtils.isEmpty(rua)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaSeRuaContemNumero(String rua) {
        if (StringUtils.isNumeric(rua)) {
            throw new IllegalArgumentException(NUMEROS);
        }
    }

    private void verificaSeRuaContemEspeciais(String rua) {
        if (rua.contains("!") || rua.contains("@") || rua.contains("#") || rua.contains("$") || rua.contains("%") || rua.contains("¨") || rua.contains("&") || rua.contains("*") || rua.contains("(") ||
            rua.contains(")") || rua.contains("-") || rua.contains("+") || rua.contains("/") || rua.contains(",") || rua.contains("?") || rua.contains(";") || rua.contains(":") ||
            rua.contains("\\") || rua.contains("'")) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }

    private void verificaSeNumeroEZero(int numero) {
        if (numero == 0) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaSeBairroEnulo(String bairro) {
        if (StringUtils.isEmpty(bairro)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaSeBairroContemNumero(String bairro) {
        if (StringUtils.isNumeric(bairro)) {
            throw new IllegalArgumentException(ENTRADA_NULA);
        }
    }

    private void verificaSeBairroContemEmpeciais(String bairro) {
        if (bairro.contains("!") || bairro.contains("@") || bairro.contains("#") || bairro.contains("$") || bairro.contains("%") || bairro.contains("¨") || bairro.contains("&") ||
            bairro.contains("*") || bairro.contains("(") || bairro.contains(")") || bairro.contains("-") || bairro.contains("+") || bairro.contains("/") || bairro.contains(",") ||
            bairro.contains("?") || bairro.contains(";") || bairro.contains(":") || bairro.contains("\\") || bairro.contains("'")) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }

    private void verificaSeRegiaoEnulo(String regiao) {
        if (StringUtils.isEmpty(regiao)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaSeRegiaoContemNumero(String regiao) {
        if (StringUtils.isNumeric(regiao)) {
            throw new IllegalArgumentException(ENTRADA_NULA);
        }
    }

    private void verificaSeCepContemOitoDigitos(String cep) {
        if (cep.length() != 8) {
            throw new IllegalArgumentException(ENTRADA_INVALIDA);
        }
    }

    private void verificaSeCepENull(String cep) {
        if (StringUtils.isEmpty(cep)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaSeCepContemEspeciais(String cep) {
        if (cep.contains("!") || cep.contains("@") || cep.contains("#") || cep.contains("$") || cep.contains("%") || cep.contains("¨") || cep.contains("&") || cep.contains("*") || cep.contains("(") ||
            cep.contains(")") || cep.contains("-") || cep.contains("+") || cep.contains("/") || cep.contains(",") || cep.contains("?") || cep.contains(";") || cep.contains(":") || cep.contains("\\") ||
            cep.contains("'")) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        result = prime * result + numero;
        result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
        result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
        Endereco other = (Endereco) obj;
        if (bairro == null) {
            if (other.bairro != null)
                return false;
        } else if (!bairro.equals(other.bairro))
            return false;
        if (cep == null) {
            if (other.cep != null)
                return false;
        } else if (!cep.equals(other.cep))
            return false;
        if (numero != other.numero)
            return false;
        if (regiao == null) {
            if (other.regiao != null)
                return false;
        } else if (!regiao.equals(other.regiao))
            return false;
        if (rua == null) {
            if (other.rua != null)
                return false;
        } else if (!rua.equals(other.rua))
            return false;
        return true;
    }
    
    

}
