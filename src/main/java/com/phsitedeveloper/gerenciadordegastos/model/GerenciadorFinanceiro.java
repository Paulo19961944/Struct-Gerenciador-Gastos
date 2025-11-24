package com.phsitedeveloper.gerenciadordegastos.model;

import com.phsitedeveloper.gerenciadordegastos.repository.TransacaoRepository;

import java.util.List;

public class GerenciadorFinanceiro {
    private final TransacaoRepository repository;

    public GerenciadorFinanceiro() {
        this.repository = new TransacaoRepository();
    }

    public Transacao adicionarTransacao(Transacao transacao) {
        return repository.salvar(transacao);
    }

    public void removerTransacao(Long id) {
        repository.remover(id);
    }

    public List<Transacao> getTransacoes() {
        return repository.listarTodas();
    }

    public List<Transacao> getReceitas() {
        return repository.listarPorTipo("RECEITA");
    }

    public List<Transacao> getDespesas() {
        return repository.listarPorTipo("DESPESA");
    }

    public double getTotalReceitas() {
        return repository.somarPorTipo("RECEITA");
    }

    public double getTotalDespesas() {
        return repository.somarPorTipo("DESPESA");
    }

    public double getSaldo() {
        return getTotalReceitas() - getTotalDespesas();
    }
}