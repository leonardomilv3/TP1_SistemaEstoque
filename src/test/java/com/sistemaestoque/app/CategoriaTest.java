package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sistemaestoque.app.exception.CategoriaEmBrancoException;

public class CategoriaTest {
    @Test
    void testCadastrarCategoria() throws CategoriaEmBrancoException {
        Categoria categoria = new Categoria("Saúde");
        assertEquals("Saúde", categoria.getCategoria());
    }
    
    @Test
    void testCadastrarDuasCategorias() throws CategoriaEmBrancoException {
        Categoria categoria1 = new Categoria("Frios");
        Categoria categoria2 = new Categoria("Padaria");

        assertEquals("Frios", categoria1.getCategoria());
        assertEquals("Padaria", categoria2.getCategoria());
    }
}
