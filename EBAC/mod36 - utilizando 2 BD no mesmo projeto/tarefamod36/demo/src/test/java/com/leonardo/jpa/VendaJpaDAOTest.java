package com.leonardo.jpa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.leonardo.domain.jpa.ClienteJPA;
import com.leonardo.domain.jpa.ProdutoJPA;
import com.leonardo.domain.jpa.VendaJPA;
import com.leonardo.domain.jpa.VendaJPA.Status;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.gateway.jpa.IClienteJPAGateway;
import com.leonardo.gateway.jpa.IProdutoJPAGateway;
import com.leonardo.gateway.jpa.IVendaJPAGateway;
import com.leonardo.infrastructure.dao.jpa.VendaJPADAO;

/**
 * Classe de teste para o VendaJpaDAO, que implementa as operações de acesso a
 * dados
 * para a entidade VendaJpa.
 * 
 * @author Leonardo Soares
 */
public class VendaJpaDAOTest {

	private IVendaJPAGateway vendaDao;

	private IVendaJPAGateway vendaExclusaoDao;

	private IClienteJPAGateway clienteDao;

	private IProdutoJPAGateway produtoDao;

	private Random rd;

	private ClienteJPA cliente;

	private ProdutoJPA produto;

	public VendaJpaDAOTest() {
		this.vendaDao = new VendaJPADAO();
		// vendaExclusaoDao = new VendaExclusaoJPADAO();
		// this.clienteDao = new ClienteJPADAO();
		// this.produtoDao = new ProdutoJPADAO();
		rd = new Random();
	}

	@BeforeEach
	public void init() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		this.cliente = cadastrarCliente();
		this.produto = cadastrarProduto("A1", BigDecimal.TEN);
	}

	@AfterEach
	public void end() throws DAOException {
		excluirVendas();
		excluirProdutos();
		clienteDao.excluir(this.cliente);
	}

	@Test
	public void pesquisar()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		VendaJPA venda = criarVenda("A1");
		VendaJPA retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		VendaJPA vendaConsultada = vendaDao.consultar(venda.getId());
		assertNotNull(vendaConsultada);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	}

	@Test
	public void salvar()
			throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		VendaJPA venda = criarVenda("A2");
		VendaJPA retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);

		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));

		VendaJPA vendaConsultada = vendaDao.consultar(venda.getId());
		assertTrue(vendaConsultada.getId() != null);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	}

	@Test
	public void cancelarVenda()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A3";
		VendaJPA venda = criarVenda(codigoVenda);
		VendaJPA retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		retorno.setStatus(Status.CANCELADA);
		vendaDao.cancelarVenda(venda);

		VendaJPA vendaConsultada = vendaDao.consultar(venda.getId());
		assertEquals(codigoVenda, vendaConsultada.getCodigo());
		assertEquals(Status.CANCELADA, vendaConsultada.getStatus());
	}

	@Test
	public void adicionarMaisProdutosDoMesmo()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A4";
		VendaJPA venda = criarVenda(codigoVenda);
		VendaJPA retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		VendaJPA vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(produto, 1);

		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(30).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void adicionarMaisProdutosDiferentes()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A5";
		VendaJPA venda = criarVenda(codigoVenda);
		VendaJPA retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		ProdutoJPA prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());

		// TODO Usando este método apra evitar a exception
		// org.hibernate.LazyInitializationException
		// Ele busca todos os dados da lista pois a mesma por default é lazy
		VendaJPA vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);

		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void salvarVendaMesmoCodigoExistente() throws TipoChaveNaoEncontradaException, DAOException {
		VendaJPA venda = criarVenda("A6");
		VendaJPA retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);

		VendaJPA venda1 = criarVenda("A6");

		assertThrows(DAOException.class, () -> {
			vendaDao.cadastrar(venda1);
		});

		assertTrue(venda.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void removerProduto()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A7";
		VendaJPA venda = criarVenda(codigoVenda);
		VendaJPA retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		ProdutoJPA prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());

		VendaJPA vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));

		vendaConsultada.removerProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
		valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void removerApenasUmProduto()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A8";
		VendaJPA venda = criarVenda(codigoVenda);
		VendaJPA retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		ProdutoJPA prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());

		VendaJPA vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));

		vendaConsultada.removerProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
		valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void removerTodosProdutos()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A9";
		VendaJPA venda = criarVenda(codigoVenda);
		VendaJPA retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		ProdutoJPA prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());

		VendaJPA vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
		assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));

		vendaConsultada.removerTodosProdutos();
		assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 0);
		assertTrue(vendaConsultada.getValorTotal().equals(BigDecimal.valueOf(0)));
		assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
	}

	@Test
	public void finalizarVenda()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A10";
		VendaJPA venda = criarVenda(codigoVenda);
		VendaJPA retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		venda.setStatus(Status.CONCLUIDA);
		vendaDao.finalizarVenda(venda);

		VendaJPA vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());
	}

	@Test
	public void tentarAdicionarProdutosVendaFinalizada()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A11";
		VendaJPA venda = criarVenda(codigoVenda);
		VendaJPA retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());

		venda.setStatus(Status.CONCLUIDA);
		vendaDao.finalizarVenda(venda);

		VendaJPA vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());

		vendaConsultada.adicionarProduto(this.produto, 1);

		assertThrows(UnsupportedOperationException.class, () -> {
			vendaDao.alterar(vendaConsultada);
		}, "Não é possível adicionar produtos a uma venda finalizada.");

	}

	private void excluirProdutos() throws DAOException {
		Collection<ProdutoJPA> list = this.produtoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				this.produtoDao.excluir(prod);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private void excluirVendas() throws DAOException {
		Collection<VendaJPA> list = this.vendaExclusaoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				this.vendaExclusaoDao.excluir(prod);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private ProdutoJPA cadastrarProduto(String codigo, BigDecimal valor)
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ProdutoJPA produto = new ProdutoJPA();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(valor);
		produtoDao.cadastrar(produto);
		return produto;
	}

	private ClienteJPA cadastrarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJPA cliente = new ClienteJPA();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		clienteDao.cadastrar(cliente);
		return cliente;
	}

	private VendaJPA criarVenda(String codigo) {
		VendaJPA venda = new VendaJPA();
		venda.setCodigo(codigo);
		venda.setDataVenda(Instant.now());
		venda.setCliente(this.cliente);
		venda.setStatus(Status.INICIADA);
		venda.adicionarProduto(this.produto, 2);
		return venda;
	}
}
