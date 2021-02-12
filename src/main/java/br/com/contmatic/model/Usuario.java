package br.com.contmatic.model;

import javax.naming.InsufficientResourcesException;

import br.com.contmatic.constants.Messages;

public class Usuario {

    private String nome;

    private String email;

    private String senha;

    private String cpf;

    private String rg;

    private Endereco endereco;

    private String telefone;

    public Usuario(String nome, String email, String senha, String cpf, String rg, Endereco endereco, String telefone) {
        super();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTel() {
        return telefone;
    }

    public void setNome(String nome) {
        verificaNumeroNome(nome);
        verificaEspeciaisNome(nome);
        verificaTamanhoNome();
        this.nome = nome;
    }

    public void setEmail(String email) {
        verificaDominioEmail(nome);
        this.email = email;
    }

    public void setSenha(String senha) {
        verificaTamanhoSenha(nome);
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        try {
            verificaTamanhoCpf(cpf);
        } catch (InsufficientResourcesException e) {
            e.printStackTrace();
        }
        verificaEntradaDadosCpf(cpf);
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        verificaEntradaDadosRg(rg);
        this.rg = rg;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTel(String telefone) {
        verificDadosEntradaTelefone(telefone);
        this.telefone = telefone;
    }

    private void verificaEspeciaisNome(String nome) {
        if (nome.contains("@") || nome.contains("-") || nome.contains("#") || nome.contains("$") || nome.contains("%") || nome.contains("¨") || nome.contains("&") || nome.contains("*") ||
            nome.contains("(") || nome.contains(")") || nome.contains("=") || nome.contains("+") || nome.contains("/")) {
            throw new IllegalArgumentException(Messages.CARACTERE_INVALIDO);
        }
    }

    private void verificaNumeroNome(String nome) {
        for(int i = 0 ; nome.length() > i ; i++) {
            if (Character.isDigit(nome.charAt(i))) {
                throw new IllegalArgumentException(Messages.NUMEROS);
            }
        }
    }
    private void verificaTamanhoNome() {
        if(nome.length() < 5 && nome.length() > 50) {
            throw new IllegalArgumentException(Messages.ENTRADA_INVALIDA);
        }
    }
    private void verificaDominioEmail(String email) {
        if (email.contains("@") && email.contains(".com") && email.contains("gmail") || email.contains("hotmail") || email.contains("yahoo") || email.contains("contmatic") ||
            email.contains("outlook") || email.contains("ig") || email.contains("email") || email.contains("uol") || email.contains("globo")) {
            throw new IllegalAccessError(Messages.ENTRADA_INVALIDA);
        }
    }

    private void verificaEntradaDadosCpf(String cpf) {
        if (cpf.contains(".") || cpf.contains(" ") || cpf.contains("/")) {
            throw new IllegalArgumentException(Messages.CARACTERE_INVALIDO);
        }
    }

    private void verificaEntradaDadosRg(String rg) {
        if (rg.length() != 9 && rg.contains(".") || rg.contains(" ") || rg.contains("/")) {
            throw new IllegalArgumentException(Messages.CARACTERE_INVALIDO);
        }
    }

    private void verificaTamanhoCpf(String cpf) throws InsufficientResourcesException {
        if (cpf.length() != 11) {
            throw new InsufficientResourcesException(Messages.ENTRADA_INVALIDA);
        }
    }


    private void verificDadosEntradaTelefone(String tel) {
        if (tel.length() != 10 && tel.contains(".") || tel.contains(" ") || tel.contains("/")) {
            throw new IllegalArgumentException(Messages.ENTRADA_INVALIDA);
        }
    }

    private void verificaTamanhoSenha(String senha) {
        if (!(senha.length() <= 5) && !(senha.length() >= 8)) {
            throw new IllegalArgumentException(Messages.ENTRADA_INVALIDA);
        }
    }
}
