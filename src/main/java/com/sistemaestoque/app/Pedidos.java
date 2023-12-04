package com.sistemaestoque.app;

import java.util.ArrayList;

public class Pedidos {

  private ArrayList<Pedido> pedidos;

  public Pedidos() {
    pedidos = new ArrayList<Pedido>();
  }

  public ArrayList<Pedido> listaTodas() {
    return this.pedidos;
  }

  public void adicionaPedido(Pedido p) {
    this.pedidos.add(p);
  }
}