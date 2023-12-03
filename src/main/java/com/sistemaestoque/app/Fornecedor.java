package com.sistemaestoque.app;

import java.util.List;

public class Fornecedor {

	private int idFornecedor;
	private String nomeFantasia;
	private List<Fornecedor> fornecedores;
	
	public Fornecedor() {}
	
	public Fornecedor(int idFornecedor, String nomeFantasia) {
		this.idFornecedor = idFornecedor;
		this.nomeFantasia = nomeFantasia;
	}

	public Integer getId() {
		return this.idFornecedor;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}
	
	

//	private boolean idUnico(int idFornecedor2) {
//		
//		return false;
//	}
	
	
}
