package com.br.faculdade.caixaeletrinicoandroid.dao;

import com.br.faculdade.caixaeletrinicoandroid.HTTP.actions.AtualizadorDeMovimentacoes;
import com.br.faculdade.caixaeletrinicoandroid.HTTP.actions.CarregadorDeClientes;
import com.br.faculdade.caixaeletrinicoandroid.HTTP.actions.Sacador;
import com.br.faculdade.caixaeletrinicoandroid.model.Cliente;
import com.br.faculdade.caixaeletrinicoandroid.model.Movimentacao;

import org.json.JSONException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 05/09/16.
 */
public class DataController {

    public final static String IP = "192.168.3.105";
    public final static String PORTA = ":8080";
    public final static String CONTEXTO = "/caixa-eletronico-web/";
    public final static String CONTROLER = "api";

    private static List<Cliente> clientesRemotos = new ArrayList<>();
    private static Cliente clienteLogado = null;


    public static List<Movimentacao> getMovimentacoesDoClienteLogado() throws IllegalAccessException, IOException, JSONException {
        if(clienteLogado == null){
            throw new IllegalAccessException("Um cliente deve ter logado no sistema primeiro");
        }

        return clienteLogado.getMovimentacoes();
    }

    public static Cliente getClienteLogado() {
        return clienteLogado;
    }

    public static void saca(BigDecimal valor) {
        new Sacador(valor, clienteLogado.getConta()).executa();
        BigDecimal novoSaldo = DataController.getClienteLogado().getSaldo().subtract(valor);
        clienteLogado.setSaldo(novoSaldo);
        DataController.atualizaMovimentacoes();
    }


    public static Cliente getCliente(String conta, String agencia, String senha) {
        for(Cliente cliente : clientesRemotos){
            if(cliente.getConta().equals(conta) && cliente.getAgencia().equals(agencia)){
                if(senha != null && cliente.getSenha().equals(senha)){
                    clienteLogado = cliente;
                }
                return cliente;
            }
        }
        return null;
    }

    public static void addCliente(Cliente cliente) {
        clientesRemotos.add(cliente);
    }

    public static void addMovimentacao(Movimentacao movimentacoes) {
        clienteLogado.addMovimentacao(movimentacoes);
    }

    public static void atualizaMovimentacoes() {
        new AtualizadorDeMovimentacoes(clienteLogado.getConta()).executa();
    }

    public static void atualizaClientes() {
        new CarregadorDeClientes().executa();
    }
}
