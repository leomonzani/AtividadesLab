package com.br.faculdade.caixaeletrinicoandroid.HTTP.actions;

/**
 * Created by eric on 22/10/16.
 */
public abstract class MyRun implements Runnable {

    public void executa(){
        new Thread(this).start();
    }
}
