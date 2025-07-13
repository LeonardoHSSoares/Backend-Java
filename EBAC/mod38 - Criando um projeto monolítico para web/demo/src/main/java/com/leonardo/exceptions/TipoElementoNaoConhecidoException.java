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
 *
 */
public class TipoElementoNaoConhecidoException extends Exception {

    private static final long serialVersionUID = -2268140970978666251L;

    public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }

}
