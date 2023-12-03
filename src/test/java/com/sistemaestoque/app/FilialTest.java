package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;

public class FilialTest {

    @Test
    public void testCriacaoFilial() {
        Filial filial = new Filial("FILIAL 1");

        assertNotNull(filial.getNome());
        assertEquals("FILIAL 1", filial.getNome());
    }

    @Test
    public void testAdicionaProdutoFilial() throws DescricaoEmBrancoException, ValorInvalidoException {
        Filial filial = new Filial("FILIAL 1");
        Fornecedor fornecedor = new Fornecedor(1, "Natura");;
        Produto produto = new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, fornecedor);
        filial.adicionaProdutos(produto);

        assertEquals(1, filial.listaProdutos().size());
        assertEquals(produto, filial.listaProdutos().get(0));
    }
}
