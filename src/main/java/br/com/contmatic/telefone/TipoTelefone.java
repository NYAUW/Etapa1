package br.com.contmatic.telefone;

public enum TipoTelefone {
                          FIXO("Fixo"),
                          CELULAR("Celular");

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
