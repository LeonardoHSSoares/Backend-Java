package com.leonardo;

import org.junit.Assert;
import org.junit.Test;

import com.leonardo.dao.cliente.ClienteDAO;
import com.leonardo.domain.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class ClienteTest {

    // @Test
    // public void cadastrarCliente() throws TipoChaveNaoEncontradaException, DAOException {
    //     Cliente cliente = new Cliente();
    //     cliente.setNome("Leonardo");
    //     cliente.setCpf(12345678901L);
    //     cliente.setTel(11999999999L);
    //     cliente.setEmail("asdsd@gmail.com");
    //     cliente.setEnd("Rua A");
    //     cliente.setNumero(123);
    //     cliente.setCidade("São Paulo");
    //     cliente.setEstado("SP");

    //     ClienteDAO dao = new ClienteDAO();
    //     Cliente salvo = dao.cadastrar(cliente);

    //     Assert.assertNotNull(salvo);
    //     Assert.assertEquals("Leonardo", salvo.getNome());
    // }

    // @Test
    // public void consultarCliente() throws Exception {
    //     ClienteDAO dao = new ClienteDAO();
    //     Cliente cliente = dao.consultar(12345678901L);
    //     Assert.assertNotNull(cliente);
    //     Assert.assertEquals("Leonardo", cliente.getNome());
    // }

    // @Test
    // public void alterarCliente() throws Exception {
    //     ClienteDAO dao = new ClienteDAO();
    //     Cliente cliente = dao.consultar(12345678901L);
    //     cliente.setNome("Leonardo Silva");
    //     Cliente alterado = dao.alterar(cliente);
    //     Assert.assertEquals("Leonardo Silva", alterado.getNome());
    // }

    // @Test
    // public void excluirCliente() throws Exception {
    //     ClienteDAO dao = new ClienteDAO();
    //     Cliente cliente = dao.consultar(12345678901L);
    //     dao.excluir(cliente);
    //     Cliente excluido = dao.consultar(12345678901L);
    //     Assert.assertNull(excluido);
    // }
}
