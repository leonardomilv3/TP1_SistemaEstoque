package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import org.junit.jupiter.api.Test;

public class HistoricoTransacoesTest {

  @Test
  public void testCriacaoTransacao() throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor fornecedor = new Fornecedor(1, "Natura");
    ;
    Produto produto =
        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor);
    Transacao transacao = new Transacao("TIPO TRANSACAO", produto);
    HistoricoTransacoes historicoTransacoes = new HistoricoTransacoes();
    historicoTransacoes.registraTransacao(transacao);

    assertNotNull(historicoTransacoes.getTransacoes());
    assertEquals(1, historicoTransacoes.getTransacoes().size());
    assertEquals(produto, historicoTransacoes.getTransacoes().get(0).getProduto());
  }
}
