package com.leonardo.dao;

import java.util.List;

public interface IGenericDAO<T, ID> {

    void salvar(T entidade);
    T buscarPorId(ID id);
    void atualizar(T entidade);
    void remover(T entidade);
    List<T> listarTodos();

}
