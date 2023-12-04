package com.sistemaestoque.app;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.util.Date;
import java.util.List;

public class Filial {
  private String nome;
  private Estoque estoque;

  public Filial(String nome) {
    this.estoque = new Estoque();
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public void adicionaProdutos(Produto produto) {
    this.estoque.armazenaProduto(produto);
  }

  public List<Produto> listaProdutos() {
    return this.estoque.listaProdutosArmazenados();
  }

  public Produto vendeProduto(String codigoDeBarras)
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor forn = new Fornecedor();
    Produto produto =
        new Produto(
            "Sabonete", "Produto de limpeza", codigoDeBarras, 2.0f, 3.0f, 20, forn, new Date());
    return produto;
  }
  
  public Estoque getEstoque() {
	  return this.estoque;
  }

  public void tranfereProdutoParaFilial(Filial filial2, String nomeProdutoTransferido, int qtdTranferida) {
	  Estoque estoque1 = this.getEstoque();
	  Estoque estoque2 = filial2.getEstoque();
	  
	  Produto p1 = estoque1.consultaEstoquePorNome(nomeProdutoTransferido);
	  Produto p2 = estoque2.consultaEstoquePorNome(nomeProdutoTransferido);
	  
	  p1.diminuiQtdDisponivel(qtdTranferida);
	  p2.adicionaQtdDisponivel(qtdTranferida);
  }
}