package br.com.contmatic.cliente;

import org.apache.commons.lang3.StringUtils;

public class Cadastro {

    private static final String NUMEROS = "Numeros Encontrados";

    private static final String ENTRADA_INVALIDA = "Entrada inválida";

    private static final String CARACTERE_INVALIDO = "Caracteres Inválidos";

    private static final String ENTRADA_NULA = "A entrada não pode ficar nula";

    private String nome;

    private String email;

    private String senha;

    private String cpf;

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
        verificaNomeNull(nome);
        verificaNumeroNome(nome);
        verificaEspeciaisNome(nome);
        verificaTamanhoNome(nome);
        this.nome = nome;
    }

    public void setEmail(String email) {
        verificaEmailNull(email);
        verificaDominioEmail(email);
        this.email = email;
    }

    public void setSenha(String senha) {
        verificaSeSenhaENull(senha);
        verificaTamanhoSenha(senha);
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        verificaCpfNull(cpf);
        verificaTamanhoCpf(cpf);
        verificaCaracteresCpf(cpf);
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        verificaRgNUll(rg);
        verificaCaracteressRg(rg);
        this.rg = rg;
    }

    private void verificaEspeciaisNome(String nome) {
        if (nome.contains("@") || nome.contains("-") || nome.contains("#") || nome.contains("$") || nome.contains("%") || nome.contains("¨") || nome.contains("&") || nome.contains("*") ||
            nome.contains("(") || nome.contains(")") || nome.contains("=") || nome.contains("+") || nome.contains("/")) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }

    private void verificaNumeroNome(String nome) {
        for(int i = 0 ; nome.length() > i ; i++) {
            if (Character.isDigit(nome.charAt(i))) {
                throw new IllegalArgumentException(NUMEROS);
            }
        }
    }

    private void verificaTamanhoNome(String nome) {
        if (!StringUtils.containsWhitespace(nome)) {
            throw new IllegalArgumentException(ENTRADA_INVALIDA);
        }
    }

    private void verificaNomeNull(String nome) {
        if (StringUtils.isEmpty(nome)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaDominioEmail(String email) {
        if (!(email.contains("@") && email.contains(".com") && email.contains("gmail") || email.contains("hotmail") || email.contains("yahoo") || email.contains("contmatic") ||
            email.contains("outlook") || email.contains("ig") || email.contains("email") || email.contains("uol") || email.contains("globo"))) {
            throw new IllegalArgumentException(ENTRADA_INVALIDA);
        }
    }

    private void verificaEmailNull(String email) {
        if (StringUtils.isEmpty(email)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaCaracteresCpf(String cpf) {
        if (!StringUtils.isNumeric(cpf)) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }

    private void verificaCaracteressRg(String rg) {
        if (!StringUtils.isNumeric(rg)) {
            throw new IllegalArgumentException(CARACTERE_INVALIDO);
        }
    }

    private void verificaRgNUll(String rg) {
        if (StringUtils.isEmpty(rg)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaTamanhoCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException(ENTRADA_INVALIDA);
        }
    }

    private void verificaCpfNull(String cpf) {
        if (StringUtils.isEmpty(cpf)) {
            throw new NullPointerException(ENTRADA_NULA);
        }
    }

    private void verificaTamanhoSenha(String senha) {
        if (senha.length() < 5) {
            throw new IllegalArgumentException(ENTRADA_INVALIDA);
        }
    }

    private void verificaSeSenhaENull(String senha) {
        if (StringUtils.isEmpty(senha)) {
            throw new NullPointerException(ENTRADA_NULA);
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
