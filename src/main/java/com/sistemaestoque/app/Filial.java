package com.sistemaestoque.app;

import java.util.List;

public class Filial {
    private String nome;
    private Estoque estoque;

    public Filial(String nome) {
        this.estoque = new Estoque();
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}