package br.com.contmatic.cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.br.CPF;

import br.com.contmatic.constante.Constante;

public class Cadastro {

    @NotBlank(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.SOMENTE_ALFA)
    private String nome;

    @NotNull(message = Constante.ENTRADA_NULA)
    @Email(message = Constante.ENTRADA_INVALIDA)
    private String email;

    @NotEmpty(message = Constante.ENTRADA_NULA)
    private String senha;

    @NotEmpty(message = Constante.ENTRADA_NULA)
    @CPF(message = Constante.ENTRADA_INVALIDA)
    @Pattern(regexp = "[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")
    private String cpf;

    @NotEmpty(message = Constante.ENTRADA_NULA)
    @Pattern(regexp = Constante.RG)
    private String rg;

    public Cadastro() {

    }

    public Cadastro(String nome, String email, String senha, String cpf, String rg) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
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

    public void setNome(String nome) {
        verificaNumeroNome(nome);
        verificaEspeciaisNome(nome);
        verificaTamanhoNome(nome);
        this.nome = nome;
    }

    public void setEmail(String email) {
        verificaDominioEmail(email);
        this.email = email;
    }

    public void setSenha(String senha) {
        verificaSeSenhaENull(senha);
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        verificaTamanhoCpf(cpf);
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        verificaCaracteressRg(rg);
        this.rg = rg;
    }

    private void verificaDominioEmail(String email) {
        if (!(email.contains("@") && email.contains(".com") && email.contains("gmail") || email.contains("hotmail") || email.contains("yahoo") || email.contains("contmatic") ||
            email.contains("outlook") || email.contains("ig") || email.contains("email") || email.contains("uol") || email.contains("globo"))) {
            throw new IllegalArgumentException(Constante.ENTRADA_INVALIDA);
        }
    }

    private void verificaEspeciaisNome(String nome) {
        if (nome.contains("@") || nome.contains("-") || nome.contains("#") || nome.contains("$") || nome.contains("%") || nome.contains("¨") || nome.contains("&") || nome.contains("*") ||
            nome.contains("(") || nome.contains(")") || nome.contains("=") || nome.contains("+") || nome.contains("/")) {
            throw new IllegalArgumentException(Constante.CARACTERE_INVALIDO);
        }
    }

    private void verificaTamanhoNome(String nome) {
        if (!StringUtils.containsWhitespace(nome)) {
            throw new IllegalArgumentException(Constante.ENTRADA_INVALIDA);
        }
    }

    private void verificaNumeroNome(String nome) {
        for(int i = 0 ; nome.length() > i ; i++) {
            if (Character.isDigit(nome.charAt(i))) {
                throw new IllegalArgumentException(Constante.NUMEROS);
            }
        }
    }

    private void verificaSeSenhaENull(String senha) {
        if (StringUtils.isEmpty(senha)) {
            throw new NullPointerException(Constante.ENTRADA_NULA);
        }
    }

    private void verificaCaracteressRg(String rg) {
        if (!rg.contains(".") && !rg.matches("[0-9]")) {
            throw new IllegalArgumentException(Constante.CARACTERE_INVALIDO);
        }
    }

    private void verificaTamanhoCpf(String cpf) {
        if (cpf.length() != 14) {
            throw new IllegalArgumentException(Constante.ENTRADA_INVALIDA);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((rg == null) ? 0 : rg.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
        Cadastro other = (Cadastro) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (rg == null) {
            if (other.rg != null)
                return false;
        } else if (!rg.equals(other.rg))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        return true;
    }
}
