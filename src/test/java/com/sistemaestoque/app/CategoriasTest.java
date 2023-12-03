package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import com.sistemaestoque.app.exception.DuplicadoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import org.junit.jupiter.api.Test;

public class CategoriasTest {
  @Test
  void testAdicionaCategoria() throws ValorInvalidoException, DuplicadoException {
    Categorias listaCategorias = new Categorias();
    Categoria novaCategoria = new Categoria("Saúde");
    String retorno = listaCategorias.adiciona(novaCategoria);
    assertEquals("Categoria adicionada", retorno);
  }

  @Test
  void testAdicionaDuasCategorias() throws ValorInvalidoException, DuplicadoException {
    Categorias listaCategorias = new Categorias();
    Categoria novaCategoria = new Categoria("Saúde");
    Categoria novaCategoria1 = new Categoria("Limpeza");
    String retorno = listaCategorias.adiciona(novaCategoria);
    String retorno1 = listaCategorias.adiciona(novaCategoria1);
    assertEquals("Categoria adicionada", retorno);
    assertEquals("Categoria adicionada", retorno1);
  }

  @Test
  void testAdicionaCategoriaDuplicada() throws ValorInvalidoException, DuplicadoException {
    Categorias listaCategorias = new Categorias();
    Categoria novaCategoria = new Categoria("Saúde");
    Categoria novaCategoria1 = new Categoria("Saúde");
    listaCategorias.adiciona(novaCategoria);
    assertThrowsExactly(
        DuplicadoException.class,
        () -> {
          listaCategorias.adiciona(novaCategoria1);
        });
  }
}
