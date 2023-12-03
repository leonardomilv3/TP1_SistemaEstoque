package com.sistemaestoque.app;

import java.util.List;

public class Filial {
    private String nome;
    private Estoque estoque;

    public Filial(String nome) {
        this.estoque = new Estoque();
        this.nome = nome;
    }

    public void adicionaProdutos(Produto produto) {
        this.estoque.armazenaProduto(produto);
    }

    public List<Produto> listaProdutos() {
        return this.estoque.listaProdutosArmazenados();
    }

    public String getNome() {
        return this.nome;
    }
}