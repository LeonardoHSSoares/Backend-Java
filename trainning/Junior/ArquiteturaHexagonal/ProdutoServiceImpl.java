package trainning.Junior.ArquiteturaHexagonal;

import java.util.List;

import trainning.Junior.ArquiteturaHexagonal.Produto.ProdutoService;

public class ProdutoServiceImpl implements ProdutoService {
    private ProdutoRepository produtoRepository;

    
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto obterProdutoPorId(Long id) {
        return (Produto) ((Object) produtoRepository.findById(id));
    }
    
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public void salvarProduto(Produto produto) {
        // Lógica de negócios para salvar um produto
        produtoRepository.save(produto);
    }

    @Override
    public void removerProduto(Long id) {
        // Lógica de negócios para remover um produto
        produtoRepository.deleteById(id);
    }

    @Override
    public List<Produto> buscarProdutosPorNome(String nome) {
        // Lógica de negócios para buscar produtos por nome
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
    // Outros métodos relacionados à lógica de negócios
}