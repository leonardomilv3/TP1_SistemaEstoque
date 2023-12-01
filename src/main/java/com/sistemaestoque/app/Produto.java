package com.sistemaestoque.app;

import java.util.List;

import com.sistemaestoque.app.Fornecedor;

public class Produto {

	private String nome;
	private String descricao;
	private String codigoBarras;
	private float precoCusto;
	private float precoVenda;
	private int qtdDisponivel;	
	private Fornecedor fornecedor;
	
	public void cadastrarProduto(String nome, String descricao, String codigoBarras,
					float precoCusto, float precoVenda, int qtdDisponivel, 
					Fornecedor fornecedor) throws DescricaoEmBrancoException, ValorInvalidoException{
		
		
		if (nome == null || nome == "") {
				throw new DescricaoEmBrancoException();
		}
		if (codigoBarras == null || codigoBarras == "") {
			throw new DescricaoEmBrancoException();
		}
		if (precoCusto <= 0) {
			throw new ValorInvalidoException();
		}
		if (precoVenda <= 0) {
			throw new ValorInvalidoException();
		}
		if (qtdDisponivel <= 0) {
			throw new ValorInvalidoException();
		}
		this.nome = nome;
		this.descricao = descricao;
		this.codigoBarras = codigoBarras;	
		this.precoCusto = precoCusto;
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

    public float getPrecoCusto() {
        return precoCusto;
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

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
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
