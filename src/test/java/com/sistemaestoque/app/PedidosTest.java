package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidosTest {

  Pedidos pedidos;

  @BeforeEach
  public void setup() {
    pedidos = new Pedidos();
  }

  @Test
  public void cadastraUmPedidoEmPedidos()
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor fornecedor = new Fornecedor(1, "Natura");
    Produto produto =
        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor, new Date());
    Pedido pedido = new Pedido(produto, 4, 500, 50.0f, Pedido.Status.FINALIZADO);
    pedidos.adicionaPedido(pedido);
    assertEquals(1, pedidos.listaTodas().size());
  }
  
  @Test
  public void cadastraDoisPedidosEmPedidos()
	  throws DescricaoEmBrancoException, ValorInvalidoException {
	  	Fornecedor fornecedor = new Fornecedor(1, "Natura");
	    Produto produto1 =
	        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor, new Date());
	    Pedido pedido1 = new Pedido(produto1, 4, 500, 50.0f, Pedido.Status.FINALIZADO);
	    Produto produto2 =
		        new Produto("Pasta de Dente", "Higiene Pessoal", "0001", 2.0f, 3.0f, 20, fornecedor, new Date());
	    Pedido pedido2 = new Pedido(produto2, 4, 500, 50.0f, Pedido.Status.FINALIZADO);
	    pedidos.adicionaPedido(pedido1);
	    pedidos.adicionaPedido(pedido2);
	    assertEquals(2, pedidos.listaTodas().size());
	  }
  
}