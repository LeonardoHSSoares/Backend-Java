package com.leonardo.dao;

import java.util.List;

import com.leonardo.domain.Produto;

public interface IProdutoDAO {

    public Produto cadastrar(Produto produto);

    public void excluir(Produto produto);

    public Produto atualizar(Produto produto);
    
    public List<Produto> buscar();
}
