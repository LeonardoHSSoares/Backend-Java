package test.java.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.java.dao.ProdutoDao;
import main.java.domain.Produto;

public class ProdutoTest {

    private ProdutoDao produtoDao;

    public ProdutoTest() {
        produtoDao = new ProdutoDao();
    }
    
    @Test
    public void cadastrar() {

        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setPreco(10l);

        produto = produtoDao.cadastrar(produto);

        Assertions.assertNotNull(produto);


    
    }
}
