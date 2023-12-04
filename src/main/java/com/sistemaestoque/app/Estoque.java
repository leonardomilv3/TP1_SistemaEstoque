package com.sistemaestoque.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Estoque {

  private static final int LIMITE_MINIMO = 10;
  private List<Produto> listaProduto;
  private List<Observador> observadores;

  public Estoque() {
    this.listaProduto = new ArrayList<Produto>();
    this.observadores = new ArrayList<Observador>();
  }

  public void armazenaProduto(Produto p) {
    this.listaProduto.add(p);
    if (produtoComEstoqueBaixo(p)) {
      String message = notificarObservadoresBaixoEstoque(p);
    }
  }

  private boolean produtoComEstoqueBaixo(Produto p) {
    // TODO Auto-generated method stub
    return p.getQtdDisponivel() <= LIMITE_MINIMO;
  }

  public List<Produto> listaProdutosArmazenados() {
    return this.listaProduto;
  }

  public Produto consultaEstoquePorNome(String nome) {
    for (Produto p : listaProduto) {
      if (p.getNome().equals(nome)) {
        return p;
      }
    }
    return null;
  }

  public Produto consultaEstoquePorCodigo(String codigoBarras) {
    for (Produto p : listaProduto) {
      if (p.getCodigoBarras().equals(codigoBarras)) {
        return p;
      }
    }
    return null;
  }

  // Verifica se a data de validade é até 15 dias próximos da data atual e manda alerta
  public boolean alertaProdutoProximoDaValidade() {
    Date hoje = new Date();

    Calendar dataAtual = Calendar.getInstance();
    dataAtual.setTime(hoje);

    dataAtual.add(Calendar.DAY_OF_MONTH, 15);

    for (Produto p : listaProduto) {
      Date dataValidade = p.getDataValidade();
      if (dataValidade != null) {
        Calendar dataValidadeCal = Calendar.getInstance();
        dataValidadeCal.setTime(dataValidade);

        if (dataValidadeCal.before(dataAtual) || dataValidadeCal.equals(dataAtual)) {
          return true;
        }
      }
    }
    return false;
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
