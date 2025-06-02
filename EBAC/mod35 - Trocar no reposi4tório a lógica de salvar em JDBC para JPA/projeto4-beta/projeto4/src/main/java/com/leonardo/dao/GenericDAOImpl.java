package com.leonardo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class GenericDAOImpl<T> implements GenericDAO<T> {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
    private final Class<T> entidade;

    public GenericDAOImpl(Class<T> entidade) {
        this.entidade = entidade;
    }

    @Override
    public void cadastrar(T entidade) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void atualizar(T entidade) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public T consultar(Long id) {
        EntityManager em = emf.createEntityManager();
        T obj = em.find(entidade, id);
        em.close();
        return obj;
    }

    @Override
    public void excluir(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T obj = em.find(entidade, id);
        if (obj != null) {
            em.remove(obj);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<T> buscarTodos() {
        EntityManager em = emf.createEntityManager();
        List<T> lista = em.createQuery("FROM " + entidade.getSimpleName(), entidade).getResultList();
        em.close();
        return lista;
    }

    
}