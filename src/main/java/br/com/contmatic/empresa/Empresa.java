package br.com.contmatic.empresa;

import javax.management.InvalidAttributeValueException;
import javax.naming.InsufficientResourcesException;

public class Empresa {

    private static final String NUMEROS = "Numeros Encontrados";

    private static final String ENTRADAINVALIDA = "Entrada inválida";

    private static final String ENTRADANULA = "A entrada não pode ficar nula";

    private static final String CARACTEREINVALIDO = "Caracteres Inválidos";

    private String cnpj;

    private String nome;

    private String telefone;

    private String endereco;

    private String razaoSocial;

    private String proprietarios;

    public Empresa(String cnpj, String nome, String telefone, String endereco, String razaoSocial, String proprietarios) {

        super();
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.razaoSocial = razaoSocial;
        this.proprietarios = proprietarios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getProprietarios() {
        return proprietarios;
    }

    public void setCnpj(String cnpj) {
        try {
            verificaNulleTamanhoCnpj(cnpj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            verificaCnpjCaracteres(cnpj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            verificaCnpjEspecial(cnpj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        verificaNomeNumerico(nome);
        try {
            verificaSeTemSobrenome();
        } catch (InsufficientResourcesException e) {

            e.printStackTrace();
        }
        try {
            verificaTamanhoNome(nome);
        } catch (InsufficientResourcesException e) {

            e.printStackTrace();
        }
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        try {
            verificaNullEoTamanhoTelefone(telefone);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            verificaTelefoneCaracteres(telefone);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        try {
            verificaEntradaDadosEndereco(endereco);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.endereco = endereco;
    }

    public void setRazaoSocial(String razaoSocial) {
        try {
            verificaDadosRazaoSocial(razaoSocial);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.razaoSocial = razaoSocial;
    }

    public void setProprietarios(String proprietarios) {
        this.proprietarios = proprietarios;
    }

    private void verificaTamanhoNome(String proprietarios) throws InsufficientResourcesException {
        if (proprietarios.length() < 8) {
            throw new InsufficientResourcesException(ENTRADAINVALIDA);
        }
    }

    private void verificaSeTemSobrenome() throws InsufficientResourcesException {
        if (!proprietarios.contains(" "))
            throw new InsufficientResourcesException(ENTRADAINVALIDA);
    }

    private void verificaNomeNumerico(String nome) {
        for(int i = 0 ; nome.length() > i ; i++) {
            if (Character.isDigit(nome.charAt(i))) {
                throw new IllegalArgumentException(NUMEROS);
            }
        }
    }

    private void verificaNulleTamanhoCnpj(String cnpj) {
        if (cnpj == null) {
            throw new IllegalArgumentException(ENTRADANULA);
        }
        if (cnpj.length() != 14) {
            throw new IllegalArgumentException(ENTRADANULA);
        }
    }

    private void verificaCnpjCaracteres(String cnpj) {
        if (cnpj.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*")) {
            throw new IllegalArgumentException(CARACTEREINVALIDO);
        }
    }

    private void verificaCnpjEspecial(String cnpj) {
        if (cnpj.contains("!") || cnpj.contains("@") || cnpj.contains("#") || cnpj.contains("$") || cnpj.contains("%") || cnpj.contains("¨") || cnpj.contains("&") || cnpj.contains("*") ||
            cnpj.contains("(") || cnpj.contains(")") || cnpj.contains("-") || cnpj.contains("+") || cnpj.contains("/") || cnpj.contains(".") || cnpj.contains(",") || cnpj.contains("?") ||
            cnpj.contains(";") || cnpj.contains(":") || cnpj.contains(">") || cnpj.contains("<") || cnpj.contains("\\") || cnpj.contains("'")) {
            throw new IllegalArgumentException(CARACTEREINVALIDO);
        }
    }

    private void verificaNullEoTamanhoTelefone(String telefone) throws InsufficientResourcesException, InvalidAttributeValueException {
        if (telefone == null) {
            throw new InsufficientResourcesException(ENTRADANULA);
        }
        if (telefone.length() != 8) {
            throw new InvalidAttributeValueException(ENTRADAINVALIDA);
        }
    }

    private void verificaTelefoneCaracteres(String telefone) {
        if (telefone.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*")) {
            throw new IllegalArgumentException(ENTRADAINVALIDA);
        }
    }

    private void verificaEntradaDadosEndereco(String endereco) {
        if (endereco.length() < 5 && !endereco.contains(" ")) {
            throw new IllegalArgumentException(ENTRADAINVALIDA);
        }
    }

    private void verificaDadosRazaoSocial(String razaoSocial) throws InsufficientResourcesException {
        if (razaoSocial.length() < 10 && !razaoSocial.contains(" ")) {
            throw new InsufficientResourcesException(ENTRADAINVALIDA);
        }
    }
}
