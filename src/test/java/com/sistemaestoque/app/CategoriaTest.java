package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import com.sistemaestoque.app.exception.ValorInvalidoException;
import org.junit.jupiter.api.Test;

public class CategoriaTest {

  @Test
  void testCadastrarCategoria() throws ValorInvalidoException {
    Categoria categoria = new Categoria("Saúde");
    assertEquals("Saúde", categoria.getCategoria());
  }

  @Test
  void testCadastrarDuasCategorias() throws ValorInvalidoException {
    Categoria categoria1 = new Categoria("Frios");
    Categoria categoria2 = new Categoria("Padaria");

    assertEquals("Frios", categoria1.getCategoria());
    assertEquals("Padaria", categoria2.getCategoria());
  }

  @Test
  void testCadastrarCategoriaInvalida() throws ValorInvalidoException {
    assertThrowsExactly(
        ValorInvalidoException.class,
        () -> {
          new Categoria("");
        });
  }
}
