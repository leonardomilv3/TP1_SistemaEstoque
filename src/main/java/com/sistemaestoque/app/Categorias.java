package com.sistemaestoque.app;

import com.sistemaestoque.app.exception.DuplicadoException;
import java.util.ArrayList;

public class Categorias {
  public ArrayList<Categoria> categorias;

  public Categorias() {
    this.categorias = new ArrayList<Categoria>();
  }

  public String adiciona(Categoria novaCategoria) throws DuplicadoException {
    for (Categoria categoria : categorias) {
      if (categoria.getCategoria() == novaCategoria.getCategoria())
        throw new DuplicadoException("Categoria já existente!");
    }
    categorias.add(novaCategoria);
    return "Categoria adicionada";
  }

  public void listaTudo() {
    int index = 0;
    for (Categoria categoria : categorias) {
      System.out.println(++index + " - " + categoria.getCategoria());
    }
  }
}
