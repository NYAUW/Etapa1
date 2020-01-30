package br.com.contmatic.cliente;

import org.apache.commons.lang3.StringUtils;

public class Orcamento {

    private String marca;

    private String serial;

    private String defeito;

    public Orcamento(String marca, String serial, String defeito) {
        super();
        this.marca = marca;
        this.serial = serial;
        this.defeito = defeito;
    }

    public String getMarca() {
        return marca;
    }

    public String getSerial() {
        return serial;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setMarca(String marca) {
        verificaMarcaNula(marca);
        verificaNumeroMarca(marca);
        this.marca = marca;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setDefeito(String defeito) {
        verificaDefeitoNull(defeito);
        verificaDefeitoCompleto(defeito);
        this.defeito = defeito;
    }

    private void verificaMarcaNula(String marca) {
        if (StringUtils.isEmpty(marca)) {
            throw new NullPointerException("A marca não pode ficar nula!");
        }
    }

    private void verificaNumeroMarca(String marca) {
        if (StringUtils.isNumeric(marca)) {
            throw new IllegalArgumentException("A marca nao pode conter numeros");
        }
    }

    private void verificaDefeitoCompleto(String defeito) {
        if (defeito.contains(" ")) {
            throw new IllegalArgumentException("O defeito precisa ser especificado de maneira legivel e detalhado");
        }
    }

    private void verificaDefeitoNull(String defeito) {
        if (StringUtils.isEmpty(defeito)) {
            throw new NullPointerException("O campo de defeito não pode estar vazio");
        }
    }
}
