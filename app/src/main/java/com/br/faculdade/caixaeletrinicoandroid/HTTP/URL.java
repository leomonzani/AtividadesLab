package com.br.faculdade.caixaeletrinicoandroid.HTTP;

import static com.br.faculdade.caixaeletrinicoandroid.dao.DataController.CONTEXTO;
import static com.br.faculdade.caixaeletrinicoandroid.dao.DataController.CONTROLER;
import static com.br.faculdade.caixaeletrinicoandroid.dao.DataController.IP;
import static com.br.faculdade.caixaeletrinicoandroid.dao.DataController.PORTA;

/**
 * Created by eric on 10/10/16.
 */
public enum URL {


    CLIENTES("http://" + IP + PORTA + CONTEXTO + CONTROLER + "?acao=clientes"),
    MOVIMENTACOES("http://" + IP + PORTA + CONTEXTO + CONTROLER + "?acao=movimentacoes"),
    SACAR("http://" + IP + PORTA + CONTEXTO + CONTROLER + "?acao=sacar");


    private String url;

    URL(String url) {

        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}