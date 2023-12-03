package com.sistemaestoque.app;

import java.util.ArrayList;
import java.util.List;

public class HistoricoTransacoes {
  private List<Transacao> listaTransacoes;

  public HistoricoTransacoes() {
    this.listaTransacoes = new ArrayList<Transacao>();
  }

  public void registraTransacao(Transacao transacao) {
    this.listaTransacoes.add(transacao);
  }

  public List<Transacao> getTransacoes() {
    return this.listaTransacoes;
  }
}
