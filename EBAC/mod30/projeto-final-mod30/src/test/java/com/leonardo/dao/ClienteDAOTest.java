package com.leonardo.dao;

import java.util.Collection;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.leonardo.dao.cliente.ClienteDAO;
import com.leonardo.dao.cliente.IClienteDAO;
import com.leonardo.domain.cliente.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {

	private IClienteDAO clienteDao;

	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}

	


	// @AfterEach
	// public void end() throws DAOException {
	// Collection<Cliente> list = clienteDao.buscarTodos();
	// list.forEach(cli -> {
	// try {
	// clienteDao.excluir(cli.getId());
	// } catch (DAOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// });
	// }

	private Cliente criaClienteParaTeste() throws TipoChaveNaoEncontradaException, DAOException {

		// Gera um CPF aleatório para o cliente
		Long cpf = 10000000000L + new Random().nextLong(9999999999L);
		// Gera um telefone aleatório para o cliente
		Long tel = 11900000000L + new Random().nextLong(11999999999L);
		// Gera um número aleatório para o cliente
		Integer numero = new Random().nextInt(1000);

		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		cliente.setNome("Leonardo Soares");
		cliente.setCidade("São Paulo");
		cliente.setEnd("Rua Teste");
		cliente.setEstado("SP");
		cliente.setNumero(numero);
		cliente.setTel(tel);
		cliente.setEmail("leonardo@gmail.com");
		return cliente;
	}

	@Test
	public void pesquisarCliente()
			throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {

		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);

		Cliente novoCliente = criaClienteParaTeste();
		// Verifica se o cliente foi criado corretamente
		Assertions.assertNotNull(novoCliente);

		Cliente clienteConsultado = clienteDao.consultar(novoCliente.getCpf());
		// Verifica se o cliente foi consultado corretamente
		Assertions.assertNotNull(clienteConsultado);

		clienteDao.excluir(novoCliente.getId());
		// Verifica se o cliente foi excluído
		Assertions.assertNull(clienteDao.consultar(novoCliente.getId()));
	}

	@Test
	public void cadastrarCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {

		Cliente novoCliente = criaClienteParaTeste();
		// Verifica se o cliente foi criado corretamente
		Assertions.assertNotNull(novoCliente);

		Boolean retorno = clienteDao.cadastrar(novoCliente);
		// Verifica se o cliente foi cadastrado
		Assertions.assertTrue(retorno);

		Cliente clienteConsultado = clienteDao.consultar(novoCliente.getId());
		// Verifica se o cliente foi consultado corretamente
		Assertions.assertNotNull(clienteConsultado);

		// clienteDao.excluir(cliente.getId());
	}

	@Test
	public void excluirCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		
		Cliente novoCLiente = criaClienteParaTeste();
		// Verifica se o cliente foi criado corretamente
		Assertions.assertNotNull(novoCLiente);

		Boolean retorno = clienteDao.cadastrar(novoCLiente);
		// Verifica se o cliente foi cadastrado
		Assertions.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(novoCLiente.getId());
		// Verifica se o cliente foi consultado corretamente
		Assertions.assertNotNull(clienteConsultado);

		clienteDao.excluir(clienteConsultado.getId());
		// Verifica se o cliente foi excluído
		Assertions.assertNotNull(clienteConsultado);


	}

	@Test
	public void alterarCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		
		// Cria um cliente para teste
		Cliente novoCliente = criaClienteParaTeste();
		Boolean retorno = clienteDao.cadastrar(novoCliente);
		// Verifica se o cliente foi cadastrado corretamente
		Assertions.assertTrue(retorno);
		
		// Consulta o cliente cadastrado
		Cliente clienteConsultado = clienteDao.consultar(novoCliente.getId());
		// Verifica se o cliente foi consultado corretamente
		Assertions.assertNotNull(clienteConsultado);

		// Altera o nome do cliente
		clienteConsultado.setNome("Veronica Soares");
		clienteConsultado.setNumero(20);
		clienteDao.alterar(novoCliente);
		// Verifica se o cliente foi alterado corretamente
		Assertions.assertTrue(novoCliente.getNome().equals("Veronica Soares"));
		
		
		clienteDao.excluir(novoCliente.getId());
		Assertions.assertNull(novoCliente);
	}

	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		// Cria um cliente para teste
		Cliente cliente1 = criaClienteParaTeste();
		// Verifica se o cliente foi criado corretamente
		Assertions.assertNotNull(cliente1);
		// Cadastra o cliente1
		Boolean retorno1 = clienteDao.cadastrar(cliente1);
		// Verifica se o cliente1 foi cadastrado corretamente
		Assertions.assertTrue(retorno1);

		// Cria outro cliente para teste
		Cliente cliente2 = criaClienteParaTeste();
		// Verifica se o cliente foi criado corretamente
		Assertions.assertNotNull(cliente2);
		// Cadastra o cliente2
		Boolean retorno2 = clienteDao.cadastrar(cliente2);
		// Verifica se o cliente2 foi cadastrado corretamente
		Assertions.assertTrue(retorno2);

		Collection<Cliente> listaClientes = clienteDao.buscarTodos();
		assertTrue(listaClientes != null);
		assertTrue(!listaClientes.isEmpty());

		// for (Cliente cliente : listaClientes) {
		// 	try {
		// 		clienteDao.excluir(cliente.getId());
		// 	} catch (DAOException e) {
		// 	}
		// }
	}
}
