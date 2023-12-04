package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;

public class PedidosTest {

	Pedidos pedidos;

	@BeforeEach
	public void setup() {
		pedidos = new Pedidos();
	}

	@Test
	public void cadastraUmPedidoEmPedidos() throws DescricaoEmBrancoException, ValorInvalidoException {
		Fornecedor fornecedor = new Fornecedor(1, "Natura");
		Produto produto = new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor, new Date());
		Pedido pedido = new Pedido(produto, 4, 500, 50.0f, Pedido.Status.FINALIZADO);

		assertEquals("Pedido Cadastrado", pedidos.adicionaPedido(pedido));
	}

}
