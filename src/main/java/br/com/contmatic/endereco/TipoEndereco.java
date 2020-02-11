package br.com.contmatic.endereco;

public enum TipoEndereco {
                          CASA("Casa"),
                          APARTAMENTO("Apartamento"),
                          CONDOMINIO("Condominio"),
                          EMPRESARIAL("Empresarial");

    String tipo;

    private TipoEndereco(String tipo) {
        this.tipo = tipo;
    }

}
