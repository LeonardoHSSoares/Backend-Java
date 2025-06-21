package com.leonardo.exceptions;

/**
 * @author Leonardo Soares
 *
 *         Exceção personalizada para indicar que mais de um registro foi
 *         encontrado quando apenas um era esperado.
 *
 *         Esta exceção é lançada quando uma operação de busca retorna múltiplos
 *         registros,
 *         mas o contexto da operação esperava apenas um único registro.
 */
public class MaisDeUmRegistroException extends Exception {

	private static final long serialVersionUID = -7509649433607067138L;

	public MaisDeUmRegistroException(String msg) {
		super(msg);
	}

}
