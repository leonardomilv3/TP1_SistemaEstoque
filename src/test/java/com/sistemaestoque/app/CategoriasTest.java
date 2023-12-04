package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.sistemaestoque.app.exception.DuplicadoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CategoriasTest {

  @ParameterizedTest
  @MethodSource("categoriasProvider")
  void testAdicionaCategoria(Categoria categoria)
      throws ValorInvalidoException, DuplicadoException {
    Categorias listaCategorias = new Categorias();
    String retorno = listaCategorias.adiciona(categoria);
    assertEquals("Categoria adicionada", retorno);
  }

  static Stream<Object[]> categoriasProvider() throws ValorInvalidoException {
    return Stream.of(
        new Object[] {new Categoria("Saúde")},
        new Object[] {new Categoria("Limpeza")},
        new Object[] {new Categoria("Tecnologia")});
  }

  @Test
  void testAdicionaCategoriaDuplicada() throws ValorInvalidoException, DuplicadoException {
    Categorias listaCategorias = new Categorias();
    Categoria novaCategoria = new Categoria("Saúde");
    listaCategorias.adiciona(novaCategoria);

    assertThrows(DuplicadoException.class, () -> listaCategorias.adiciona(novaCategoria));
  }
}
