package com.sistemaestoque.app;
import com.sistemaestoque.app.exception.*;

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
	void testArmazenaUmProdutoNoEstoque() throws DescricaoEmBrancoException, ValorInvalidoException {
		Fornecedor forn = new Fornecedor(1, "Natura");
		Produto prod1 = new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, forn);
		estoque.armazenaProduto(prod1);
		assertEquals(1, estoque.listaProdutosArmazenados().size());
	}
}
