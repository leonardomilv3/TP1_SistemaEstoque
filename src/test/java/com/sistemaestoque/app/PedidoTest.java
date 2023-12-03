package com.sistemaestoque.app;

import org.junit.jupiter.api.Test;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    public void testCriacaoClassePedidoUm() throws ValorInvalidoException, DescricaoEmBrancoException {
        Fornecedor fornecedor = new Fornecedor(1, "Natura");
        Produto produto = new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor);

        Pedido pedido = new Pedido(fornecedor, produto, 4, 500, 50.0f, Pedido.Status.FINALIZADO);

        assertEquals(1000, pedido.getValorTotal());
    }

    @Test
    public void testCriacaoClassePedidoDois() throws ValorInvalidoException, DescricaoEmBrancoException {
        Fornecedor fornecedor = new Fornecedor(1, "Natura");
        Produto produto = new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor);

        Pedido pedido = new Pedido(fornecedor, produto, 2, 750, 25.0f, Pedido.Status.FINALIZADO);

        assertEquals(1125.0f, pedido.getValorTotal());
    }
}
