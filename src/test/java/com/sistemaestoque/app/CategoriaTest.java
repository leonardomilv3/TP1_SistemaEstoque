package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sistemaestoque.app.exception.CategoriaEmBrancoException;

public class CategoriaTest {
    Categoria categoria;

    @BeforeEach
    public void setup() {
        categoria = new Categoria();
    }
    @Test
    void testCadastrarCategoria() throws CategoriaEmBrancoException {
        String retorno = categoria.setCategoria("Saúde");
        assertEquals("Categoria criada", retorno);
    }
}
