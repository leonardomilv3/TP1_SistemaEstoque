package com.sistemaestoque.app;

import com.sistemaestoque.app.exception.CategoriaEmBrancoException;

public class Categoria {
    public String categoria;

    public String getCategoria(){
        return categoria;
    }

    public String setCategoria(String categoria) throws CategoriaEmBrancoException{
        return "Categoria criada";
    }
}
