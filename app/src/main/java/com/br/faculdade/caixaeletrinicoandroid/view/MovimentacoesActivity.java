package com.br.faculdade.caixaeletrinicoandroid.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.br.faculdade.caixaeletrinicoandroid.R;
import com.br.faculdade.caixaeletrinicoandroid.dao.DataController;

/**
 * Created by eric on 21/10/16.
 */
public class MovimentacoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimentacoes);

        try {
            MovimentacoesAdapter combustivelAdapter = new MovimentacoesAdapter(this, R.layout.item_list_movimentacao, DataController.getMovimentacoesDoClienteLogado());

            ((ListView)findViewById(R.id.lista_movimentacoes)).setAdapter(combustivelAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
