package com.leonardo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.leonardo.domain.Produto;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Produto cadastrar(Produto produto) {

        // Criar o EntityManagerFactory e o EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Iniciar a transação
        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        // Fechar o EntityManager e o EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public void excluir(Produto produto) {

        // Criar o EntityManagerFactory e o EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Iniciar a transação
        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        // Fechar o EntityManager e o EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public List<Produto> buscar() {

        // Criar o EntityManagerFactory e o EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Criar a consulta usando Criteria API
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);
        query.select(root);

        // Executar a consulta
        TypedQuery<Produto> tpQuery = entityManager.createQuery(query);
        List<Produto> list = tpQuery.getResultList();

        // Fechar o EntityManager e o EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();

        // Retornar a lista de produtos
        return list;
    }

    @Override
    public Produto atualizar(Produto produtoAtualizado) {

        // Criar o EntityManagerFactory e o EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Iniciar a transação
        entityManager.getTransaction().begin();
        Produto produto = entityManager.merge(produtoAtualizado);
        entityManager.getTransaction().commit();

        // Fechar o EntityManager e o EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();

        // Retornar o produto atualizado
        return produto;
    }

}
