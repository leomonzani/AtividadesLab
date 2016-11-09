package com.br.faculdade.caixaeletrinicoandroid.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.br.faculdade.caixaeletrinicoandroid.R;
import com.br.faculdade.caixaeletrinicoandroid.dao.DataController;
import com.br.faculdade.caixaeletrinicoandroid.model.Cliente;

/**
 * Created by eric on 12/09/16.
 */
public class LoginActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private EditText editConta;
    private EditText editSenha;
    private EditText editAgencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        loadViews();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String conta = editConta.getText().toString();
                String senha = editSenha.getText().toString();
                String agencia = editAgencia.getText().toString();
                Cliente cliente = DataController.getCliente(conta, agencia, senha);

                editConta.setText("");
                editAgencia.setText("");
                editSenha.setText("");

                if(cliente != null){
                    goToMain();
                    return;
                }

            }
        });

    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void loadViews() {
        fab = (FloatingActionButton) findViewById(R.id.fab_logar);
        editConta = (EditText) findViewById(R.id.edit_text_conta);
        editSenha = (EditText) findViewById(R.id.edit_text_senha);
        editAgencia = (EditText) findViewById(R.id.edit_text_agencia);
    }
}
