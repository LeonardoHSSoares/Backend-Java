package com.leonardo.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import com.leonardo.dao.Persistence;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericDAO<T extends Persistence, E extends Serializable> {

    /**
     * Método para salvar um objeto no banco de dados.
     *
     * @param entity Objeto a ser salvo.
     * @return O objeto salvo com o ID atribuído.
     * @throws TipoChaveNaoEncontradaException Se a chave do objeto não for
     *                                         encontrada.
     * @throws DAOException                    Se ocorrer um erro ao acessar o banco
     *                                         de dados.
     */
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para atualizar um objeto no banco de dados.
     *
     * @param entity Objeto a ser atualizado.
     * @return O objeto atualizado.
     * @throws TipoChaveNaoEncontradaException Se a chave do objeto não for
     *                                         encontrada.
     * @throws DAOException                    Se ocorrer um erro ao acessar o banco
     *                                         de dados.
     */
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para excluir um objeto do banco de dados.
     *
     * @param id ID do objeto a ser excluído.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void excluir(E valor) throws DAOException;

    /**
     * Método para buscar um objeto pelo ID.
     *
     * @param id ID do objeto a ser buscado.
     * @return O objeto encontrado ou null se não existir.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     * @throws TipoChaveNaoEncontradaException Se a chave do objeto não for encontrada.
     */
    public T consultarPorID(E id) throws MaisDeUmRegistroException, TableException, DAOException;

    /**
     * Método para buscar todos os objetos do tipo T.
     *
     * @return Coleção de objetos do tipo T.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    public Collection<T> buscarTodos() throws DAOException;

}
