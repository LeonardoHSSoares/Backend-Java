package com.leonardo.infrastructure.dao.generic;

import java.io.Serializable;

import com.leonardo.domain.Persistente;

public abstract class GenericJPADB2DAO<T extends Persistente, E extends Serializable>
        extends GenericJPADAO<T, E> {

    public GenericJPADB2DAO(Class<T> persistenteClass) {
        super(persistenteClass, "postgres2");
    }

    // Implementação de métodos específicos para o banco de dados B2, se necessário
    // Pode incluir métodos adicionais ou sobrecarga de métodos da classe pai

}
