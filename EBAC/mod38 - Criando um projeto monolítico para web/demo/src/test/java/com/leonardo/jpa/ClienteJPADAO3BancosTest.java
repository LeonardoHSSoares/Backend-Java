package com.leonardo.jpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.leonardo.domain.jpa.ClienteJPA;
import com.leonardo.domain.jpa.ClienteJPA2;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.gateway.jpa.IClienteJPAGateway;
import com.leonardo.infrastructure.dao.jpa.ClienteJPADAO;
import com.leonardo.infrastructure.dao.jpa.ClienteJPADB2DAO;
import com.leonardo.infrastructure.dao.jpa.ClienteJPADB3DAO;

public class ClienteJPADAO3BancosTest {

    private IClienteJPAGateway<ClienteJPA> clienteDao;
	
	private IClienteJPAGateway<ClienteJPA> clienteDB2Dao;
	
	private IClienteJPAGateway<ClienteJPA2> clienteDB3Dao;
	
	private Random rd;
	
	public ClienteJPADAO3BancosTest() {
		this.clienteDao = new ClienteJPADAO();
		this.clienteDB2Dao = new ClienteJPADB2DAO();
		this.clienteDB3Dao = new ClienteJPADB3DAO();
		rd = new Random();
	}
	
	@AfterAll
	public void end() throws DAOException {
		Collection<ClienteJPA> list = clienteDao.buscarTodos();
		excluir(list, clienteDao);
		
		Collection<ClienteJPA> list2 = clienteDB2Dao.buscarTodos();
		excluir(list2, clienteDB2Dao);
		
		Collection<ClienteJPA2> list3 = clienteDB3Dao.buscarTodos();
		excluir3(list3);
	}
	
	private void excluir(Collection<ClienteJPA> list, IClienteJPAGateway<ClienteJPA> clienteDao) {
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	private void excluir3(Collection<ClienteJPA2> list) {
		list.forEach(cli -> {
			try {
				clienteDB3Dao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		ClienteJPA cliente = criarCliente();
		clienteDao.cadastrar(cliente);
		
		ClienteJPA clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);
		
		cliente.setId(null);
		clienteDB2Dao.cadastrar(cliente);
		
		ClienteJPA clienteConsultado2 = clienteDB2Dao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado2);
		
		ClienteJPA2 cliente2 = criarCliente2();
		clienteDB3Dao.cadastrar(cliente2);
		
		ClienteJPA2 clienteConsultado3 = clienteDB3Dao.consultar(cliente2.getId());
		Assertions.assertNotNull(clienteConsultado3);
		
	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJPA cliente = criarCliente();
		ClienteJPA retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);
		
		ClienteJPA clienteConsultado = clienteDao.consultar(retorno.getId());
		Assertions.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		
		ClienteJPA clienteConsultado1 = clienteDao.consultar(retorno.getId());
		Assertions.assertNull(clienteConsultado1);
	}
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJPA cliente = criarCliente();
		ClienteJPA retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);
		
		ClienteJPA clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJPA cliente = criarCliente();
		ClienteJPA retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);
		
		ClienteJPA clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Leonardo Soares 2");
		clienteDao.alterar(clienteConsultado);
		
		ClienteJPA clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		Assertions.assertNotNull(clienteAlterado);
		Assertions.assertEquals("Leonardo Soares 2", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
		Assertions.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJPA cliente = criarCliente();
		ClienteJPA retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);
		
		ClienteJPA cliente1 = criarCliente();
		ClienteJPA retorno1 = clienteDao.cadastrar(cliente1);
		Assertions.assertNotNull(retorno1);
		
		Collection<ClienteJPA> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<ClienteJPA> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
	
	private ClienteJPA criarCliente() {
		ClienteJPA cliente = new ClienteJPA();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Leonardo Soares");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}
	
	private ClienteJPA2 criarCliente2() {
		ClienteJPA2 cliente = new ClienteJPA2();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Leonardo Soares");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}
}
