package com.leonardo.exceptions;

/**
 * @author Leonardo Soares
 *
 *         Exceção personalizada para erros relacionados a operações de acesso a
 *         dados (DAO).
 *
 *         Esta exceção é lançada quando ocorre um erro durante as operações de
 *         persistência,
 *         como falhas de conexão com o banco de dados, erros de consulta, etc.
 */
public class TipoChaveNaoEncontradaException extends Exception {

    private static final long serialVersionUID = -1389494676398525746L;

    public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
