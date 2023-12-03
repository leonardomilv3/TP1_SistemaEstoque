package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorTest {

	Fornecedor fornecedor;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.fornecedor = new Fornecedor();
	}

	@Test
	void testCadastraUmFornecedor() {
		this.fornecedor = new Fornecedor(1, "Natura");
		assertEquals(1, fornecedor.getId());
		assertEquals("Natura", fornecedor.getNomeFantasia());
	}

}
