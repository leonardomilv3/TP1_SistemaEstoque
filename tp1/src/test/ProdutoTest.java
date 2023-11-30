package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Fornecedor;
import main.Produto;

class ProdutoTest {

	
	Produto p;
	Fornecedor f;
	
	@Test
	void testCadastrarProduto() {
		p = new Produto();
		f = new Fornecedor();
		System.out.println("Cadastro");
		assertEquals("Produto Cadastrado!", p.cadastrarProduto(p, f));
	}

}
