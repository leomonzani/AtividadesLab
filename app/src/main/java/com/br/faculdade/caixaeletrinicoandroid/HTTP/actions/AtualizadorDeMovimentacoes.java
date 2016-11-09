package com.br.faculdade.caixaeletrinicoandroid.HTTP.actions;

import com.br.faculdade.caixaeletrinicoandroid.HTTP.HTTP;
import com.br.faculdade.caixaeletrinicoandroid.HTTP.Parameter;
import com.br.faculdade.caixaeletrinicoandroid.HTTP.URL;
import com.br.faculdade.caixaeletrinicoandroid.dao.DataController;
import com.br.faculdade.caixaeletrinicoandroid.model.Movimentacao;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;

/**
 * Created by eric on 22/10/16.
 */
public class AtualizadorDeMovimentacoes extends MyRun {

    private String conta;

    public AtualizadorDeMovimentacoes(String conta){
        this.conta = conta;
    }

    @Override
    public void run() {
        try {
            String JSON = HTTP.post(URL.MOVIMENTACOES, new Parameter("conta", conta)).body().string();
            JSONArray jsonArray = new JSONArray(JSON);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                String dia = String.valueOf(item.get("date"));
                String valor = String.valueOf(item.get("valor"));
                String tipo = String.valueOf(item.get("descricao"));
                Movimentacao movimentacoes = new Movimentacao(dia, new BigDecimal(valor), tipo);
                DataController.addMovimentacao(movimentacoes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
