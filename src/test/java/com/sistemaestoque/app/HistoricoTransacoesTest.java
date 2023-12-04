package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.util.Date;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class HistoricoTransacoesTest {

  @ParameterizedTest
  @MethodSource("transacaoProdutoProvider")
  public void testCriacaoTransacao(String tipoTransacao, Produto produto)
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Transacao transacao = new Transacao(tipoTransacao, produto);
    HistoricoTransacoes historicoTransacoes = new HistoricoTransacoes();
    historicoTransacoes.registraTransacao(transacao);

    assertNotNull(historicoTransacoes.getTransacoes());
    assertEquals(1, historicoTransacoes.getTransacoes().size());
    assertEquals(produto, historicoTransacoes.getTransacoes().get(0).getProduto());
  }

  static Stream<Object[]> transacaoProdutoProvider()
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor fornecedor = new Fornecedor(1, "Natura");
    Produto produto1 =
        new Produto(
            "Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor, new Date());
    Produto produto2 =
        new Produto(
            "Shampoo", "Produto de higiene", "1111", 3.0f, 4.0f, 15, fornecedor, new Date());
    Produto produto3 =
        new Produto("Creme", "Produto de cuidados", "2222", 4.0f, 5.0f, 10, fornecedor, new Date());

    return Stream.of(
        new Object[] {"Compra", produto1},
        new Object[] {"Venda", produto2},
        new Object[] {"Troca", produto3});
  }
}
