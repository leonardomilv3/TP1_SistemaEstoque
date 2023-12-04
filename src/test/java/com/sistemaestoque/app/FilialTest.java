package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
    Produto produto =
        new Produto(
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
  
  @ParameterizedTest
  @MethodSource("filialProvider")
  void testTranferenciaProdutoEntre2Filiais(
		 Filial filial1,
		 Filial filial2,
		 Produto prod,
		 Integer qtdTransferida
		 ){
	  
	  Estoque e1 = filial1.getEstoque();
	  Estoque e2 = filial2.getEstoque();
	  
	  Produto p1 = e1.consultaEstoquePorNome(prod.getNome());
	  Produto p2 = e2.consultaEstoquePorNome(prod.getNome());
	  
	  int qtdProd1Expected = p1.getQtdDisponivel();
	  int qtdProd2Expected = p2.getQtdDisponivel();
	  
	  filial1.tranfereProdutoParaFilial(filial2, prod.getNome(), qtdTransferida);
	  
	  int qtdProd1 = p1.getQtdDisponivel();
	  int qtdProd2 = p2.getQtdDisponivel();
	  
	  assertEquals(qtdProd1Expected-qtdTransferida, qtdProd1);
	  assertEquals(qtdProd2Expected+qtdTransferida, qtdProd2);
  }
  
  
  
  static Stream<Object> filialProvider() throws DescricaoEmBrancoException, ValorInvalidoException {
	  	Filial filial1 = new Filial("FILIAL 1");
	  	Filial filial2 = new Filial("FILIAL 2");
	  
	  	Fornecedor fornecedor = new Fornecedor(1, "Natura");
	    
	    Produto prod1 = new Produto("Shampoo", "Produto de limpeza", "0001", 2.0f, 3.0f, 20, fornecedor, new Date());
	    Produto prod2 = new Produto("Shampoo", "Produto de limpeza", "0002", 2.0f, 3.0f, 20, fornecedor, new Date());
	    
	    filial1.adicionaProdutos(prod1);
	    filial2.adicionaProdutos(prod2);
	    
	    return Stream.of(
	        new Object[] { filial1, filial2, prod1, 10 },
	        new Object[] { filial1, filial2, prod1, 5  },
	        new Object[] { filial1, filial2, prod1, 15 });
	  }
  
  
  
}