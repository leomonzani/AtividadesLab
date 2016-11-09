package com.br.faculdade.caixaeletrinicoandroid.view;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.br.faculdade.caixaeletrinicoandroid.R;
import com.br.faculdade.caixaeletrinicoandroid.model.Movimentacao;

import java.util.List;

/**
 * Created by eric on 21/10/16.
 */
public class MovimentacoesAdapter extends ArrayAdapter<Movimentacao> {

    public MovimentacoesAdapter(FragmentActivity activity, int res, List<Movimentacao> movimentacoes) {
        super(activity, res, movimentacoes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = getContext();
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.item_list_movimentacao, null);
        }

        Movimentacao movimentacao = getItem(position);

        if(movimentacao != null){
            ((TextView) v.findViewById(R.id.item_movimentacao_data)).setText(movimentacao.getDia());
            ((TextView) v.findViewById(R.id.item_movimentacao_tipo)).setText(movimentacao.getTipo());
            ((TextView) v.findViewById(R.id.item_movimentacao_valor)).setText("R$" + movimentacao.getValor());
        }

        return v;
    }
}
