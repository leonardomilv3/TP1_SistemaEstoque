package com.sistemaestoque.app;

import java.util.ArrayList;

public class Fornecedores {
  private ArrayList<Fornecedor> fornecedores;

  public Fornecedores() {
    fornecedores = new ArrayList<Fornecedor>();
  }

  public ArrayList<Fornecedor> listarFornecedores() {
    return fornecedores;
  }
}
