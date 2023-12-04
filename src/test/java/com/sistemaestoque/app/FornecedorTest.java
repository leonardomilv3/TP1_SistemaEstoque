package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class FornecedorTest {
  static Stream<Object[]> fornecedoresProvider() throws ValorInvalidoException {
    return Stream.of(
        new Object[] {1, "Natura"}, new Object[] {2, "Samsung"}, new Object[] {3, "Friboi"});
  }

  @ParameterizedTest
  @MethodSource("fornecedoresProvider")
  public void testCriacaoFornecedor(int id, String nomeFantasia)
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor fornecedor = new Fornecedor(id, nomeFantasia);

    assertEquals(fornecedor.getId(), id);
    assertEquals(fornecedor.getNomeFantasia(), nomeFantasia);
  }
}
