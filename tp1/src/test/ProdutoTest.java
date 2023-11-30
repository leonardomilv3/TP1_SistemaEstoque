package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.Fornecedor;
import main.Produto;

public class ProdutoTest {

	
	Produto prod;
	Fornecedor forn;
	
	@Before
	public void setup() {
		prod = new Produto();
		forn = new Fornecedor();
	}
	
	
	@Test
	void testCadastrarUmProduto() {
		prod = new Produto();
		forn = new Fornecedor();
		
		prod.cadastrarProduto("Sabonete","Produto de limpeza", "0000", 2.0f, 3.0f, 20, forn);
		
		assertEquals("Sabonete", prod.getNome());
		assertEquals("Produto de limpeza", prod.getDescricao());
		assertEquals("0000", prod.getCodigoBarras());
		assertEquals(2.0f, prod.getCusto());
		assertEquals(3.0f, prod.getPrecoVenda());
		assertEquals(20, prod.getQtdDisponivel());
		assertEquals(forn, prod.getFornecedor());
	}

}
