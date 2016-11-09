package com.br.faculdade.caixaeletrinicoandroid.HTTP.actions;

import com.br.faculdade.caixaeletrinicoandroid.HTTP.HTTP;
import com.br.faculdade.caixaeletrinicoandroid.HTTP.Parameter;
import com.br.faculdade.caixaeletrinicoandroid.HTTP.URL;

import java.math.BigDecimal;

/**
 * Created by eric on 22/10/16.
 */
public class Sacador extends MyRun {

    private BigDecimal valor;
    private String conta;

    public Sacador(BigDecimal valor, String conta){
        this.valor = valor;
        this.conta = conta;
    }

    @Override
    public void run() {
        try {
            HTTP.post(URL.SACAR, new Parameter("conta", conta),
                                 new Parameter("valor", valor.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
