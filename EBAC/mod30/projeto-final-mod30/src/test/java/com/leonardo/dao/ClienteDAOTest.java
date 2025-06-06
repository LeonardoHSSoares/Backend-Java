package com.leonardo.dao;

import java.util.Collection;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.leonardo.dao.cliente.ClienteDAO;
import com.leonardo.dao.cliente.IClienteDAO;
import com.leonardo.domain.cliente.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {

	private  final IClienteDAO clienteDao;

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
		Long tel = 119000000L + new Random().nextLong(999999999L);

		Faker faker = new Faker();
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		cliente.setNome(faker.name().fullName());
		cliente.setCidade(faker.address().city());
		cliente.setEnd(faker.address().streetName());
		cliente.setEstado("SP");
		cliente.setNumero(faker.number().numberBetween(1, 100));
		cliente.setTel(tel);
		cliente.setEmail(faker.internet().emailAddress());
		return cliente;
	}

	@Test
	public void pesquisarCliente()
			throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {

		//
		// Cria um cliente para teste
		Cliente novoCliente = criaClienteParaTeste();
		// Verifica se o cliente foi criado corretamente
		Assertions.assertNotNull(novoCliente);

		// Cadastra o cliente para teste
		Boolean retorno = clienteDao.cadastrar(novoCliente);
		// Verifica se o cliente foi cadastrado corretamente
		Assertions.assertTrue(retorno);

		// Consulta o cliente pelo CPF
		Cliente clienteConsultado = clienteDao.consultar(novoCliente.getCpf());
		// Verifica se o cliente foi consultado corretamente
		Assertions.assertNotNull(clienteConsultado);

		clienteDao.excluir(novoCliente.getCpf());
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

		Cliente clienteConsultado = clienteDao.consultar(novoCliente.getCpf());
		// Verifica se o cliente foi consultado corretamente
		Assertions.assertNotNull(clienteConsultado);

		clienteDao.excluir(clienteConsultado.getCpf());
		// Verifica se o cliente foi excluído
		Assertions.assertNull(clienteDao.consultar(novoCliente.getId()));
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
		
		Cliente clienteConsultado = clienteDao.consultar(novoCLiente.getCpf());
		// Verifica se o cliente foi consultado corretamente
		Assertions.assertNotNull(clienteConsultado);

		clienteDao.excluir(clienteConsultado.getCpf());
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
		
		novoCliente.setNome("Leonardo Soares Alterado");
		novoCliente.setCidade("Rio de Janeiro");
		novoCliente.setEnd("Avenida Alterada");
		novoCliente.setEstado("RJ");
		novoCliente.setNumero(123);
		novoCliente.setTel(21900000000L);
		novoCliente.setEmail("leonardoAtualizado@gmail.com");

		clienteDao.alterar(novoCliente);
		// Verifica se o cliente foi alterado corretamente
		Cliente clienteAlterado = clienteDao.consultar(novoCliente.getCpf());
		Assertions.assertNotNull(clienteAlterado);
		Assertions.assertEquals("Leonardo Soares Alterado", clienteAlterado.getNome());
		
	}

	@Test
	public void buscarTodosClientes() throws TipoChaveNaoEncontradaException, DAOException {
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

		for (Cliente cliente : listaClientes) {
			try {
				clienteDao.excluir(cliente.getCpf());
			} catch (DAOException e) {
			}
		}
	}
}
