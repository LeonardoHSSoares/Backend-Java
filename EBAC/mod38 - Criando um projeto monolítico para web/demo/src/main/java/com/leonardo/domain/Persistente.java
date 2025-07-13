package com.leonardo.domain;

/**
 * @author Leonardo Soares
 *         inferface representando uma entidade persistente
 *         com um identificador único.
 *         Este identificador é utilizado para operações de persistência
 *         em bancos de dados ou outros sistemas de armazenamento.
 *         A interface define métodos para obter e definir o ID da entidade.
 *         As classes que implementam esta interface devem fornecer
 *         uma implementação concreta desses métodos.
 */
public interface Persistente {

    public Long getId();

    public void setId(Long id);

}
