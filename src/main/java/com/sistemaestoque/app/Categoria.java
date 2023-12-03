package com.sistemaestoque.app;

import com.sistemaestoque.app.exception.ValorInvalidoException;

public class Categoria {
  public String categoria;

  public Categoria(String categoria) throws ValorInvalidoException {
    if (categoria == "" || categoria == null)
      throw new ValorInvalidoException("Categoria inválida");
    this.categoria = categoria;
  }

  public String getCategoria() {
    return categoria;
  }
}
