package com.phsitedeveloper.gerenciadordegastos.model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorFinanceiro {
    private List<Transacao> transacoes;
    private static int nextId = 1;

    public GerenciadorFinanceiro() {
        this.transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(Transacao transacao) {
        transacao.setId(nextId++);
        transacoes.add(transacao);
    }

    public void removerTransacao(int id) {
        transacoes.removeIf(t -> t.getId() == id);
    }

    public List<Transacao> getTransacoes() {
        return new ArrayList<>(transacoes);
    }

    public List<Transacao> getReceitas() {
        List<Transacao> receitas = new ArrayList<>();
        for (Transacao t : transacoes) {
            if ("RECEITA".equals(t.getTipo())) {
                receitas.add(t);
            }
        }
        return receitas;
    }

    public List<Transacao> getDespesas() {
        List<Transacao> despesas = new ArrayList<>();
        for (Transacao t : transacoes) {
            if ("DESPESA".equals(t.getTipo())) {
                despesas.add(t);
            }
        }
        return despesas;
    }

    public double getTotalReceitas() {
        double total = 0;
        for (Transacao t : getReceitas()) {
            total += t.getValor();
        }
        return total;
    }

    public double getTotalDespesas() {
        double total = 0;
        for (Transacao t : getDespesas()) {
            total += t.getValor();
        }
        return total;
    }

    public double getSaldo() {
        return getTotalReceitas() - getTotalDespesas();
    }
}