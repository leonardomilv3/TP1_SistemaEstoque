package main;

public class Produto {

	private String nome;
	private String descricao;
	private String codigoBarras;
	private float custo;
	private float precoVenda;
	private int qtdDisponivel;
	
	
	
	public Produto() {
		
	}
	
	public Produto(String nome, String descricao, String codigoBarras,
					float custo, float precoVenda, int qtdDisponivel) {
		this.nome = nome;
		this.descricao = descricao;
		this.codigoBarras = codigoBarras;
		this.custo = custo;
		this.precoVenda = precoVenda;
		this.qtdDisponivel = qtdDisponivel;
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

	public String cadastrarProduto(Produto p, Fornecedor f) {
		// TODO Auto-generated method stub
		return "Produto Cadastrado!";
	}

}
