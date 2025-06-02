package com.leonardo.services.generic;

import java.io.Serializable;
import java.util.Collection;

import com.leonardo.dao.Persistence;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;


/**
 * @author Leonardo Soares
 *
 * Interface IGenericService que define os métodos genéricos para serviços.
 *
 * Esta interface é responsável por fornecer operações básicas de CRUD (Create, Read, Update, Delete)
 * para entidades persistentes.
 */
public interface IGenericService<T extends Persistence, E extends Serializable> {

    /**
     * Método para salvar um objeto no banco de dados.
     *
     * @param entity Objeto a ser salvo.
     * @return O objeto salvo com o ID atribuído.
     */
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para atualizar um objeto no banco de dados.
     *
     * @param entity Objeto a ser atualizado.
     */
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para excluir um objeto do banco de dados.
     *
     * @param valor ID do objeto a ser excluído.
     */
    
    public void excluir(E valor) throws DAOException;

    /**
     * Método para buscar um objeto pelo ID.
     *
     * @param id ID do objeto a ser buscado.
     * @return O objeto encontrado ou null se não existir.
     */

    public T consultarPorID(E id) throws DAOException;

    /**
     * Método para buscar todos os objetos do tipo T.
     *
     * @return Coleção de objetos do tipo T.
     */

    public Collection<T> buscarTodos() throws DAOException;
    /**
     * Método para verificar se um objeto existe no banco de dados.
     *
     * @param entity Objeto a ser verificado.
     * @return true se o objeto existir, false caso contrário.
     */

}
