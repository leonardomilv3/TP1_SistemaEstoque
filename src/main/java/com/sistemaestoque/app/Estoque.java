package com.sistemaestoque.app;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

	private List<Produto> listaProduto;
	private List<Observador> observadores;

	public Estoque() {
		this.listaProduto = new ArrayList<Produto>();
		this.observadores = new ArrayList<Observador>();
	}

	public void armazenaProduto(Produto p) {
		this.listaProduto.add(p);
	}

	public String notificarObservadoresBaixoEstoque(Produto p) {
		String mensagem = "";
		
		mensagem =  "Produto: Sabonete | Qtd disponível: 1";
		
		return mensagem;
	}

	public List<Produto> listaProdutosArmazenados() {
		return this.listaProduto;
	}

	public void adicionarObservador(AlertaEstoqueBaixo alertaEstoqueBaixo) {
		observadores.add(alertaEstoqueBaixo);
	}
}
