package com.leonardo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GenericDAOEntity<T, ID> implements IGenericDAO<T, ID> {

    private final EntityManager em;
    private final Class<T> classe;

    public GenericDAOEntity(EntityManager em, Class<T> classe) {
        this.em = em;
        this.classe = classe;
    }

    @Override
    public void salvar(T entidade) {

        // Implementação do método para salvar a entidade
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
    }

    @Override
    public T buscarPorId(ID id) {
        
        // Implementação do método para buscar a entidade por ID
        return em.find(classe, id);
    }

    @Override
    public void atualizar(T entidade) {

        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }

    @Override
    public void remover(T entidade) {

        // Implementação do método para remover a entidade
        em.getTransaction().begin();
        em.remove(em.contains(entidade) ? entidade : em.merge(entidade));
        em.getTransaction().commit();
    }

    @Override
    public List<T> listarTodos() {

        // Implementação do método para listar todas as entidades
        String jpql = "SELECT e FROM " + classe.getSimpleName() + " e";
        TypedQuery<T> query = em.createQuery(jpql, classe);
        
        return query.getResultList();
    }

}
