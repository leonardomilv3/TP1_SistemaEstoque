package com.sistemaestoque.app;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

	public static List<Produto> listaProduto;
		
	public void armazenaProduto(Produto p) {
		if (listaProduto == null) {
			listaProduto = new ArrayList<Produto>();
		}	
		listaProduto.add(p);
	}
}
