@Tabela(nomeTabela = "produtos")
public class Produto {

    Long id = 0L;
    String nome = null;

    public Long gerarId(Long id) { return id += 1;}
}
