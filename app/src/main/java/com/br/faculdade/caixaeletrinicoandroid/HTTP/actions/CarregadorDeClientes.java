package com.br.faculdade.caixaeletrinicoandroid.HTTP.actions;

import com.br.faculdade.caixaeletrinicoandroid.HTTP.HTTP;
import com.br.faculdade.caixaeletrinicoandroid.HTTP.URL;
import com.br.faculdade.caixaeletrinicoandroid.dao.DataController;
import com.br.faculdade.caixaeletrinicoandroid.model.Cliente;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;

/**
 * Created by eric on 22/10/16.
 */
public class CarregadorDeClientes extends MyRun{
    @Override
    public void run() {
        try  {
            String JSON = HTTP.get(URL.CLIENTES).body().string();
            JSONArray jsonArray = new JSONArray(JSON);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject item = jsonArray.getJSONObject(i);
                String conta = String.valueOf(item.get("numero"));
                String agencia = String.valueOf(item.get("agencia"));
                String senha = String.valueOf(item.get("senha"));
                String saldo = String.valueOf(item.get("saldo"));
                String nome = String.valueOf(item.get("titular"));
                Cliente cliente = new Cliente(nome, senha, new BigDecimal(saldo), conta, agencia);
                DataController.addCliente(cliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
