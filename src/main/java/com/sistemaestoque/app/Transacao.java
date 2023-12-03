package com.sistemaestoque.app;

import java.util.Date;

public class Transacao {
    private Produto produto;
    private String tipo;
    private Date data;

    public Transacao(String tipo, Produto produto) {
        this.produto = produto;
        this.tipo = tipo;
        this.data = new Date();
    }

    public Produto getProduto() {
        return this.produto;
    }

    public String getTipo() {
        return this.tipo;
    }

    public Date getData() {
        return this.data;
    }
}