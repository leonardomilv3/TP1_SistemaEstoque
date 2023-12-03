package com.sistemaestoque.app;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

	private List<Produto> listaProduto;

	public Estoque() {
		this.listaProduto = new ArrayList<Produto>();
	}

	public void armazenaProduto(Produto p) {
		this.listaProduto.add(p);
	}

	public List<Produto> listaProdutosArmazenados() {
		return this.listaProduto;
	}
}
