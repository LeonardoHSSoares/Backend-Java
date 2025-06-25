package com.leonardo.service;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.leonardo.domain.Produto;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.gateway.IProdutoGateway;
import com.leonardo.infrastructure.dao.ProdutoDAO;
import com.leonardo.service.produto.IProdutoService;
import com.leonardo.service.produto.ProdutoService;

public class ProdutoServiceTest {
    private final IProdutoService produtoService;

    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoGateway dao = new ProdutoDAO();
        produtoService = new ProdutoService(dao);
    }

    @BeforeEach
    public void init() {
        Faker faker = new Faker();
        produto = new Produto();
        String codigo = UUID.randomUUID().toString().substring(0, 9);
        produto.setCodigo(codigo);
        produto.setDescricao(faker.lorem().sentence(10));
        produto.setNome(faker.commerce().productName());
        produto.setPreco(new BigDecimal(faker.commerce().price(10.0, 1000.0).replace(",", ".")));
        produto.setQuantidadeEstoque(1);
    }

    @Test
    public void pesquisar() throws DAOException {

    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException {

    }

    @Test
    public void excluir() throws DAOException {
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterar() throws TipoChaveNaoEncontradaException, DAOException {
        produto.setNome("Leonardo Soares");
        produtoService.alterar(produto);

        Assertions.assertEquals("Leonardo Soares", produto.getNome());
    }
}
