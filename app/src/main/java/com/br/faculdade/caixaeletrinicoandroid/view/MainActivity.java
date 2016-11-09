package com.br.faculdade.caixaeletrinicoandroid.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.br.faculdade.caixaeletrinicoandroid.R;
import com.br.faculdade.caixaeletrinicoandroid.dao.DataController;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    TextView bemVindo;
    TextView saldo;
    Button botaoSacar;
    TextView editSacar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadViews();
        DataController.atualizaMovimentacoes();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMovimentacoes();
            }
        });

        bemVindo.setText(bemVindo.getText() + DataController.getClienteLogado().getNome() + "!");
        saldo.setText(DataController.getClienteLogado().getSaldo().toString());

        botaoSacar.setOnClickListener(new SacarAction());
    }

    private void goToMovimentacoes() {
        if(DataController.getClienteLogado().getMovimentacoes().size() > 0){
            Intent intent = new Intent(this, MovimentacoesActivity.class);
            startActivity(intent);
        }
    }

    private class SacarAction implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            BigDecimal valor = new BigDecimal(editSacar.getText().toString());
            DataController.saca(valor);

            saldo.setText(DataController.getClienteLogado().getSaldo().toString());
            editSacar.setText("");
        }
    }



    private void loadViews() {
        botaoSacar = (Button) findViewById(R.id.button_sacar);
        bemVindo = (TextView) findViewById(R.id.text_bem_vindo);
        saldo = (TextView) findViewById(R.id.text_saldo);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        editSacar = (TextView) findViewById(R.id.edit_text_sacar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
