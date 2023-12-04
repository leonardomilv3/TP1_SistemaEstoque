package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.util.Date;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TransacaoTest {

  @ParameterizedTest
  @MethodSource("transacaoProdutoProvider")
  public void testCriacaoTransacao(String tipoTransacao, Produto produto)
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Transacao transacao = new Transacao(tipoTransacao, produto);

    assertNotNull(transacao.getProduto());
    assertEquals(produto, transacao.getProduto());

    assertNotNull(transacao.getTipo());
    assertEquals(tipoTransacao, transacao.getTipo());

    assertNotNull(transacao.getData());
    long diferencaEmMilissegundos = Math.abs(transacao.getData().getTime() - new Date().getTime());
    assertTrue(diferencaEmMilissegundos < 5000);
  }

  static Stream<Arguments> transacaoProdutoProvider() throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor fornecedor = new Fornecedor(1, "Natura");
    Produto produto1 = new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor, new Date());
    Produto produto2 = new Produto("Shampoo", "Produto de higiene", "1111", 3.0f, 4.0f, 15, fornecedor, new Date());
    Produto produto3 = new Produto("Creme", "Produto de cuidados", "2222", 4.0f, 5.0f, 10, fornecedor, new Date());

    return Stream.of(
        Arguments.of("Compra", produto1),
        Arguments.of("Venda", produto2),
        Arguments.of("Troca", produto3));
  }
}
