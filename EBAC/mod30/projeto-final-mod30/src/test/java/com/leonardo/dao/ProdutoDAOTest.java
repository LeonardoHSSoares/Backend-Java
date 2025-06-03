package com.leonardo.dao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.leonardo.dao.produto.IProdutoDAO;
import com.leonardo.dao.produto.ProdutoDAO;
import com.leonardo.domain.produto.Produto;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDAOTest {

    private IProdutoDAO produtoDao;

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
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setPreco(BigDecimal.TEN);
        produto.setQuantidadeEstoque(1);
        produtoDao.cadastrar(produto);
        return produto;
    }

    private void excluir(String valor) throws DAOException {
        this.produtoDao.excluir(valor);
    }

    @Test
    public void pesquisar()
            throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
        Produto produto = criarProduto("A1");
        Assertions.assertNotNull(produto);
        Produto produtoDB = this.produtoDao.consultar(produto.getCodigo());
        Assertions.assertNotNull(produtoDB);
        excluir(produtoDB.getCodigo());
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
        UUID random = UUID.randomUUID();
        String codigo = random.toString().substring(0, 10);
        Produto produto = criarProduto(codigo);
        Assertions.assertNotNull(produto);
        // excluir(produto.getCodigo());
    }

    @Test
    public void excluir()
            throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Produto produto = criarProduto("A3");
        Assertions.assertNotNull(produto);
        excluir(produto.getCodigo());
        Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
        assertNull(produtoBD);
    }

    @Test
    public void alterarCliente()
            throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Produto produto = criarProduto("A4");
        produto.setNome("Rodrigo Pires");
        produtoDao.alterar(produto);
        Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        Assertions.assertEquals("Rodrigo Pires", produtoBD.getNome());

        excluir(produto.getCodigo());
        Produto produtoBD1 = this.produtoDao.consultar(produto.getCodigo());
        assertNull(produtoBD1);
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        criarProduto("A5");
        criarProduto("A6");
        Collection<Produto> list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        for (Produto prod : list) {
            excluir(prod.getCodigo());
        }

        list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 0);

    }
}
