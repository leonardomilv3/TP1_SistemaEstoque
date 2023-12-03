package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sistemaestoque.app.exception.ValorInvalidoException;

public class CategoriasTest {
    @Test
    void testAdicionaCategoria() throws ValorInvalidoException{
        Categorias listaCategorias = new Categorias();
        Categoria novaCategoria = new Categoria("Saúde");
        String retorno = listaCategorias.adiciona(novaCategoria);
        assertEquals("Categoria adicionada", retorno);
    }
}
