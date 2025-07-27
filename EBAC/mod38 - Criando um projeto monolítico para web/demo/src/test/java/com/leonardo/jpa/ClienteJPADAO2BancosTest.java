package com.leonardo.jpa;

import java.util.Collection;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.leonardo.domain.jpa.ClienteJPA;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.gateway.jpa.IClienteJPAGateway;
import com.leonardo.infrastructure.dao.jpa.ClienteJPADAO;
import com.leonardo.infrastructure.dao.jpa.ClienteJPADB2DAO;

public class ClienteJPADAO2BancosTest {

    private IClienteJPAGateway<ClienteJPA> clienteDao;
	
	private IClienteJPAGateway<ClienteJPA> clienteDB2Dao;
	
	private Random rd;
	
	public ClienteJPADAO2BancosTest() {
		this.clienteDao = new ClienteJPADAO();
		this.clienteDB2Dao = new ClienteJPADB2DAO();
		rd = new Random();
	}
	
	@AfterAll
	public void end() throws DAOException {
		Collection<ClienteJPA> list1 = clienteDao.buscarTodos();
		excluir1(list1);
		
		Collection<ClienteJPA> list2 = clienteDB2Dao.buscarTodos();
		excluir2(list2);
	}
	
	private void excluir1(Collection<ClienteJPA> list) {
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	private void excluir2(Collection<ClienteJPA> list) {
		list.forEach(cli -> {
			try {
				clienteDB2Dao.excluir(cli);
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
		
		clienteConsultado.setNome("Leonardo Soares");
		clienteDao.alterar(clienteConsultado);
		
		ClienteJPA clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		Assertions.assertNotNull(clienteAlterado);
		Assertions.assertEquals("Leonardo Soares", clienteAlterado.getNome());
		
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

	private ClienteJPA criarClienteDB2() {
		ClienteJPA cliente = new ClienteJPA();
		Faker faker = new Faker();
		cliente.setCpf(faker.number().randomNumber(11, true));
		cliente.setNome(faker.name().fullName());
		cliente.setCidade(faker.address().city());
		cliente.setEnd(faker.address().streetAddress());
		cliente.setEstado(faker.address().stateAbbr());
		cliente.setNumero(faker.number().numberBetween(1, 100));
		return cliente;
	}
}
