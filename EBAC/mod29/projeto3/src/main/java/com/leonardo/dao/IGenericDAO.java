package com.leonardo.dao;

import java.util.List;

public interface IGenericDAO<T> {

    public Integer cadastrar(T entidade) throws Exception;

    public Integer atualizar(T entidade) throws  Exception;

    public T buscarEntidade(Long id) throws  Exception;

    public List<T> buscarTodos() throws Exception;

    public Integer excluirEntidade(T entidade) throws Exception;

}
