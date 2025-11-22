package com.phsitedeveloper.gerenciadordegastos.model;

import java.util.Date;

public class Transacao {
    private int id;
    private String descricao;
    private double valor;
    private String tipo; // "RECEITA" ou "DESPESA"
    private Date data;
    private String categoria;

    public Transacao() {}

    public Transacao(int id, String descricao, double valor, String tipo, Date data, String categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.data = data;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}