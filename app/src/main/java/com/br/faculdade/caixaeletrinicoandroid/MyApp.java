package com.br.faculdade.caixaeletrinicoandroid;

import android.app.Application;

import com.br.faculdade.caixaeletrinicoandroid.dao.DataController;

/**
 * Created by eric on 21/10/16.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataController.atualizaClientes();
    }
}
