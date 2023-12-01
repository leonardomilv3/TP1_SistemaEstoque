package com.sistemaestoque.app;

import com.sistemaestoque.app.Fornecedor;

public class Produto {

	private String nome;
	private String descricao;
	private String codigoBarras;
	private float custo;
	private float precoVenda;
	private int qtdDisponivel;	
	private Fornecedor fornecedor;
	
	
	public void cadastrarProduto(String nome, String descricao, String codigoBarras,
					float custo, float precoVenda, int qtdDisponivel, 
					Fornecedor fornecedor) {
		
		this.nome = nome;
		this.descricao = descricao;
		this.codigoBarras = codigoBarras;	
		this.custo = custo;
		this.precoVenda = precoVenda;
		this.qtdDisponivel = qtdDisponivel;
		this.fornecedor = fornecedor;
	}

	// Métodos Getters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public float getCusto() {
        return custo;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }
    
    public Fornecedor getFornecedor() {
    	return fornecedor;
    }

    // Métodos Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }
    
    public void setFornecedor(Fornecedor f) {
    	this.fornecedor = f;
    }

}
