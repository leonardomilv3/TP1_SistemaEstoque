package com.sistemaestoque.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class TransacaoTest {

    @Test
    public void testCriacaoTransacao() {
        Produto produto = new Produto();
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
