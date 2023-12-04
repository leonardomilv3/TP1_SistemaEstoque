package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class TransacaoTest {

  @Test
  public void testCriacaoTransacao() throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor fornecedor = new Fornecedor();
    Fornecedor forn = new Fornecedor(1, "Natura");
    ;
    Produto produto =
        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, forn, new Date());
    Transacao transacao = new Transacao("TIPO TRANSACAO", produto);

    assertNotNull(transacao.getProduto());
    assertEquals(produto, transacao.getProduto());

    assertNotNull(transacao.getTipo());
    assertEquals("TIPO TRANSACAO", transacao.getTipo());

    assertNotNull(transacao.getData());
    long diferencaEmMilissegundos = Math.abs(transacao.getData().getTime() - new Date().getTime());
    assertTrue(diferencaEmMilissegundos < 5000);
  }
}
