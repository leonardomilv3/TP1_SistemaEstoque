package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.stream.Stream;

import com.sistemaestoque.app.exception.ValorInvalidoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CategoriaTest {

  static Stream<Object> categoriaProvider() {
    return Stream.of(
        new Object[] { "Saúde" },
        new Object[] { "Frios" },
        new Object[] { "Limpeza"});
  }

  @ParameterizedTest
  @MethodSource("categoriaProvider")
  void testCadastrarCategoria(String name) throws ValorInvalidoException {
    Categoria categoria = new Categoria(name);
    assertEquals(categoria.getCategoria(), name);
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
