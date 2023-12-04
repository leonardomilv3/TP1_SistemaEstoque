package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FornecedoresTest {

  Fornecedores fornecedoresDb;

  @BeforeEach
  public void setup() {
    fornecedoresDb = new Fornecedores();
  }

  @Test
  void testListarFornecedores() throws ValorInvalidoException {
    assertEquals(true, fornecedoresDb.listarFornecedores().isEmpty());
  }

  @ParameterizedTest
  @MethodSource("fornecedorProvider")
  void testCadastraFornecedor(Fornecedor fornecedor) {
    fornecedoresDb.cadastraFornecedor(fornecedor);
    assertEquals(1, fornecedoresDb.listarFornecedores().size());
  }

  static Stream<Fornecedor> fornecedorProvider() {
    return Stream.of(
        new Fornecedor(1, "JBS"), new Fornecedor(2, "Natura"), new Fornecedor(3, "Sony"));
  }
}
