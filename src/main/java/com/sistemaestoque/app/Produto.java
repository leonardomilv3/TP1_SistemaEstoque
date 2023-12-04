package com.sistemaestoque.app;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.util.Date;

public class Produto implements Observador {

  private static final int LIMITE_MINIMO = 10;
  private String nome;
  private String descricao;
  private String codigoBarras;
  private float precoCusto;
  private float precoVenda;
  private int qtdDisponivel;
  private Fornecedor fornecedor;
  private Date dataValidade;

  public Produto(
      String nome,
      String descricao,
      String codigoBarras,
      float precoCusto,
      float precoVenda,
      int qtdDisponivel,
      Fornecedor fornecedor,
      Date dataValidade)
      throws DescricaoEmBrancoException, ValorInvalidoException {

    if (nome == null || nome == "") {
      throw new DescricaoEmBrancoException("Nome inválido");
    }
    if (codigoBarras == null || codigoBarras == "") {
      throw new DescricaoEmBrancoException("Código de Barras inválido");
    }
    if (precoCusto <= 0) {
      throw new ValorInvalidoException("Preço de Custo inválido");
    }
    if (precoVenda <= 0) {
      throw new ValorInvalidoException("Preço de Venda inválido");
    }
    if (qtdDisponivel <= 0) {
      throw new ValorInvalidoException("Quantidade inválida");
    }
    this.nome = nome;
    this.descricao = descricao;
    this.codigoBarras = codigoBarras;
    this.precoCusto = precoCusto;
    this.precoVenda = precoVenda;
    this.qtdDisponivel = qtdDisponivel;
    this.fornecedor = fornecedor;
    this.dataValidade = dataValidade;
  }

  public Date getDataValidade() {
    return dataValidade;
  }

  public void setDataValidade(Date dataValidade) {
    this.dataValidade = dataValidade;
  }

  public void adicionaQtdDisponivel(Integer quantidade) {
    this.qtdDisponivel += quantidade;
    this.enviaNotificaoSeEstoqueBaixo();
  }

  public void diminuiQtdDisponivel(Integer quantidade) {
    this.qtdDisponivel -= quantidade;
    this.enviaNotificaoSeEstoqueBaixo();
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public String getCodigoBarras() {
    return codigoBarras;
  }

  public float getPrecoCusto() {
    return precoCusto;
  }

  public float getPrecoVenda() {
    return precoVenda;
  }

  public int getQtdDisponivel() {
    return qtdDisponivel;
  }

  public Fornecedor getFornecedor() {
    return fornecedor;
  }

  // Métodos Setters
  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setCodigoBarras(String codigoBarras) {
    this.codigoBarras = codigoBarras;
  }

  public void setPrecoCusto(float precoCusto) {
    this.precoCusto = precoCusto;
  }

  public void setPrecoVenda(float precoVenda) {
    this.precoVenda = precoVenda;
  }

  public void setQtdDisponivel(int qtdDisponivel) {
    this.qtdDisponivel = qtdDisponivel;
    this.enviaNotificaoSeEstoqueBaixo();
  }

  public void setFornecedor(Fornecedor f) {
    this.fornecedor = f;
  }
  
  private void enviaNotificaoSeEstoqueBaixo() {
	 if (this.qtdDisponivel <= LIMITE_MINIMO) {
	   	this.notificarBaixoEstoque(this);
	 }
  }

  @Override
  public void notificarBaixoEstoque(Produto produto) {
	System.out.println("ALERTA: " + produto.getNome() + " com estoque baixo! Qtd: " + produto.getQtdDisponivel() );
  }
}
