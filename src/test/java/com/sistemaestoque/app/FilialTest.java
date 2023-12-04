package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FilialTest {

  @ParameterizedTest
  @MethodSource("nomesFiliaisProvider")
  public void testCriacaoFilial(String nomeFilial) {
    Filial filial = new Filial(nomeFilial);

    assertNotNull(filial.getNome());
    assertEquals(nomeFilial, filial.getNome());
  }

  static Collection<String> nomesFiliaisProvider() {
    return Arrays.asList("FILIAL 1", "FILIAL 2", "FILIAL 3");
  }

  @Test
  public void testAdicionaProdutoFilial()
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Filial filial = new Filial("FILIAL 1");
    Fornecedor fornecedor = new Fornecedor();
    Produto produto = new Produto(
        "Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor, new Date());
    filial.adicionaProdutos(produto);

    assertEquals(1, filial.listaProdutos().size());
    assertEquals(produto, filial.listaProdutos().get(0));
  }

  @Test
  public void testVendeProduto() throws DescricaoEmBrancoException, ValorInvalidoException {
    Filial filial = new Filial("FILIAL 1");
    Produto produtoVendido = filial.vendeProduto("1234");

    assertEquals("1234", produtoVendido.getCodigoBarras());
  }

  @Test
  public void testTranferenciaUmProdutoEntre2Filiais() throws DescricaoEmBrancoException, ValorInvalidoException {
    Filial filial1 = new Filial("FILIAL 1");
    Filial filial2 = new Filial("FILIAL 2");

    Produto prod1 = filial1.vendeProduto("1234");
    Produto prod2 = filial2.vendeProduto("4321");

    assertEquals(10, filial1.tranfereProdutoParaFilial(filial2, 10));
  }

}
