package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.util.Date;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PedidoTest {

  @ParameterizedTest
  @MethodSource("getParameters")
  public void testCriacaoClassePedido(
      int quantidade, int valorUnitario, float desconto, float totalEsperado)
      throws ValorInvalidoException, DescricaoEmBrancoException {
    Fornecedor fornecedor = new Fornecedor(1, "Natura");
    Produto produto =
        new Produto(
            "Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor, new Date());

    Pedido pedido =
        new Pedido(produto, quantidade, valorUnitario, desconto, Pedido.Status.FINALIZADO);

    assertEquals(totalEsperado, pedido.getValorTotal());
  }

  private static Stream<Object[]> getParameters() {
    return Stream.of(
        new Object[] {4, 500, 50.0f, 1000.0f},
        new Object[] {2, 750, 25.0f, 1125.0f},
        new Object[] {1, 750, 0f, 750.0f});
  }

  @Test
  void testCadastrarPedidoInvalido() throws ValorInvalidoException {
    assertThrowsExactly(
        ValorInvalidoException.class,
        () -> {
          Fornecedor fornecedor = new Fornecedor(1, "Natura");
          Produto produto =
              new Produto(
                  "Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor, new Date());

          new Pedido(produto, -1, -1, -1, Pedido.Status.FINALIZADO);
        });
  }
}
