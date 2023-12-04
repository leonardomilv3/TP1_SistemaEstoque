package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import com.sistemaestoque.app.exception.DuplicadoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CategoriasTest {

  @ParameterizedTest
  @MethodSource("categoriasProvider")
  void testAdicionaCategoria(Categoria categoria, String mensagemEsperada)
      throws ValorInvalidoException, DuplicadoException {
    Categorias listaCategorias = new Categorias();
    String retorno = listaCategorias.adiciona(categoria);
    assertEquals(mensagemEsperada, retorno);
  }

  static Stream<Object[]> categoriasProvider() throws ValorInvalidoException {
    return Stream.of(
        new Object[] { new Categoria("Saúde"), "Categoria adicionada" },
        new Object[] { new Categoria("Limpeza"), "Categoria adicionada" },
        new Object[] { new Categoria("Tecnologia"), "Categoria adicionada" });
  }

  @Test
  void testAdicionaCategoriaDuplicada() throws ValorInvalidoException, DuplicadoException {
    Categorias listaCategorias = new Categorias();
    Categoria novaCategoria = new Categoria("Saúde");
    listaCategorias.adiciona(novaCategoria);

    assertThrows(DuplicadoException.class, () -> listaCategorias.adiciona(novaCategoria));
  }
}
