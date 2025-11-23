package com.phsitedeveloper.gerenciadordegastos.model;

import java.util.Date;

public class Transacao {
    private int id;
    private String descricao;
    private double valor;
    private String tipo; // "RECEITA" ou "DESPESA"
    private Date data;
    private String categoria;

    private Transacao(Builder builder) {
        this.id = builder.id;
        this.descricao = builder.descricao;
        this.valor = builder.valor;
        this.tipo = builder.tipo;
        this.data = builder.data;
        this.categoria = builder.categoria;
    }

    // Getters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
    public String getTipo() { return tipo; }
    public Date getData() { return data; }
    public String getCategoria() { return categoria; }

    public static class Builder {
        private int id;
        private String descricao;
        private double valor;
        private String tipo;
        private Date data;
        private String categoria;

        public Builder() {}

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder valor(double valor) {
            this.valor = valor;
            return this;
        }

        public Builder tipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder data(Date data) {
            this.data = data;
            return this;
        }

        public Builder categoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        public Transacao build() {
            return new Transacao(this);
        }
    }
}
