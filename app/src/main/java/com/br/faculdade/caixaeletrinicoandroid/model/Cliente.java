package com.br.faculdade.caixaeletrinicoandroid.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 12/09/16.
 */
public class Cliente {

    private String nome;
    private String senha;
    private BigDecimal saldo;
    private String conta;
    private String agencia;
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    public Cliente(String nome, String senha, BigDecimal saldo, String conta, String agencia) {
        this.nome = nome;
        this.senha = senha;
        this.saldo = saldo;
        this.conta = conta;
        this.agencia = agencia;
    }

    public  String getNome() {
        return nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getConta() {
        return conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void addMovimentacao(Movimentacao movimentacoes) {
        this.movimentacoes.add(movimentacoes);
    }
}
