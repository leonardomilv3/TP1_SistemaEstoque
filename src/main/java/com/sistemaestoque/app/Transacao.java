package com.sistemaestoque.app;

import java.util.Date;

public class Transacao {
    private Produto produto;
    private String tipo;
    private Date data;

    public Transacao(String tipo, Produto produto) {
    }

    public Produto getProduto() {
        return new Produto();
    }

    public String getTipo() {
        return "TIPO TRANSACAO";
    }

    public Date getData() {
        return new Date();
    }
}