package br.com.contmatic.telefone;

public enum TipoTelefone {
                          EMPRESARIAL("Empresarial"),
                          DOMESTICO("Domestico");

    String tipo;

    private TipoTelefone(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
