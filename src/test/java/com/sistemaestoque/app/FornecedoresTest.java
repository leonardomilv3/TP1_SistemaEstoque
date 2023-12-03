package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sistemaestoque.app.exception.ValorInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
