package com.leonardo.jpa;



import java.math.BigDecimal;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.leonardo.domain.jpa.ProdutoJPA;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.gateway.jpa.IProdutoJPAGateway;
import com.leonardo.infrastructure.dao.jpa.ProdutoJPADAO;


public class ProdutoJPADAOTest {

	private IProdutoJPAGateway produtoDao;
	
	public ProdutoJPADAOTest() {
		this.produtoDao = new ProdutoJPADAO();
	}
	
	@AfterAll
	public void end() throws DAOException {
		Collection<ProdutoJPA> list = produtoDao.buscarTodos();
		list.forEach(cli -> {
			try {
				produtoDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		ProdutoJPA produto = criarProduto("A1");
		Assertions.assertNotNull(produto);
		ProdutoJPA produtoDB = this.produtoDao.consultar(produto.getId());
		Assertions.assertNotNull(produtoDB);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		ProdutoJPA produto = criarProduto("A2");
		Assertions.assertNotNull(produto);
	}
	
	@Test
	public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		ProdutoJPA produto = criarProduto("A3");
		Assertions.assertNotNull(produto);
		this.produtoDao.excluir(produto);
		ProdutoJPA produtoBD = this.produtoDao.consultar(produto.getId());
		assertNull(produtoBD);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		ProdutoJPA produto = criarProduto("A4");
		produto.setNome("Notebook Dell");
		produtoDao.alterar(produto);
		ProdutoJPA produtoBD = this.produtoDao.consultar(produto.getId());
		assertNotNull(produtoBD);
		Assertions.assertEquals("Notebook Dell", produtoBD.getNome());
	}
	
	@Test
	public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
		criarProduto("A5");
		criarProduto("A6");
		Collection<ProdutoJPA> list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		for (ProdutoJPA prod : list) {
			this.produtoDao.excluir(prod);
		}
		
		list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 0);
		
	}
	
	private ProdutoJPA criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
		ProdutoJPA produto = new ProdutoJPA();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produtoDao.cadastrar(produto);
		return produto;
	}
}
