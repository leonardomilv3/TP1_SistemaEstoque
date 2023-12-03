package com.sistemaestoque.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HistoricoTransacoesTest {

    @Test
    public void testCriacaoTransacao() {
        Produto produto = new Produto();
        Transacao transacao = new Transacao("TIPO TRANSACAO", produto);
        HistoricoTransacoes historicoTransacoes = new HistoricoTransacoes();
        historicoTransacoes.registraTransacao(transacao);

        assertNotNull(historicoTransacoes.getTransacoes());
        assertEquals(1, historicoTransacoes.getTransacoes().size());
        assertEquals(produto, historicoTransacoes.getTransacoes().get(0).getProduto());
    }
}
