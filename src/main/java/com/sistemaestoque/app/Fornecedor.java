package com.sistemaestoque.app;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {

	private int idFornecedor;
	private String nomeFantasia;
	private static List<Fornecedor> fornecedores;
	
	public Fornecedor() {
		fornecedores = new 	ArrayList<Fornecedor>();
	}
	
	public Fornecedor(int idFornecedor, String nomeFantasia) {
		this.idFornecedor = idFornecedor;
		this.nomeFantasia = nomeFantasia;
		fornecedores.add(this);
	}

	public Integer getId() {
		return this.idFornecedor;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public static Integer qtdFornecedor() {
		return fornecedores.size();
	}
	

//	private boolean idUnico(int idFornecedor2) {
//		
//		return false;
//	}
	
	
}
