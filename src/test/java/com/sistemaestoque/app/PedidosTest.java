package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.util.Date;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PedidosTest {

  Pedidos pedidos;

  @BeforeEach
  public void setup() {
    pedidos = new Pedidos();
  }

  @ParameterizedTest
  @MethodSource("pedidoProvider")
  public void adicionaPedidoEmPedidos(Pedido pedido)
      throws DescricaoEmBrancoException, ValorInvalidoException {
    pedidos.adicionaPedido(pedido);
    assertEquals(1, pedidos.listaTodas().size());
  }

  static Stream<Pedido> pedidoProvider() throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor fornecedor = new Fornecedor(1, "Natura");
    Produto produto1 =
        new Produto(
            "Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor, new Date());
    Produto produto2 =
        new Produto(
            "Pasta de Dente", "Higiene Pessoal", "0001", 2.0f, 3.0f, 20, fornecedor, new Date());
    Produto produto3 =
        new Produto(
            "Shampoo", "Produto para cabelo", "0002", 3.0f, 4.0f, 15, fornecedor, new Date());

    Pedido pedido1 = new Pedido(produto1, 4, 500, 50.0f, Pedido.Status.FINALIZADO);
    Pedido pedido2 = new Pedido(produto2, 4, 500, 50.0f, Pedido.Status.FINALIZADO);
    Pedido pedido3 = new Pedido(produto3, 3, 300, 30.0f, Pedido.Status.PENDENTE);

    return Stream.of(pedido1, pedido2, pedido3);
  }
}
