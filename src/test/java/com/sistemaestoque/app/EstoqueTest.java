package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstoqueTest {

	Estoque estoque;
	
	@BeforeEach
	public void setup() {
		estoque = new Estoque();
	}
	
	@Test
	void testArmazenaUmProdutoNoEstoque() {
		Produto prod1 = new Produto();
		estoque.armazenaProduto(prod1);
		assertEquals(1, Estoque.listaProduto.size());
	}

}
