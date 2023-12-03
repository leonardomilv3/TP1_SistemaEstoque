package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

  Produto prod;
  Fornecedor fornecedor, forn;

  @BeforeEach
  public void setup() throws DescricaoEmBrancoException, ValorInvalidoException {
    fornecedor = new Fornecedor();
    forn = new Fornecedor(1, "Natura");
    prod = new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, forn);
  }

  @Test
  public void testCadastrarUmProduto() throws DescricaoEmBrancoException, ValorInvalidoException {
    assertEquals("Sabonete", prod.getNome());
    assertEquals("Produto de limpeza", prod.getDescricao());
    assertEquals("0000", prod.getCodigoBarras());
    assertEquals(2.0f, prod.getPrecoCusto());
    assertEquals(3.0f, prod.getPrecoVenda());
    assertEquals(20, prod.getQtdDisponivel());
    assertEquals(forn, prod.getFornecedor());
  }

  @Test
  public void testCadastrarUmProdutoDescricaoEmBranco()
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Assertions.assertThrows(
        DescricaoEmBrancoException.class,
        () -> prod = new Produto(null, null, null, 1f, 1f, 1, forn));
  }

  @Test
  public void testCadastrarUmProdutoValorInvalido()
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Assertions.assertThrows(
        ValorInvalidoException.class, () -> prod = new Produto("a", "b", "c", -1f, 1f, 1, forn));
  }
}
