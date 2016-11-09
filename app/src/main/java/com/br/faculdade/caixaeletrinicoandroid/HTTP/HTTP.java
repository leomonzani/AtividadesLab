package com.br.faculdade.caixaeletrinicoandroid.HTTP;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by eric on 10/10/16.
 */
public class HTTP {

    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build();

    public static Response get(URL url) throws IOException {

        Request request = new Request.Builder()
                .url(url.getUrl())
                .get()
                .build();
        Response response = client.newCall(request).execute();
        if(response.isSuccessful()){
            Log.i("CONEXAO", "OK");
            Log.i("CONEXAO", response.toString());
            return response;
        }
        throw new IOException("Retorno diferente de 200 - " + response.message() + " - " + response.code());
    }

    private static FormBody criaBody(Parameter... chaveValor) {
        FormBody.Builder builder = new FormBody.Builder();

        for (Parameter parameter : chaveValor) {
            builder.add(parameter.getChave(), parameter.getValor());
        }
        return builder.build();
    }

    public static Response post(URL url, Parameter... chaveValor) throws IOException {
        Request request = new Request.Builder()
                .post(criaBody(chaveValor))
                .url(url.getUrl())
                .build();

        Response response = client.newCall(request).execute();
        if(response.isSuccessful()){
            Log.i("CONEXAO", "OK");
            Log.i("CONEXAO", response.toString());
            return response;
        }
        throw new IOException("Retorno diferente de 200 - " + response.message() + " - " + response.code());
    }
}
