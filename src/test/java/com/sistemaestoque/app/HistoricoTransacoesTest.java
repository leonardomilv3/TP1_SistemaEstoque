package com.sistemaestoque.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HistoricoTransacoesTest {

    @Test
    public void testCriacaoTransacao() throws DescricaoEmBrancoException, ValorInvalidoException {
        Fornecedor fornecedor = new Fornecedor();
        Produto produto = new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor);
        Transacao transacao = new Transacao("TIPO TRANSACAO", produto);
        HistoricoTransacoes historicoTransacoes = new HistoricoTransacoes();
        historicoTransacoes.registraTransacao(transacao);

        assertNotNull(historicoTransacoes.getTransacoes());
        assertEquals(1, historicoTransacoes.getTransacoes().size());
        assertEquals(produto, historicoTransacoes.getTransacoes().get(0).getProduto());
    }
}
