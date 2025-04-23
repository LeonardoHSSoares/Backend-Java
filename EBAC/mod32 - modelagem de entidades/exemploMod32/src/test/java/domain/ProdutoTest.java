package test.java.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.dao.ProdutoDao;
import main.java.domain.Produto;

public class ProdutoTest {

    @Test
    public void cadastrar() {
        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setPreco(10l);

        ProdutoDao produtoDao = new ProdutoDao();
        Produto produtoCadastrado = produtoDao.cadastrar(produto);

        Assertions.assertNotNull(produtoCadastrado);
        Assertions.assertEquals("Produto Teste", produtoCadastrado.getNome());
        Assertions.assertEquals(10.0, produtoCadastrado.getPreco());

    }
}
