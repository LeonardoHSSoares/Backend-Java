package com.leonardo.gateway.jpa;



import com.leonardo.domain.Persistente;
import com.leonardo.gateway.generic.IGenericJPAGateway;

/**
 * @author Leonardo Soares
 * Interface específica para operações de acesso a dados (DAO) relacionadas à entidade ClienteJPA.
 * Esta interface estende a interface genérica IGenericJPAGateway, especificando o tipo de entidade
 * e o tipo de chave única.
 *
 * @param <T> Tipo da entidade que estende Persistente.
 */

public interface IClienteJPAGateway<T extends Persistente> extends IGenericJPAGateway<T, Long> {

}
