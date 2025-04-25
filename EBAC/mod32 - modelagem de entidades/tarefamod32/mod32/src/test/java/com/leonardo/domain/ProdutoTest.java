package com.leonardo.domain;

import org.junit.Test;

import com.leonardo.dao.ProdutoDAO;

public class ProdutoTest {

    private final ProdutoDAO produtoDAO;

    public ProdutoTest() {
        this.produtoDAO = new ProdutoDAO();
    }

    @Test
    public void cadastrarProduto() {

        // Cria um novo produto para teste
        Produto produto = new Produto("Smartwatch", "Relógio inteligente com monitoramento de saúde", 800.0);

        // cadastra o novo produto no db
        produtoDAO.cadastrar(produto);
    }

    @Test
    public void excluirProduto() {

        // Cria um novo produto para teste
        Produto produto = new Produto();
        
        // Define o ID procurado
        produto.setId(5L);

        // filtrando os produtos e excluindo o produto definido anteriormente
        Produto produtoExcluido = produtoDAO.buscar().stream()
                // Filtra o produto com o ID correspondente
                .filter(prod -> prod.getId().equals(produto.getId()))
                // Pega o primeiro produto encontrado
                .findFirst()
                // Se não encontrar, retorna null
                .orElse(null);
        // Exclui o produto
        produtoDAO.excluir(produtoExcluido);

    }

    

}
