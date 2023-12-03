package com.sistemaestoque.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estoque {

	private static final int LIMITE_MINIMO = 10;
	private Map<Produto, Integer> quantidadeProdutos;
	private List<Observador> observadores;

	public Estoque() {
		this.quantidadeProdutos = new HashMap<>();
		this.observadores = new ArrayList<Observador>();
	}

	public void armazenaProduto(Produto produto, int quantidade) {
		if (this.quantidadeProdutos.containsKey(produto)) {
			int quantidadeExistente = this.quantidadeProdutos.get(produto);
			this.quantidadeProdutos.put(produto, quantidadeExistente + quantidade);
		} else {
			this.quantidadeProdutos.put(produto, quantidade);
		}
	}

	private boolean produtoComEstoqueBaixo(Produto p) {
		// TODO Auto-generated method stub
		return p.getQtdDisponivel() <= LIMITE_MINIMO;
	}

	public Map<Produto, Integer> listaProdutosArmazenados() {
		return this.quantidadeProdutos;
	}

	public void adicionarObservador(AlertaEstoqueBaixo alertaEstoqueBaixo) {
		observadores.add(alertaEstoqueBaixo);
	}

	public String notificarObservadoresBaixoEstoque(Produto p) {
		String mensagem = "";

		for (Observador obs : observadores) {
			obs.notificarBaixoEstoque(p);
			mensagem = "Produto: " + p.getNome() + " | Qtd disponível: " + p.getQtdDisponivel();
		}

		return mensagem;
	}

}
