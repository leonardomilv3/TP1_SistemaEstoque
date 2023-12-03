package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class FilialTest {

    @Test
    public void testCriacaoFilial() {
        Filial filial = new Filial("FILIAL 1");

        assertNotNull(filial.getNome());
        assertEquals("FILIAL 1", filial.getNome());
    }
}
