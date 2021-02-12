package br.com.contmatic.model;

import javax.naming.InsufficientResourcesException;

import br.com.contmatic.constants.ErrorsMessages;
import br.contmatic.type.RamoAtividadeType;

public class Empresa {

    private String cnpj;

    private String nome;

    private Telefone telefone;

    private Endereco endereco;

    private String razaoSocial;
    
    private RamoAtividadeType ramoAtividade;

    private String proprietarios;

    public Empresa(String cnpj, String nome, Telefone telefone, Endereco endereco, String razaoSocial,RamoAtividadeType ramo, String proprietarios) {

        super();
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.razaoSocial = razaoSocial;
        this.ramoAtividade = ramo;
        this.proprietarios = proprietarios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
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

    public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(Endereco endereco) {
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
    
    public RamoAtividadeType getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividadeType ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public void setProprietarios(String proprietarios) {
        this.proprietarios = proprietarios;
    }

    private void verificaTamanhoNome(String proprietarios) throws InsufficientResourcesException {
        if (proprietarios.length() < 8) {
            throw new InsufficientResourcesException(ErrorsMessages.ENTRADA_INVALIDA);
        }
    }

    private void verificaSeTemSobrenome() throws InsufficientResourcesException {
        if (!proprietarios.contains(" "))
            throw new InsufficientResourcesException(ErrorsMessages.ENTRADA_INVALIDA);
    }

    private void verificaNomeNumerico(String nome) {
        for(int i = 0 ; nome.length() > i ; i++) {
            if (Character.isDigit(nome.charAt(i))) {
                throw new IllegalArgumentException(ErrorsMessages.NUMEROS);
            }
        }
    }

    private void verificaNulleTamanhoCnpj(String cnpj) {
        if (cnpj == null) {
            throw new IllegalArgumentException(ErrorsMessages.ENTRADA_NULA);
        }
        if (cnpj.length() != 14) {
            throw new IllegalArgumentException(ErrorsMessages.ENTRADA_NULA);
        }
    }

    private void verificaCnpjCaracteres(String cnpj) {
        if (cnpj.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*")) {
            throw new IllegalArgumentException(ErrorsMessages.CARACTERE_INVALIDO);
        }
    }

    private void verificaCnpjEspecial(String cnpj) {
        if (cnpj.contains("!") || cnpj.contains("@") || cnpj.contains("#") || cnpj.contains("$") || cnpj.contains("%") || cnpj.contains("¨") || cnpj.contains("&") || cnpj.contains("*") ||
            cnpj.contains("(") || cnpj.contains(")") || cnpj.contains("-") || cnpj.contains("+") || cnpj.contains("/") || cnpj.contains(".") || cnpj.contains(",") || cnpj.contains("?") ||
            cnpj.contains(";") || cnpj.contains(":") || cnpj.contains(">") || cnpj.contains("<") || cnpj.contains("\\") || cnpj.contains("'")) {
            throw new IllegalArgumentException(ErrorsMessages.CARACTERE_INVALIDO);
        }
    }

    private void verificaDadosRazaoSocial(String razaoSocial) throws InsufficientResourcesException {
        if (razaoSocial.length() < 10 && !razaoSocial.contains(" ")) {
            throw new InsufficientResourcesException(ErrorsMessages.ENTRADA_INVALIDA);
        }
    }
}
