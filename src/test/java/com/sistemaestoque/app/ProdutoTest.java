package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sistemaestoque.app.Fornecedor;
import com.sistemaestoque.app.Produto;

public class ProdutoTest {

	
	Produto prod;
	Fornecedor forn;
	
	@BeforeEach
	public void setup() {
		prod = new Produto();
		forn = new Fornecedor();
	}
	
	
	@Test
	void testCadastrarUmProduto() throws DescricaoEmBrancoException, ValorInvalidoException {
		prod.cadastrarProduto("Sabonete","Produto de limpeza", "0000", 2.0f, 3.0f, 20, forn);
		
		assertEquals("Sabonete", prod.getNome());
		assertEquals("Produto de limpeza", prod.getDescricao());
		assertEquals("0000", prod.getCodigoBarras());
		assertEquals(2.0f, prod.getPrecoCusto());
		assertEquals(3.0f, prod.getPrecoVenda());
		assertEquals(20, prod.getQtdDisponivel());
		assertEquals(forn, prod.getFornecedor());
	}
	
	@Test
	public void testCadastrarUmProdutoDescricaoEmBranco() throws DescricaoEmBrancoException, ValorInvalidoException {
		Assertions.assertThrows(DescricaoEmBrancoException.class,  
				() -> prod.cadastrarProduto(null, null, null, 1f, 1f, 1, forn));
	}
	
	@Test
	public void testCadastrarUmProdutoValorInvalido() throws DescricaoEmBrancoException, ValorInvalidoException {
		Assertions.assertThrows(ValorInvalidoException.class,  
				() -> prod.cadastrarProduto("a", "b", "c", -1f, 1f, 1, forn));
	}
	
}
