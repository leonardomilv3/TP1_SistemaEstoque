package com.sistemaestoque.app;

import com.sistemaestoque.app.exception.CategoriaEmBrancoException;

public class Categoria {
    public String categoria;

    public Categoria(String categoria) throws CategoriaEmBrancoException{
        if(categoria == "" || categoria == null)
            throw new CategoriaEmBrancoException("Categoria inválida");
        this.categoria = categoria;
    }

    public String getCategoria(){
        return categoria;
    }
}
