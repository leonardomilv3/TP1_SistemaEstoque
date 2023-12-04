package com.sistemaestoque.app;


public class Fornecedor {

  private int idFornecedor;
  private String nomeFantasia;

  public Fornecedor() {
    // fornecedores = new 	ArrayList<Fornecedor>();
  }

  public Fornecedor(int idFornecedor, String nomeFantasia) {
    this.idFornecedor = idFornecedor;
    this.nomeFantasia = nomeFantasia;
  }

  public Integer getId() {
    return this.idFornecedor;
  }

  public String getNomeFantasia() {
    return this.nomeFantasia;
  }

  //	private boolean idUnico(int idFornecedor2) {
  //
  //		return false;
  //	}

}
