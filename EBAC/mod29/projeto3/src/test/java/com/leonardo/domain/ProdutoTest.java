package com.leonardo.domain;

import java.sql.Connection;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.leonardo.dao.ProdutoDAO;
import com.leonardo.jdbc.ConnectionFactory;

public class ProdutoTest {

    private ProdutoDAO produtoDAO;
    private Connection connection;

    @BeforeEach
    public void setUp() throws Exception {
        connection = ConnectionFactory.getConnection();
        produtoDAO = new ProdutoDAO();
    }

    @AfterEach
    public void tearDown() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testCadastrarProduto() throws Exception {
        Produto produto = new Produto("Mouse Gamer", 199.90, "Mouse RGB com 6 botões");
        int resultado = produtoDAO.cadastrar(produto);
        assertEquals(1, resultado, "Erro ao cadastrar produto.");
    }

    @Test
    public void testAtualizarProduto() throws Exception {
        Produto produto = new Produto("Teclado Mecânico", 349.90, "Teclado RGB com switches azuis");
        produtoDAO.cadastrar(produto);

        produto.setDescricao("Teclado RGB com switches vermelhos");
        produto.setPreco(329.90);
        int resultado = produtoDAO.atualizar(produto);

        assertEquals(1, resultado, "Erro ao atualizar produto.");
    }

    @Test
    public void testBuscarProduto() throws Exception {
        Produto produto = new Produto("Monitor Full HD", 999.90, "Monitor de 24 polegadas");
        produtoDAO.cadastrar(produto);

        Produto produtoBuscado = produtoDAO.buscarEntidade(produto.getId_produto());
        assertNotNull(produtoBuscado, "Produto não encontrado.");
        assertEquals(produto.getNome(), produtoBuscado.getNome());
    }

    @Test
    public void testBuscarTodosProdutos() throws Exception {
        Produto produto1 = new Produto("Headset Gamer", 299.90, "Headset com som surround");
        Produto produto2 = new Produto("Cadeira Gamer", 1299.90, "Cadeira ergonômica preta");

        produtoDAO.cadastrar(produto1);
        produtoDAO.cadastrar(produto2);

        assertTrue(produtoDAO.buscarTodos().size() > 0, "Erro ao buscar todos os produtos.");
    }

    @Test
    public void testExcluirProduto() throws Exception {
        Produto produto = new Produto("Gabinete Gamer", 499.90,"Gabinete ATX com LED");
        produtoDAO.cadastrar(produto);

        int resultado = produtoDAO.excluirEntidade(produto);
        assertEquals(1, resultado, "Erro ao excluir produto.");
    }

}
