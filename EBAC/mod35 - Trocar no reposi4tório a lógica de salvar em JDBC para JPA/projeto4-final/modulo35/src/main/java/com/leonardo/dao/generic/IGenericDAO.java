package com.leonardo.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import com.leonardo.dao.Persistence;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author Leonardo Soares
 *         * Interface IGenericDAO que define os métodos genéricos para acesso a
 *         dados.
 *         * Esta interface é responsável por fornecer operações básicas de CRUD
 *         (Create, Read, Update, Delete)
 *         para entidades persistentes.
 */

public interface IGenericDAO<T extends Persistence, E extends Serializable> {

    /**
     * Método para cadastrar novos registro no banco de dados
     *
     * @param entity a ser cadastrado
     * @return retorna verdadeiro para cadastrado e falso para não cadastrado
     */
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para excluir um registro do banco de dados
     *
     * @param valor chave única do dado a ser excluído
     */
    public void excluir(E valor) throws DAOException;

    /**
     * Método para alterar um registro no bando de dados.
     *
     * @param entity a ser atualizado
     */
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para consultar um registro no banco de dados
     *
     * @param valor chave única do dado a ser consultado
     * @return
     * @throws MaisDeUmRegistroException
     * @throws TableException
     */
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;

    /**
     * Método que irá retornar todos os registros do banco de dados de uma
     * determinado dado ou tabela
     *
     * @return Registros encontrados
     * @throws DAOException
     */
    public Collection<T> buscarTodos() throws DAOException;
}
