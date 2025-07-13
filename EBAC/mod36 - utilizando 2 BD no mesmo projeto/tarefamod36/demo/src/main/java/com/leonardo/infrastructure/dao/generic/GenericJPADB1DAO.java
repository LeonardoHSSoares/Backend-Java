package com.leonardo.infrastructure.dao.generic;

import java.io.Serializable;

import com.leonardo.domain.Persistente;

public abstract class GenericJPADB1DAO<T extends Persistente, E extends Serializable>
        extends GenericJPADAO<T, E> {

    public GenericJPADB1DAO(Class<T> persistenteClass) {
        super(persistenteClass, "postgres");
    }

    // Implementação de métodos específicos para o banco de dados B1, se necessário
    // Pode incluir métodos adicionais ou sobrecarga de métodos da classe pai

}
