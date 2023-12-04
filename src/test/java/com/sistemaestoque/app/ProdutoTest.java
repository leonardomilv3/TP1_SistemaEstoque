package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Date;
import java.util.stream.Stream;

public class ProdutoTest {

  @ParameterizedTest
  @MethodSource("produtoProvider")
  void testCadastrarProdutoValido(
      String nome,
      String descricao,
      String codigoBarras,
      float precoCusto,
      float precoVenda,
      int qtdDisponivel,
      Fornecedor fornecedor) throws DescricaoEmBrancoException, ValorInvalidoException {
    Produto produto = new Produto(nome, descricao, codigoBarras, precoCusto, precoVenda, qtdDisponivel, fornecedor,
        new Date());

    assertEquals(nome, produto.getNome());
    assertEquals(descricao, produto.getDescricao());
    assertEquals(codigoBarras, produto.getCodigoBarras());
    assertEquals(precoCusto, produto.getPrecoCusto());
    assertEquals(precoVenda, produto.getPrecoVenda());
    assertEquals(qtdDisponivel, produto.getQtdDisponivel());
    assertEquals(fornecedor, produto.getFornecedor());
  }

  static Stream<Object> produtoProvider() {
    Fornecedor fornecedor = new Fornecedor(1, "Natura");

    return Stream.of(
        new Object[] { "Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor },
        new Object[] { "Shampoo", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor },
        new Object[] { "Detergente", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor });
  }

  @Test
  void testCadastrarUmProdutoDescricaoEmBranco()
      throws DescricaoEmBrancoException, ValorInvalidoException {
    assertThrows(
        DescricaoEmBrancoException.class,
        () -> new Produto(null, null, null, 1f, 1f, 1, new Fornecedor(), new Date()));
  }

  @Test
  void testCadastrarUmProdutoValorInvalido()
      throws DescricaoEmBrancoException, ValorInvalidoException {
    assertThrows(
        ValorInvalidoException.class,
        () -> new Produto("a", "b", "c", -1f, 1f, 1, new Fornecedor(), new Date()));
  }
}
