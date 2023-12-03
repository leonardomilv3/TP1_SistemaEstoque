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
		Fornecedor forn = new Fornecedor();
		Produto prod1 = new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, forn);
		estoque.armazenaProduto(prod1, 2);
		assertEquals(1, estoque.listaProdutosArmazenados().size());
	}

	@Test
	void testAlertaEstoqueBaixoUmProduto() throws DescricaoEmBrancoException, ValorInvalidoException {
		Fornecedor forn = new Fornecedor();
		Produto prod1 = new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 1, forn);
		estoque.adicionarObservador(new AlertaEstoqueBaixo());
		assertEquals("Produto: Sabonete | Qtd disponível: 1", estoque.notificarObservadoresBaixoEstoque(prod1));
	}

	@Test
	void testAlertaEstoqueBaixoDoisProduto() throws DescricaoEmBrancoException, ValorInvalidoException {
		Fornecedor forn = new Fornecedor();
		Produto prod1 = new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 1, forn);
		Produto prod2 = new Produto("Caixa Ovos", "Mercearia", "0001", 15.0f, 20.0f, 3, forn);

		estoque.adicionarObservador(new AlertaEstoqueBaixo());
		estoque.armazenaProduto(prod1, 2);
		estoque.armazenaProduto(prod2, 3);

		assertEquals("Produto: Sabonete | Qtd disponível: 1", estoque.notificarObservadoresBaixoEstoque(prod1));
		assertEquals("Produto: Caixa Ovos | Qtd disponível: 3", estoque.notificarObservadoresBaixoEstoque(prod2));
	}

}
