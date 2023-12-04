package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class FilialTest {

  @Test
  public void testCriacaoFilial() {
    Filial filial = new Filial("FILIAL 1");

    assertNotNull(filial.getNome());
    assertEquals("FILIAL 1", filial.getNome());
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
    filial1.adicionaProdutos(prod1);

    Produto prod2 = filial2.vendeProduto("4321");
    filial2.adicionaProdutos(prod2);

    filial1.tranfereProdutoParaFilial(filial2, prod2.getNome(), 10);

    int qtdProd1 = prod1.getQtdDisponivel();
    int qtdProd2 = prod2.getQtdDisponivel();

    assertEquals(10, qtdProd1);
    assertEquals(30, qtdProd2);
  }

}