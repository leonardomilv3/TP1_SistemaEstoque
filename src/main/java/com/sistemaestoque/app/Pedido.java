package com.sistemaestoque.app;

import com.sistemaestoque.app.exception.ValorInvalidoException;

public class Pedido {
    public enum Status {
        PENDENTE,
        FINALIZADO
    }

    private Fornecedor fornecedor;
    private Produto produto;
    private int quantidade;
    private float valorTotal;
    private float valorUnitario;
    private float desconto;
    private Status status;

    public Pedido(Fornecedor fornecedor, Produto produto, int quantidade, float valorUnitario, float desconto,
            Status status) throws ValorInvalidoException {

        if (quantidade <= 0) {
            throw new ValorInvalidoException();
        }
        if (desconto < 0) {
            throw new ValorInvalidoException();
        }
        if (valorUnitario <= 0) {
            throw new ValorInvalidoException();
        }

        this.fornecedor = fornecedor;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.desconto = desconto;
        this.status = status;
        this.valorTotal = calcularValorTotal();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.valorTotal = calcularValorTotal();
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
        this.valorTotal = calcularValorTotal();
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
        this.valorTotal = calcularValorTotal();
    }

    private float calcularValorTotal() {
        return quantidade * valorUnitario * (1 - desconto / 100);
    }
}
