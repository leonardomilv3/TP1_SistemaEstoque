package com.sistemaestoque.app;

import java.util.ArrayList;

public class Categorias {
    public ArrayList<Categoria> categorias;
    
    public Categorias() {
        this.categorias = new ArrayList<Categoria>();
    }
    
    public String adiciona(Categoria categoria) {
        categorias.add(categoria);
        return "Categoria adicionada";
    }
    
}
