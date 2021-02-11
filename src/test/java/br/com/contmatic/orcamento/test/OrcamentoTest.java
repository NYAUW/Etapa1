package br.com.contmatic.orcamento.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.contmatic.model.Orcamento;

public class OrcamentoTest {

    @Test
    public void deve_armazernar_a_marca() {
        Orcamento orcamento = new Orcamento("Sony", "HTC2752", "NAO LIGA");
        assertTrue(orcamento.getMarca().equals("Sony"));
    }

    @Test
    public void nao_deve_armazernar_a_marca() {
        Orcamento orcamento = new Orcamento("Nintendo", "HTC2752", "NAO LIGA");
        assertFalse(orcamento.getMarca().equals("Sony"));
    }

    @Test
    public void deve_armazernar_a_marca_hashcode() {
        Orcamento orcamento = new Orcamento("Sony", "HTC2752", "NAO LIGA");
        assertEquals(orcamento.getMarca().hashCode(), orcamento.getMarca().hashCode());
    }

    @Test
    public void nao_deve_armazernar_a_marca_hashcode() throws Exception {
        Orcamento orcamento = new Orcamento("Sony", "HTC2752", "NAO LIGA");
        Orcamento orcamento2 = new Orcamento("Sony", "HTC2752", "NAO LIGA");
        orcamento2.setMarca("Nitendo");
        String marca = orcamento2.getMarca();
        assertNotEquals(orcamento.getMarca().hashCode(), marca.hashCode());
    }

    @Test
    public void deve_armazenar_serial() {
        Orcamento orcamento = new Orcamento("Philips", "XVC3421", "NAO CONECTA");

        assertTrue(orcamento.getSerial().equals("XVC3421"));
    }

    @Test
    public void nao_deve_armazenar_serial() {
        Orcamento orcamento = new Orcamento("Philips", "XVC3421", "NAO CONECTA");

        assertFalse(orcamento.getSerial().equals("XVX3431"));
    }

    @Test
    public void deve_armazenar_serial_hashcode() {
        Orcamento orcamento = new Orcamento("Nintendo", "HTC2752", "NAO LIGA");
        assertEquals(orcamento.getSerial().hashCode(), orcamento.getSerial().hashCode());
    }

    @Test
    public void nao_deve_armazernar_serial_hashcode() {
        Orcamento orcamento = new Orcamento("Sony", "HTC2752", "NAO LIGA");
        Orcamento orcamento2 = new Orcamento("Sony", "HTC2752", "NAO LIGA");
        orcamento2.setSerial("HTC2222");
        String marca = orcamento2.getSerial();
        assertNotEquals(orcamento.getSerial().hashCode(), marca.hashCode());
    }

    @Test
    public void deve_armazenar_defeito() {
        Orcamento orcamento = new Orcamento("Philips", "XVC3421", "NAO CONECTA");

        assertTrue(orcamento.getDefeito().equals("NAO CONECTA"));
    }

    @Test
    public void nao_deve_armazenar_defeito() {
        Orcamento orcamento = new Orcamento("Philips", "XVC3421", "NAO CONECTA");

        assertFalse(orcamento.getDefeito().equals("CONECTA"));
    }

    @Test
    public void deve_armazenar_defeito_hashcode() {
        Orcamento orcamento = new Orcamento("Nintendo", "HTC2752", "NAO LIGA");
        assertEquals(orcamento.getDefeito().hashCode(), orcamento.getDefeito().hashCode());
    }

    @Test
    public void nao_deve_armazernar_defeito_hashcode() throws Exception {
        Orcamento orcamento = new Orcamento("Sony", "HTC2752", "NAO LIGA");
        Orcamento orcamento2 = new Orcamento("Sony", "HTC2752", "NAO LIGA");
        orcamento2.setDefeito("Nitendo");
        String defeito = orcamento2.getDefeito();
        assertNotEquals(orcamento.getDefeito().hashCode(), defeito.hashCode());
    }

}
