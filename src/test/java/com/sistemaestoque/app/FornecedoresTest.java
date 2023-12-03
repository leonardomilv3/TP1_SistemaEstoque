package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.sistemaestoque.app.exception.ValorInvalidoException;

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

