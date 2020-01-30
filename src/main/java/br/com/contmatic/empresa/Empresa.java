package br.com.contmatic.empresa;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Empresa {

    private static final String ENTRADA_INVALIDA = "Entrada inválida";

    private static final String ENTRADA_NULA = "A entrada não pode ficar nula";

    private static final String CARACTERE_INVALIDO = "Caracteres Inválidos";

    private String cnpj;

    private String nome;

    private String razaoSocial;

    List<String> proprietarios;

    public Empresa(String cnpj, String nome, String razaoSocial, List<String> proprietarios) {

        super();
        this.cnpj = cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.proprietarios = proprietarios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public List<String> getProprietarios() {
        return proprietarios;
    }

    public void setCnpj(String cnpj) {
        verificaNullCnpj(cnpj);
        verificaTamanhoCnpjValido(cnpj);
        verificaCnpjEspecial(cnpj);
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRazaoSocial(String razaoSocial) {
        verificaRazaoSocialCompleta(razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    public void setProprietarios(List<String> proprietarios) {
        verificaProprietarioNull(proprietarios);
        this.proprietarios = proprietarios;
    }

    private void verificaNullCnpj(String cnpj) {
        if (StringUtils.isEmpty(cnpj)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaTamanhoCnpjValido(String cnpj) {
        if (cnpj.length() != 14) {
            throw new IllegalArgumentException(ENTRADA_INVALIDA);
        }
    }

    private void verificaCnpjEspecial(String cnpj) {
        if (cnpj.contains("!") || cnpj.contains("@") || cnpj.contains("#") || cnpj.contains("$") || cnpj.contains("%") || cnpj.contains("¨") || cnpj.contains("&") || cnpj.contains("*") ||
            cnpj.contains("(") || cnpj.contains(")") || cnpj.contains("-") || cnpj.contains("+") || cnpj.contains("/") || cnpj.contains(".") || cnpj.contains(",") || cnpj.contains("?") ||
            cnpj.contains(";") || cnpj.contains(":") || cnpj.contains(">") || cnpj.contains("<") || cnpj.contains("\\") || cnpj.contains("'")) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }

    private void verificaRazaoSocialCompleta(String razaoSocial) {
        if (!StringUtils.containsWhitespace(razaoSocial)) {
            throw new IllegalArgumentException(ENTRADA_INVALIDA);
        }
    }

    private void verificaProprietarioNull(List<String> proprietarios) {
        if (proprietarios == null) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((proprietarios == null) ? 0 : proprietarios.hashCode());
        result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
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
        Empresa other = (Empresa) obj;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (proprietarios == null) {
            if (other.proprietarios != null)
                return false;
        } else if (!proprietarios.equals(other.proprietarios))
            return false;
        if (razaoSocial == null) {
            if (other.razaoSocial != null)
                return false;
        } else if (!razaoSocial.equals(other.razaoSocial))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empresa [cnpj=" + cnpj + ", nome=" + nome + ", razaoSocial=" + razaoSocial + ", proprietarios=" + proprietarios + "]";
    }

}
