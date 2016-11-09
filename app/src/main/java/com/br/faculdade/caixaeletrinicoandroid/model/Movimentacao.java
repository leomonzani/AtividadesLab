package com.br.faculdade.caixaeletrinicoandroid.model;

import java.math.BigDecimal;

/**
 * Created by eric on 21/10/16.
 */
public class Movimentacao {
    private String dia;
    private BigDecimal valor;
    private String tipo;

    public Movimentacao(String dia, BigDecimal valor, String tipo) {
        this.dia = dia;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getDia() {
        String[] campos = dia.split("T");
        String data = campos[0];
        String hora = campos[1];
        String[] diaCompleto = data.split("-");
        String ano = diaCompleto[0];
        String mes = diaCompleto[1];
        String dia = diaCompleto[2];

        String saida = dia + "/" +  mes + "/" + ano + " - " + hora;
        return saida;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
