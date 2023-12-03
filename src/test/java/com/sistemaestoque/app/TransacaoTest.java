package com.sistemaestoque.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransacaoTest {

    @Test
    public void testCriacaoTransacao() {
        Produto produto = new Produto();
        Transacao transacao = new Transacao("TIPO TRANSACAO", produto);

        assertNotNull(transacao.getProduto());
        assertNotNull(transacao.getTipo());
        assertNotNull(transacao.getData());

    }
}
