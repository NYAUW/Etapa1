package br.com.contmatic.features;

import javax.naming.InsufficientResourcesException;

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
        verificaNumeroMarca(marca);
        this.marca = marca;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setDefeito(String defeito) {
        try {
            verificaDefeitoValido(defeito);
        } catch (InsufficientResourcesException e) {
            e.printStackTrace();
        }
        this.defeito = defeito;
    }

    private void verificaNumeroMarca(String marca) {
        for(int i = 0 ; marca.length() > i ; i++) {
            if (Character.isDigit(marca.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void verificaDefeitoValido(String defeito) throws InsufficientResourcesException {
        if (defeito == null) {
            throw new InsufficientResourcesException("O campo de defeito não pode estar vazio");
        }
        if (defeito.contains(" ")) {
            throw new IllegalArgumentException("O defeito precisa ser especificado de maneira legivel e detalhado");
        }
    }
}
