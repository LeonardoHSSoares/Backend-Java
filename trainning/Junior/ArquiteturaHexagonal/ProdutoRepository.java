package trainning.Junior.ArquiteturaHexagonal;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeContainingIgnoreCase(String nome);

    Object findById(Long id);

    List<Produto> findAll();

    void save(Produto produto);

    void deleteById(Long id);
}