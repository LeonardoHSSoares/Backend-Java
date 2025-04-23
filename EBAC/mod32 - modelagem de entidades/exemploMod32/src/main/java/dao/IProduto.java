package main.java.dao;

import java.util.List;
import main.java.domain.Produto;

public interface IProduto {

    public Produto cadastrar(Produto produto);

    public void excluir(Produto produto);

    public List<Produto> listarProdutos();

}
