package com.sistemaestoque.app;

import java.util.Date;
import java.util.List;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;

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

    public void adicionaProdutos(Produto produto) {
        this.estoque.armazenaProduto(produto);
    }

    public List<Produto> listaProdutos() {
        return this.estoque.listaProdutosArmazenados();
    }

    public Produto vendeProduto(String codigoDeBarras) throws DescricaoEmBrancoException, ValorInvalidoException {
        Fornecedor forn = new Fornecedor();
        Produto produto = new Produto("Sabonete", "Produto de limpeza", codigoDeBarras, 2.0f, 3.0f, 20, forn,
                new Date());
        return produto;
    }
}