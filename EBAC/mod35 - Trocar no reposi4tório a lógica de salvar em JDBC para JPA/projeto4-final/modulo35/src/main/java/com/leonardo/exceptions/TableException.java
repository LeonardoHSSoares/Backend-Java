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
public class TableException extends Exception {

	private static final long serialVersionUID = -7509649433607067138L;

	public TableException(String msg) {
		super(msg);
	}

}