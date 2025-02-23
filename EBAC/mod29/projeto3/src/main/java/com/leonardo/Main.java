package com.leonardo;

import java.util.ArrayList;
import java.util.List;

import com.leonardo.dao.ClienteDAO;
import com.leonardo.dao.ProdutoDAO;
import com.leonardo.domain.Produto;

public class Main {

    public static void main(String[] args) throws Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        //--Buscar todos os produtos
        // List<Produto> produtos = new ArrayList<>();

        // produtos = produtoDAO.buscarTodos();

        // for (Produto produto : produtos) {
        //     System.out.println(produto.toString());
        // }
        //-- Cria produto e cadastra
        // String nome = "Notebook Asus";
        // String descricao = "Notebook gamer";
        // Double preco = 3000.00;
        // Produto produto = new Produto(nome, preco, descricao);

        // produtoDAO.cadastrar(produto);

        //--exclui produto no banco de dados
        // Produto produto = new Produto(1l);
        // produtoDAO.excluirEntidade(produto);

       

        // --Cria cliente e cadastra
        // Cliente novoCliente = new Cliente("leonardo", "6666666");
        // clienteDAO.cadastrar(novoCliente);

        // --Buscar todos Clientes
        // List<Cliente> clientes = new ArrayList<>();
        // clientes = clienteDAO.buscarTodos();

        // for (Cliente cliente : clientes) {
        //     System.out.println(cliente.toString());
        // }

        //--Busca Todos os produtos
        List<Produto> produtos = new ArrayList<>();
        
        produtos = produtoDAO.buscarTodos();

        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }

        // --Buscar um unico cliente
        // Cliente clienteBD = clienteDAO.buscarEntidade(cliente.getId_cliente());
        // System.out.println(clienteBD.toString());

        // --exclui cliente
        // clienteDAO.excluirEntidade(new Cliente(21l));
    }
}
