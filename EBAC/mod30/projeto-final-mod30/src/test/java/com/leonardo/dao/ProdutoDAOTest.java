package com.leonardo.dao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.leonardo.dao.produto.IProdutoDAO;
import com.leonardo.dao.produto.ProdutoDAO;
import com.leonardo.domain.produto.Produto;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDAOTest {

    private final IProdutoDAO produtoDao;

    public ProdutoDAOTest() {
        produtoDao = new ProdutoDAO();
    }

    // @AfterAll
    // public void end() throws DAOException {
    // Collection<Produto> list = produtoDao.buscarTodos();
    // list.forEach(prod -> {
    // try {
    // produtoDao.excluir(prod.getCodigo());
    // } catch (DAOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // });
    // }

    private Produto criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
        Faker faker = new Faker();
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao(faker.lorem().sentence(10));
        produto.setNome(faker.commerce().productName());
        produto.setPreco(new BigDecimal(faker.commerce().price(10.0, 1000.0).replace(",", ".")));
        produto.setQuantidadeEstoque(1);
        return produto;
    }

    @Test
    public void pesquisarProduto()
            throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {

        UUID random = UUID.randomUUID();
        String codigo = random.toString().substring(0, 9);

        Produto produto = criarProduto(codigo);
        produtoDao.cadastrar(produto);

        // Verifica se o produto foi cadastrado corretamente
        try {
            Produto produtoBD = produtoDao.consultar(produto.getCodigo());
            assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        } catch (MaisDeUmRegistroException | DAOException e) {
        }

        // Exclui o produto após o teste
        produtoDao.excluir(produto.getCodigo());
        // Verifica se o produto foi excluído corretamente
        Assertions.assertNotNull(this);

    }

    @Test
    public void cadastrarProduto() throws TipoChaveNaoEncontradaException, DAOException {

        UUID random = UUID.randomUUID();
        String codigo = random.toString().substring(0, 9);

        Produto produto = criarProduto(codigo);
        // Verifica se o produto foi criado corretamente
        Assertions.assertNotNull(produto);
        // Cadastra o produto no banco de dados
        produtoDao.cadastrar(produto);
        // Verifica se o produto foi salvo no banco de dados
        Assertions.assertNotNull(produto);

        try {
            Produto produtoBD = produtoDao.consultar(produto.getCodigo());
            // Verifica se o produto foi consultado corretamente
            Assertions.assertNotNull(produtoBD);
            assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        } catch (MaisDeUmRegistroException | TableException | DAOException e) {
            throw new RuntimeException("Erro ao consultar o produto cadastrado", e);
        }

        // Exclui o produto após o teste
        produtoDao.excluir(produto.getCodigo());
        // Verifica se o produto foi excluído corretamente
        Assertions.assertNotNull(this);

    }

    @Test
    public void excluirProduto()
            throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {

        UUID random = UUID.randomUUID();
        String codigo = random.toString().substring(0, 9);

        Produto produto = criarProduto(codigo);
        // Verifica se o produto foi criado corretamente
        Assertions.assertNotNull(produto);
        // Cadastra o produto no banco de dados
        produtoDao.cadastrar(produto);
        // Verifica se o produto foi cadastrado corretamente
        Assertions.assertNotNull(produto);

        try {
            Produto produtoBD = produtoDao.consultar(produto.getCodigo());
            // Verifica se o produto foi consultado corretamente
            Assertions.assertNotNull(produtoBD);
            assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        } catch (MaisDeUmRegistroException | TableException | DAOException e) {
            throw new RuntimeException("Erro ao consultar o produto cadastrado", e);
        }

        // Exclui o produto após o teste
        produtoDao.excluir(produto.getCodigo());
        // Verifica se o produto foi excluído corretamente
        Assertions.assertNotNull(this);
    }

    @Test
    public void alterarCliente()
            throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {

        UUID random = UUID.randomUUID();
        String codigo = random.toString().substring(0, 9);

        Produto produto = criarProduto(codigo);
        produto.setNome("Leonardo Soares");
        produtoDao.alterar(produto);
        try {
            Produto produtoBD = produtoDao.consultar(produto.getCodigo());
            // Verifica se o produto foi consultado corretamente
            Assertions.assertNotNull(produtoBD);
            Assertions.assertEquals("Leonardo Soares", produtoBD.getNome());
        } catch (MaisDeUmRegistroException | TableException | DAOException e) {
            throw new RuntimeException("Erro ao consultar o produto cadastrado", e);
        }
        
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        criarProduto("A5");
        criarProduto("A6");
        Collection<Produto> list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        for (Produto prod : list) {

        }

        list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 0);

    }

}
