package com.leonardo.dao;

import java.util.List;

public interface GenericDAO<T> {
    void cadastrar(T entidade);
    void atualizar(T entidade);
    T consultar(Long id);
    List<T> buscarTodos();
}