package com.phsitedeveloper.gerenciadordegastos.form;

import org.apache.struts.action.ActionForm;

public class TransacaoForm extends ActionForm {
    private String descricao;
    private String valor;
    private String tipo;
    private String data;
    private String categoria;
    private String id;

    // Getters e Setters
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}