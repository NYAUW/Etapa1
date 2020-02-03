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
        verificaSerialNulo(serial);
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
    
    public void verificaSerialNulo(String serial) {
        if (StringUtils.isEmpty(serial)) {
            throw new NullPointerException("O serial não pode ficar nulo!");
        }
    }

    private void verificaDefeitoCompleto(String defeito) {
        if (!defeito.contains(" ")) {
            throw new IllegalArgumentException("O defeito precisa ser especificado de maneira legivel e detalhado");
        }
    }

    private void verificaDefeitoNull(String defeito) {
        if (StringUtils.isEmpty(defeito)) {
            throw new NullPointerException("O campo de defeito não pode estar vazio");
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((defeito == null) ? 0 : defeito.hashCode());
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((serial == null) ? 0 : serial.hashCode());
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
        Orcamento other = (Orcamento) obj;
        if (defeito == null) {
            if (other.defeito != null)
                return false;
        } else if (!defeito.equals(other.defeito))
            return false;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (serial == null) {
            if (other.serial != null)
                return false;
        } else if (!serial.equals(other.serial))
            return false;
        return true;
    }
    
    
}
